package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.ISeatsAvailabilityDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.SeatsAvailability;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatsAvailabilityDAO extends AbstractJDBCDAO implements ISeatsAvailabilityDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_SEATSAVAILABILITY = "INSERT INTO Seat_Availability (available, occupied, Seats_id) VALUES (?,?,?)";
    private static final String GET_SEATSAVAILABILITY_BY_ID = "SELECT * FROM Seat_Availability WHERE id = ?";
    private static final String UPDATE_SEATSAVAILABILITY = "UPDATE Seat_Availability SET available = ?, occupied = ?, Seats_id = ? WHERE id=?";
    private static final String DELETE_SEATSAVAILABILITY = "DELETE FROM Seat_Availability WHERE id = ?";
    private static final String GET_SEATSAVAILABILITY_BY_SEATS_ID = "SELECT * FROM Seat_Availability WHERE Seats_id = ?";

    @Override
    public void create(SeatsAvailability seatsAvailability) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_SEATSAVAILABILITY, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, seatsAvailability.getAvailables());
            ps.setInt(2, seatsAvailability.getOccupied());
            ps.setInt(3, seatsAvailability.getSeatsId());
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
    public SeatsAvailability getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SeatsAvailability seatsAvailability = new SeatsAvailability();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_SEATSAVAILABILITY_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            seatsAvailability.setId(rs.getInt("id"));
            seatsAvailability.setAvailables(rs.getInt("availables"));
            seatsAvailability.setOccupied(rs.getInt("occupied"));
            seatsAvailability.setSeatsId(rs.getInt("Seats_id"));
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
        return seatsAvailability;
    }

    @Override
    public void update(SeatsAvailability seatsAvailability) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_SEATSAVAILABILITY, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, seatsAvailability.getAvailables());
            ps.setInt(2, seatsAvailability.getOccupied());
            ps.setInt(3, seatsAvailability.getSeatsId());
            ps.setInt(4, seatsAvailability.getId());
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
            ps = c.prepareStatement(DELETE_SEATSAVAILABILITY, Statement.RETURN_GENERATED_KEYS);
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
    public List<SeatsAvailability> getBySeatsId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SeatsAvailability> seatsAvailabilities = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_SEATSAVAILABILITY_BY_SEATS_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                SeatsAvailability seatsAvailability = new SeatsAvailability();
                seatsAvailability.setId(rs.getInt("id"));
                seatsAvailability.setAvailables(rs.getInt("availables"));
                seatsAvailability.setOccupied(rs.getInt("occupied"));
                seatsAvailability.setSeatsId(rs.getInt("Seats_id"));
                seatsAvailabilities.add(seatsAvailability);
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
        return seatsAvailabilities;
    }
}
