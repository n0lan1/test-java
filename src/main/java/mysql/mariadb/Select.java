package mysql.mariadb;

import java.sql.*;

public class Select {

    private Connection connect() {
        Connection conn = null;
        //changesssss
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/somedb", "someuser", "somepass");
            System.out.println("Connection to MariaDB is established");
            conn.createStatement().execute("create table if not exists Users (\n" +
                    "\tid int primary key auto_increment,\n" +
                    "\tname varchar(20) not null,\n" +
                    "\tphone varchar(20) default null\n" +
                    ");");
            System.out.println("Tables created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT id,name,phone from Users;";

        try (Connection conn = this.connect()) {

            String sqlCreate = "INSERT INTO Users (name, phone) values\n" +
                    "\t('Petya', '125453'),\n" +
                    "\t('Vasya', '654321'),\n" +
                    "\t('Katya', null);";

            Statement stmtCreate = conn.createStatement();
            stmtCreate.execute(sqlCreate);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Select app = new Select();
        app.selectAll();
    }
}