package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
        private static final String HOST = "jdbc:mysql://localhost:3306/base";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "1111";
        private Connection connection;


        public Connection getConnection() {
            try {
                connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
}

