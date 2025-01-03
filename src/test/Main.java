package test;

import com.mysql.cj.jdbc.Driver;
import test.util.ConnectionManager;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Введите id автомобиля:");
////        String carId = new Scanner(System.in).nextLine();
//        int carId = Integer.parseInt(new Scanner(System.in).nextLine());
        // Эту строку вместо закомментированной сверху мы используем чтобы
        // избежать SQL инъекций, когда там будут писать OR (строку) - программа не сработает
//        System.out.println("Введите марку автомобиля:");
//        String nameCar = (new Scanner(System.in).nextLine()).trim();

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
//        String str5 = "SELECT id, name, speed FROM cars WHERE id = " + carId;
//        String str5 = "SELECT id, name, speed FROM cars WHERE id = ? OR name = ?";
        String str5 = "SELECT id, name, speed FROM cars WHERE id >= ?";
        String str6 = "INSERT INTO cars (name, speed) VALUES " +
                "('SUBARU', 777.0);";
        String str7 = "DELETE FROM cars WHERE id = 3";
        String str8 = "DELETE FROM cars WHERE id = 5";
        String str9 = "DELETE FROM cars WHERE id = 6";

        try {
            Connection connection = ConnectionManager.open();
//            Statement statement = connection.createStatement();
//            PreparedStatement preparedStatement = connection.prepareStatement(str5);
            Statement statement = connection.createStatement();

            statement.addBatch(str7);
            // Этот метод используется для того чтобы добавить то что указано в парамере
            // в дальнейшее удаление через метод executeBatch()
            statement.addBatch(str8);
            statement.addBatch(str9);

            statement.executeBatch();

////            preparedStatement.setInt(1, carId);
////            preparedStatement.setMaxRows(3);
////  Этот метод нужен чтобы при вводе, например id = 1 мы могли получить столько записей,
////  сколько указано в параметре метода setMaxRows(3), начиная с того id который мы ввели
//            preparedStatement.setFetchSize(3);
// Этот метод используется для того чтобы данные нам выбирались порциями по столько
// записей, сколько указано в параметре метода setFetchSize(3).
// Отображаться будут все записи, но выбираться под капотом они будут по столько

////            preparedStatement.setString(2, nameCar);
////            ResultSet resultSet = statement.executeQuery(str5);
////            statement.execute(str5);
//            preparedStatement.execute();
//            ResultSet resultSet = statement.getResultSet();
//            ResultSet resultSet = preparedStatement.getResultSet();
//            while (resultSet.next()) {
////                System.out.print(resultSet.getString(3) + " - ");
////                System.out.println(resultSet.getDouble("speed"));
//                System.out.print(resultSet.getInt("id") + " ");
//                System.out.print(resultSet.getString("name") + " ");
//                System.out.println(resultSet.getDouble("speed"));
//            }
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