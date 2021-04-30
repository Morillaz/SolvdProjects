package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IAirportJobDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.AirportJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportJobDAO extends AbstractJDBCDAO implements IAirportJobDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_AIRPORTJOB = "INSERT INTO Airports_has_Jobs (Airports_id, Jobs_id) VALUES (?,?)";
    private static final String GET_AIRPORTJOB_BY_ID = "SELECT * FROM Airports_has_Jobs WHERE id = ?";
    private static final String UPDATE_AIRPORTJOB = "UPDATE Airports_has_Jobs SET Airports_id = ?, Jobs_id = ? WHERE id=?";
    private static final String DELETE_AIRPORTJOB = "DELETE FROM Airports_has_Jobs WHERE id = ?";
    private static final String GET_AIRPORTJOB_BY_AIRLINE_ID = "SELECT * FROM Airports_has_Jobs WHERE Airports_id = ?";
    private static final String GET_AIRPORTJOB_BY_JOB_ID  = "SELECT * FROM Airports_has_Jobs WHERE Jobs_id = ?";

    @Override
    public void create(AirportJob airportJob) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_AIRPORTJOB, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, airportJob.getAirportId());
            ps.setInt(2, airportJob.getJobId());
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
    public AirportJob getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AirportJob airportJob = new AirportJob();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPORTJOB_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            airportJob.setId(rs.getInt("id"));
            airportJob.setAirportId(rs.getInt("Airports_id"));
            airportJob.setJobId(rs.getInt("Cities_id"));
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
        return airportJob;
    }

    @Override
    public void update(AirportJob airportJob) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_AIRPORTJOB, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, airportJob.getAirportId());
            ps.setInt(2, airportJob.getJobId());
            ps.setInt(3, airportJob.getId());
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
            ps = c.prepareStatement(DELETE_AIRPORTJOB, Statement.RETURN_GENERATED_KEYS);
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
    public List<AirportJob> getByAirportId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AirportJob> airportJobs = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPORTJOB_BY_AIRLINE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                AirportJob airportJob = new AirportJob();
                airportJob.setId(rs.getInt("id"));
                airportJob.setAirportId(rs.getInt("Airports_id"));
                airportJob.setJobId(rs.getInt("Jobs_id"));
                airportJobs.add(airportJob);
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
        return airportJobs;
    }

    @Override
    public List<AirportJob> getByJobId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AirportJob> airportJobs = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPORTJOB_BY_JOB_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                AirportJob airportJob = new AirportJob();
                airportJob.setId(rs.getInt("id"));
                airportJob.setAirportId(rs.getInt("Airports_id"));
                airportJob.setJobId(rs.getInt("Jobs_id"));
                airportJobs.add(airportJob);
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
        return airportJobs;
    }
}
