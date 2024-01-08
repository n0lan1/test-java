package mysql.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/somedb", "someuser", "somepass");
            conn.createStatement().execute("create table if not exists Users (\n" +
                    "\tid int primary key auto_increment,\n" +
                    "\tname varchar(20) not null,\n" +
                    "\tphone varchar(20) default null\n" +
                    ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "update Users set name=? where id=?";

        try (Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Henry");
            stmt.setInt(2, 3);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Update app = new Update();
        app.selectAll();
    }
}