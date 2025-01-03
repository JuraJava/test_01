package dao;

public class CarDao {
    private static final CarDao INSTANCE = new CarDao();

    private CarDao() {
    }
    // Конструктор созаём приватным чтобы никто не смог
    // создать экземпляр класса

    public static CarDao getInstance() {
        return INSTANCE;
    // т.к. в этом классе только одно поле, то этот метод и будет его возвращать
    }
    // Этот метод добавляется, т.к. выше мы создаём приватный конструктор

}

