package sqlite;

import java.sql.*;

public class Select {

    private Connection connect() {
        String url = "jdbc:sqlite:TestSQLite.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.createStatement().execute("create table if not exists Users (\n" +
                    "\tid integer primary key autoincrement,\n" +
                    "\tname varchar(20) not null,\n" +
                    "\tphone varchar(20) default null\n" +
                    ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT id,name,phone from Users WHERE name like '%Petya%';";

        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

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