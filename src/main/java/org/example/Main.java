package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Class<Driver> driverClass = Driver.class;

        String str = "CREATE TABLE IF NOT EXISTS cars (" +
                     "id INT PRIMARY KEY AUTO_INCREMENT," +
                     "name VARCHAR(255)," +
                     "speed DOUBLE )";
        String str2 = "DROP TABLE IF EXISTS cars;";

        try {
            Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();
//            statement.executeUpdate(str);
            statement.executeUpdate(str2);

            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}