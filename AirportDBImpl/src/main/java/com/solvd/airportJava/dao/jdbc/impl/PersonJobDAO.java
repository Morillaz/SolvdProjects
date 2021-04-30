package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IPersonJobDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.PersonJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonJobDAO extends AbstractJDBCDAO implements IPersonJobDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_PERSONJOB = "INSERT INTO People_has_Jobs (People_id, Jobs_id) VALUES (?,?)";
    private static final String GET_PERSONJOB_BY_ID = "SELECT * FROM People_has_Jobs WHERE id = ?";
    private static final String UPDATE_PERSONJOB = "UPDATE People_has_Jobs SET People_id = ?, Jobs_id = ? WHERE id=?";
    private static final String DELETE_PERSONJOB = "DELETE FROM People_has_Jobs WHERE id = ?";
    private static final String GET_PERSONJOBS_BY_PERSON_ID = "SELECT * FROM People_has_Jobs WHERE People_id = ?";
    private static final String GET_PERSONJOBS_BY_JOB_ID  = "SELECT * FROM People_has_Jobs WHERE Jobs_id = ?";

    @Override
    public void create(PersonJob personJob) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_PERSONJOB, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, personJob.getPersonId());
            ps.setInt(2, personJob.getJobId());
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
    public PersonJob getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PersonJob personJob = new PersonJob();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_PERSONJOB_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            personJob.setId(rs.getInt("id"));
            personJob.setPersonId(rs.getInt("Airplanes_model_id"));
            personJob.setJobId(rs.getInt("Airlines_id"));
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
        return personJob;
    }

    @Override
    public void update(PersonJob personJob) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_PERSONJOB, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, personJob.getPersonId());
            ps.setInt(2, personJob.getJobId());
            ps.setInt(3, personJob.getId());
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
            ps = c.prepareStatement(DELETE_PERSONJOB, Statement.RETURN_GENERATED_KEYS);
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
    public List<PersonJob> getByPersonId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PersonJob> personJobs = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_PERSONJOBS_BY_PERSON_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                PersonJob personJob = new PersonJob();
                personJob.setId(rs.getInt("id"));
                personJob.setPersonId(rs.getInt("Airplanes_model_id"));
                personJob.setJobId(rs.getInt("Airlines_id"));
                personJobs.add(personJob);
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
        return personJobs;
    }

    @Override
    public List<PersonJob> getByJobId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PersonJob> personJobs = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_PERSONJOBS_BY_JOB_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                PersonJob personJob = new PersonJob();
                personJob.setId(rs.getInt("id"));
                personJob.setPersonId(rs.getInt("Airplanes_model_id"));
                personJob.setJobId(rs.getInt("Airlines_id"));
                personJobs.add(personJob);
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
        return personJobs;
    }
}
