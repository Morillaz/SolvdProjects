package com.solvd.airportJava.dao.jdbc;


import com.solvd.airportJava.connections.ConnectionPool;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractJDBCDAO {
    private static final Logger logger = LogManager.getLogger(AbstractJDBCDAO.class);
    private final BasicDataSource cp = ConnectionPool.getDataSource();

    public BasicDataSource getCp() {
        return cp;
    }
}
