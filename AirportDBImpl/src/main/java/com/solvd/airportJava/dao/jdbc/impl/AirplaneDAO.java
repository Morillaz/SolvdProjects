package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IAirplaneDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Airplane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO extends AbstractJDBCDAO implements IAirplaneDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_AIRPLANE = "INSERT INTO Airlines (Airplanes_models_id, Airlines_id) VALUES (?,?)";
    private static final String GET_AIRPLANE_BY_ID = "SELECT * FROM Airplanes WHERE id = ?";
    private static final String UPDATE_AIRPLANE = "UPDATE Airplanes SET Airplanes_models_id = ?, Airlines_id = ? WHERE id=?";
    private static final String DELETE_AIRPLANE = "DELETE FROM Airplanes WHERE id = ?";
    private static final String GET_AIRPLANES_BY_MODEL_ID = "SELECT * FROM Airplanes WHERE Airplanes_models_id = ?";
    private static final String GET_AIRPLANES_BY_AIRLINE_ID  = "SELECT * FROM Airplanes WHERE Airlines_id = ?";

    @Override
    public void create(Airplane airplane) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_AIRPLANE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, airplane.getModelId());
            ps.setInt(2, airplane.getAirlineId());
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
    public Airplane getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Airplane airplane = new Airplane();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPLANE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            airplane.setId(rs.getInt("id"));
            airplane.setModelId(rs.getInt("Airplanes_model_id"));
            airplane.setAirlineId(rs.getInt("Airlines_id"));
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
        return airplane;
    }

    @Override
    public void update(Airplane airplane) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_AIRPLANE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, airplane.getModelId());
            ps.setInt(2, airplane.getAirlineId());
            ps.setInt(3, airplane.getId());
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

    @Override
    public List<Airplane> getByModelId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Airplane> airplanes = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPLANES_BY_MODEL_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Airplane airplane = new Airplane();
                airplane.setId(rs.getInt("id"));
                airplane.setModelId(rs.getInt("Airplanes_model_id"));
                airplane.setAirlineId(rs.getInt("Airlines_id"));
                airplanes.add(airplane);
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
        return airplanes;
    }

    @Override
    public List<Airplane> getByAirlineId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Airplane> airplanes = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPLANES_BY_AIRLINE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(rs.getInt("id"));
                airplane.setModelId(rs.getInt("Airplanes_model_id"));
                airplane.setAirlineId(rs.getInt("Airlines_id"));
                airplanes.add(airplane);
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
        return airplanes;
    }
}
