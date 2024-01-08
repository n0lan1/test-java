package mysql.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static void connect() {
        Connection conn = null;
        try {
            //creates a connection to database
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/somedb", "someuser", "somepass");
            System.out.println("Connection to MariaDB is established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
