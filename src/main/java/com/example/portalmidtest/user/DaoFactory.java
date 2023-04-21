package com.example.portalmidtest.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        UserDao userDao = new UserDao(jdbcContext());
        return userDao;
    }

    private JdbcContext jdbcContext() throws ClassNotFoundException {
        JdbcContext jdbcContext = new JdbcContext(dataSource());
        return jdbcContext;
    }

    private String username = "jeju";
    private String password = "jejupw";
    private String className = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/jeju";

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

}
