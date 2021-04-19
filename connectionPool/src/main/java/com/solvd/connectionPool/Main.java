package com.solvd.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static ConnectionPool pool = ConnectionPool.getConnectionPool();
    private static final Logger logger  = LogManager.getLogger(Main.class);
    private static final int Executions = 10;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(Executions);

        for(long i = 0; i < Executions; i++){
            executor.execute(new ConnectionRunnable(i, pool));
            logger.info("Executing thread");
        }
        logger.info("Threads execution finalized");
    }
}
