package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IOrderDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbstractJDBCDAO implements IOrderDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_ORDER = "INSERT INTO Orders (People_id, Flights_id, price) VALUES (?,?,?)";
    private static final String GET_ORDER_BY_ID = "SELECT * FROM Orders WHERE id = ?";
    private static final String UPDATE_ORDER = "UPDATE Orders SET People_id = ?, Flights_id = ?, price = ? WHERE id=?";
    private static final String DELETE_ORDER = "DELETE FROM Orders WHERE id = ?";
    private static final String GET_ORDERS_BY_PERSON_ID = "SELECT * FROM Orders WHERE People_id = ?";
    private static final String GET_ORDERS_BY_FLIGHT_ID  = "SELECT * FROM Orders WHERE Flights_id = ?";

    @Override
    public void create(Order order) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getPeopleId());
            ps.setInt(2, order.getFlightId());
            ps.setDouble(3, order.getPrice());
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public Order getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order order = new Order();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ORDER_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            order.setId(rs.getInt("id"));
            order.setPeopleId(rs.getInt("People_id"));
            order.setFlightId(rs.getInt("Flight_id"));
            order.setPrice(rs.getDouble("price"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return order;
    }

    @Override
    public void update(Order order) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_ORDER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getPeopleId());
            ps.setInt(2, order.getFlightId());
            ps.setDouble(3, order.getPrice());
            ps.setInt(4, order.getId());
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(DELETE_ORDER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public List<Order> getByPersonId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ORDERS_BY_PERSON_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setPeopleId(rs.getInt("People_id"));
                order.setFlightId(rs.getInt("Flights_id"));
                order.setPrice(rs.getDouble("price"));
                orders.add(order);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return orders;
    }

    @Override
    public List<Order> getByFlightId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ORDERS_BY_FLIGHT_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setPeopleId(rs.getInt("People_id"));
                order.setFlightId(rs.getInt("Flights_id"));
                order.setPrice(rs.getDouble("price"));
                orders.add(order);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return orders;
    }
}
