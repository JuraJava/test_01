package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите id автомобиля:");
        String carId = new Scanner(System.in).nextLine();

        Class<Driver> driverClass = Driver.class;

        String str1 = "CREATE TABLE IF NOT EXISTS cars (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "speed DOUBLE )";
        String str2 = "DROP TABLE IF EXISTS cars;";
        String str3 = "INSERT INTO cars VALUES " +
                "(4,'Mazda', 150.0)," +
                "(5, 'BMW', 225.0)," +
                "(6, 'AUDI', 200.0);";
        String str4 = "UPDATE cars SET speed=333.0 " +
                "WHERE id IN (4, 5, 6)";
//        String str5 = "SELECT id, speed, name FROM cars WHERE name='BMW'";
        String str5 = "SELECT id, name, speed FROM cars WHERE id = " + carId;
        String str6 = "INSERT INTO cars (name, speed) VALUES " +
                "('SUBARU', 777.0);";
        try {
            Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();

//            ResultSet resultSet = statement.executeQuery(str5);
            statement.execute(str5);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
//                System.out.print(resultSet.getString(3) + " - ");
//                System.out.println(resultSet.getDouble("speed"));
                System.out.print(resultSet.getInt("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getDouble("speed"));
            }
// Этот цикл используется для того чтобы выбираемые из таблицы данные отображались понятно

//            System.out.println(resultSet);

//            statement.executeUpdate(str1);
//            statement.executeUpdate(str2);
//            int temp1 = statement.executeUpdate(str3);
//            int temp1 = statement.executeUpdate(str4);
//            boolean temp2 = statement.execute(str4);
//            System.out.println(connection.getTransactionIsolation());
//            System.out.println("Значение переменной temp " + temp1);
//            System.out.println("Значение переменной temp " + temp2);
//            System.out.println("Количество вставленных записей = " + statement.getUpdateCount());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}