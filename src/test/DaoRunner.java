package test;

import test.dao.CarDao;

import java.sql.SQLException;

public class DaoRunner {
    public static void main(String[] args) throws SQLException {
        CarDao carDao = CarDao.getInstance();
//        carDao.delete(4);
//        carDao.addNewCar(3, "Mercedes", 311.0);
        System.out.println(carDao.getAllCars());
    }
}
