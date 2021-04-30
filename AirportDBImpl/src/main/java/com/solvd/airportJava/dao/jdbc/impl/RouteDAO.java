package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IRouteDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends AbstractJDBCDAO implements IRouteDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_ROUTE = "INSERT INTO Routes (Airports_id_from, Airports_id_to) VALUES (?,?)";
    private static final String GET_ROUTE_BY_ID = "SELECT * FROM Routes WHERE id = ?";
    private static final String UPDATE_ROUTE = "UPDATE Routes SET Airports_id_from = ?, Airports_id_to = ? WHERE id=?";
    private static final String DELETE_ROUTE = "DELETE FROM Routes WHERE id = ?";
    private static final String GET_ROUTE_BY_AIRPORT_FROM_ID = "SELECT * FROM Routes WHERE Airports_id_from = ?";
    private static final String GET_ROUTE_BY_AIRPORT_TO_ID  = "SELECT * FROM Routes WHERE Airports_id_to = ?";

    @Override
    public void create(Route route) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_ROUTE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, route.getAirportFromId());
            ps.setInt(2, route.getAirportToId());
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
    public Route getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Route route = new Route();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ROUTE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            route.setId(rs.getInt("id"));
            route.setAirportFromId(rs.getInt("Airports_id_from"));
            route.setAirportToId(rs.getInt("Airports_id_to"));
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
        return route;
    }

    @Override
    public void update(Route route) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_ROUTE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, route.getAirportFromId());
            ps.setInt(2, route.getAirportToId());
            ps.setInt(3, route.getId());
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
            ps = c.prepareStatement(DELETE_ROUTE, Statement.RETURN_GENERATED_KEYS);
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
    public List<Route> getByAirportFromId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Route> routes = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ROUTE_BY_AIRPORT_FROM_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setAirportFromId(rs.getInt("Airports_id_from"));
                route.setAirportToId(rs.getInt("Airports_id_to"));
                routes.add(route);
            }
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
        return routes;
    }

    @Override
    public List<Route> getByAirportToId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Route> routes = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_ROUTE_BY_AIRPORT_TO_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Route route = new Route();
                route.setId(rs.getInt("id"));
                route.setAirportFromId(rs.getInt("Airports_id_from"));
                route.setAirportToId(rs.getInt("Airports_id_to"));
                routes.add(route);
            }
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
        return routes;
    }
}
