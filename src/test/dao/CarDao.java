package test.dao;

import java.sql.Connection;

import test.entity.Car;
import test.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private static final CarDao INSTANCE = new CarDao();

    private static final String DELETE_SQL = "DELETE FROM cars WHERE id = ?;";

    private static final String ADD_NEW_CAR_SQL = "INSERT INTO cars(id, name, speed)" +
                                                  "VALUE (?, ?, ?);";
    private static final String GET_ALL_CARS = "SELECT id, name, speed FROM cars;";

    private CarDao() {
    }
    // Конструктор создаём приватным чтобы никто не смог
    // создать экземпляр класса

    public List<Car> getAllCars() throws SQLException {
        Connection connection = ConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARS);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Car> cars = new ArrayList<>();
        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getInt("id"));
            car.setName(resultSet.getString("name"));
            car.setSpeed(resultSet.getDouble("speed"));
            cars.add(car);
        }
        return cars;
    }

    public  void addNewCar(int id, String name, double speed) throws SQLException {
        Connection connection = ConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CAR_SQL);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setDouble(3, speed);
        preparedStatement.executeUpdate();
    }

    public  void delete(int id) throws SQLException {
        Connection connection = ConnectionManager.get();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }


    public static CarDao getInstance() {
        return INSTANCE;
        // т.к. в этом классе только одно поле, то этот метод и будет его возвращать
    }
    // Этот метод добавляется, т.к. выше мы создаём приватный конструктор

}

