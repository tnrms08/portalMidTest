package com.example.portalmidtest.user;

public class DaoFactory {
    public UserDao getUserDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    private ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
