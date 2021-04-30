package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IAirlineDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Airline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AirlineDAO extends AbstractJDBCDAO implements IAirlineDAO {
    private static final Logger logger = LogManager.getLogger(AirlineDAO.class);
    private static final String CREATE_AIRLINE = "INSERT INTO Airlines (name) VALUES (?)";
    private static final String GET_AIRLINE_BY_ID = "SELECT * FROM Airlines WHERE id = ?";
    private static final String UPDATE_AIRLINE = "UPDATE Airlines SET name = ? WHERE id=?";
    private static final String DELETE_AIRLINE = "DELETE FROM Airlines WHERE id = ?";

    @Override
    public void create(Airline airline) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_AIRLINE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, airline.getName());
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
    public Airline getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Airline airline = new Airline();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRLINE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            airline.setId(rs.getInt("id"));
            airline.setName(rs.getString("name"));
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
        return airline;
    }

    @Override
    public void update(Airline airline) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_AIRLINE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, airline.getName());
            ps.setInt(2, airline.getId());
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
            ps = c.prepareStatement(DELETE_AIRLINE, Statement.RETURN_GENERATED_KEYS);
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
}
