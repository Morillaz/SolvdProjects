package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IPersonDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PersonDAO extends AbstractJDBCDAO implements IPersonDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_PERSON = "INSERT INTO People (fname, lname, age, gender) VALUES (?,?,?,?)";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM People WHERE id = ?";
    private static final String UPDATE_PERSON = "UPDATE People SET fname = ?, lname = ?, age = ? , gender = ? WHERE id=?";
    private static final String DELETE_PERSON = "DELETE FROM People WHERE id = ?";

    @Override
    public void create(Person person) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_PERSON, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getFname());
            ps.setString(2, person.getLname());
            ps.setInt(3, person.getAge());
            ps.setString(4, person.getGender());
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
    public Person getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Person person = new Person();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_PERSON_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            person.setId(rs.getInt("id"));
            person.setFname(rs.getString("fname"));
            person.setLname(rs.getString("lname"));
            person.setAge(rs.getInt("age"));
            person.setGender(rs.getString("gender"));
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
        return person;
    }

    @Override
    public void update(Person person) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_PERSON, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getFname());
            ps.setString(2, person.getLname());
            ps.setInt(3, person.getAge());
            ps.setString(4, person.getGender());
            ps.setInt(5, person.getId());
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
            ps = c.prepareStatement(DELETE_PERSON, Statement.RETURN_GENERATED_KEYS);
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
