package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.ICityDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends AbstractJDBCDAO implements ICityDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_CITY = "INSERT INTO Cities (name, States_id) VALUES (?,?)";
    private static final String GET_CITY_BY_ID = "SELECT * FROM Cities WHERE id = ?";
    private static final String UPDATE_CITY = "UPDATE Cities SET name = ?, States_id = ? WHERE id=?";
    private static final String DELETE_CITY = "DELETE FROM Cities WHERE id = ?";
    private static final String GET_CITY_BY_STATE_ID = "SELECT * FROM Cities WHERE States_id = ?";


    @Override
    public void create(City city) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_CITY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, city.getName());
            ps.setInt(2, city.getStateId());
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
    public City getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        City city = new City();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_CITY_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            city.setStateId(rs.getInt("States_id"));
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
        return city;
    }

    @Override
    public void update(City city) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_CITY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, city.getName());
            ps.setInt(2, city.getStateId());
            ps.setInt(3, city.getId());
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
            ps = c.prepareStatement(DELETE_CITY, Statement.RETURN_GENERATED_KEYS);
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
    public List<City> getByStateId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<City> cities = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_CITY_BY_STATE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                city.setStateId(rs.getInt("States_id"));
                cities.add(city);
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
        return cities;
    }
}
