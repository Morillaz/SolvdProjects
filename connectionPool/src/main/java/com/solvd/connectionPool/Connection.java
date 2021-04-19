package com.solvd.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger logger = LogManager.getLogger(Connection.class);
    private int connectionNumber;

    public Connection(int connectionNumber){
        this.connectionNumber = connectionNumber;
    }

    public void closeConnection(){
    }

    public void simulate(){
        logger.info("This method does nothing");
    }

    public int getNumber() {
        return this.connectionNumber;
    }

}
