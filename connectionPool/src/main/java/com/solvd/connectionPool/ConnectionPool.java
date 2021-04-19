package com.solvd.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connections;
    private static final int MAX_CONNECTIONS = 5;
    private int connectionsNumber;

    private ConnectionPool(){
        connections = new LinkedBlockingQueue<>(MAX_CONNECTIONS);
        this.connectionsNumber = 0;
    }

    public static ConnectionPool getConnectionPool(){
        if (instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized void initConnection() {
        connections.add(new Connection(connectionsNumber));
        connectionsNumber++;
    }

    public void addConnection(Connection connection) {
        connections.offer(connection);
    }

    public void closeConnections(){
        connections.forEach(Connection::closeConnection);
        connections = new LinkedBlockingQueue<Connection>(MAX_CONNECTIONS);
        connectionsNumber = 0;
    }

    public Connection getConnection() throws InterruptedException {
        if(connectionsNumber < MAX_CONNECTIONS) {
            initConnection();
        }
        return connections.take();
    }
}