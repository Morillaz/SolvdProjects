package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.ICountryDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class CountryDAO extends AbstractJDBCDAO implements ICountryDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_COUNTRY = "INSERT INTO Countries (name) VALUES (?)";
    private static final String GET_COUNTRY_BY_ID = "SELECT * FROM Countries WHERE id = ?";
    private static final String UPDATE_COUNTRY = "UPDATE Countries SET name = ? WHERE id=?";
    private static final String DELETE_COUNTRY = "DELETE FROM Countries WHERE id = ?";

    @Override
    public void create(Country country) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_COUNTRY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, country.getName());
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
    public Country getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Country country = new Country();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_COUNTRY_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
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
        return country;
    }

    @Override
    public void update(Country country) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_COUNTRY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, country.getName());
            ps.setInt(2, country.getId());
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
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(DELETE_COUNTRY, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
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
}

