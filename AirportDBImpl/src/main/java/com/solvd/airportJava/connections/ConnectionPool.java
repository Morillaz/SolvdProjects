package com.solvd.airportJava.connections;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static BasicDataSource dataSource;
    public static BasicDataSource getDataSource(){
        if (dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/airportDB");
            dataSource.setUsername("root");
            dataSource.setPassword("password");
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxOpenPreparedStatements(150);
        }
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}