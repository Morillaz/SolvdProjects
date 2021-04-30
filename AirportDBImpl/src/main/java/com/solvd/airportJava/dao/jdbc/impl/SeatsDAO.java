package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.ISeatsDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Seats;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatsDAO extends AbstractJDBCDAO implements ISeatsDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_SEATS = "INSERT INTO Seats (class, Airplanes_models_id) VALUES (?,?)";
    private static final String GET_SEATS_BY_ID = "SELECT * FROM Seats WHERE id = ?";
    private static final String UPDATE_SEATS = "UPDATE Seats SET class = ?, Airplanes_models_id = ? WHERE id=?";
    private static final String DELETE_SEATS = "DELETE FROM Seats WHERE id = ?";
    private static final String GET_SEATS_BY_AIRPLANEMODEL_ID  = "SELECT * FROM Seats WHERE Airplanes_models_id = ?";

    @Override
    public void create(Seats seats) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_SEATS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, seats.getClassType());
            ps.setInt(2, seats.getAirplaneModel());
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
    public Seats getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Seats seats = new Seats();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_SEATS_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            seats.setId(rs.getInt("id"));
            seats.setClassType(rs.getString("class"));
            seats.setAirplaneModel(rs.getInt("Airplanes_models_id"));
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
        return seats;
    }

    @Override
    public void update(Seats seats) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_SEATS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, seats.getClassType());
            ps.setInt(2, seats.getAirplaneModel());
            ps.setInt(3, seats.getId());
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
            ps = c.prepareStatement(DELETE_SEATS, Statement.RETURN_GENERATED_KEYS);
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
    public List<Seats> getByAirplaneModelId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Seats> seatsz = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_SEATS_BY_AIRPLANEMODEL_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Seats seats = new Seats();
                seats.setId(rs.getInt("id"));
                seats.setClassType(rs.getString("class"));
                seats.setAirplaneModel(rs.getInt("Airplanes_models_id"));
                seatsz.add(seats);
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
        return seatsz;
    }
}
