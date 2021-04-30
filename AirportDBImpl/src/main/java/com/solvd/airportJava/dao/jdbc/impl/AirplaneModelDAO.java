package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IAirplaneModelDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.AirplaneModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AirplaneModelDAO extends AbstractJDBCDAO implements IAirplaneModelDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_AIRPLANE = "INSERT INTO Airplanes_models (model, size) VALUES (?,?)";
    private static final String GET_AIRPLANE_BY_ID = "SELECT * FROM Airplanes_models WHERE id = ?";
    private static final String UPDATE_AIRPLANE = "UPDATE Airplanes_models SET model = ?, size = ? WHERE id=?";
    private static final String DELETE_AIRPLANE = "DELETE FROM Airplanes_models WHERE id = ?";

    @Override
    public void create(AirplaneModel airplaneModel) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_AIRPLANE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, airplaneModel.getModel());
            ps.setString(2, airplaneModel.getSize());
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
    public AirplaneModel getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AirplaneModel model = new AirplaneModel();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPLANE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            model.setId(rs.getInt("id"));
            model.setModel(rs.getString("Airplanes_model_id"));
            model.setSize(rs.getString("Airlines_id"));
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
        return model;
    }

    @Override
    public void update(AirplaneModel airplaneModel) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_AIRPLANE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, airplaneModel.getModel());
            ps.setString(2, airplaneModel.getSize());
            ps.setInt(3, airplaneModel.getId());
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
            ps = c.prepareStatement(DELETE_AIRPLANE, Statement.RETURN_GENERATED_KEYS);
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
