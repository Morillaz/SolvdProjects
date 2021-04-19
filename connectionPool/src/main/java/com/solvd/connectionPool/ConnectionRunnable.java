package com.solvd.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionRunnable implements Runnable{
    private static final Logger logger = LogManager.getLogger(ConnectionRunnable.class);
    private final long id;
    private final ConnectionPool pool;

    public ConnectionRunnable(Long id, ConnectionPool pool) {
        this.id = id;
        this.pool = pool;
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = pool.getConnection();
            connection.simulate();
            pool.addConnection(connection);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
    }

    public long getId() {
        return id;
    }

    public ConnectionPool getPool() {
        return pool;
    }
}
