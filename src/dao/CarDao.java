package dao;

import java.sql.Connection;
import util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDao {

    private static final CarDao INSTANCE = new CarDao();

    private static final String DELETE_SQL = "DELETE FROM cars WHERE id = ?;";

    private CarDao() {
    }
    // Конструктор созаём приватным чтобы никто не смог
    // создать экземпляр класса

    public static void delete(int id) throws SQLException {
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

