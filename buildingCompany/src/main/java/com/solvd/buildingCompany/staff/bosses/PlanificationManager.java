package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.enums.Size;
import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.exceptions.ConstructionSpecificationsException;
import com.solvd.buildingCompany.product.Construction;
import com.solvd.buildingCompany.product.House;
import com.solvd.buildingCompany.staff.subordinates.Architect;
import com.solvd.buildingCompany.staff.subordinates.CivilEngineer;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.bosses.interfaces.IPlanificationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PlanificationManager extends Boss implements IPlanificationManager {
    private static final Logger logger = LogManager.getLogger(PlanificationManager.class);

    public PlanificationManager() {
        logger.info("New Planification Manager created.");
    }

    public PlanificationManager(String name, double salary, Boss boss, Company company) {
        super(name, "Planification", "Planification Manager", salary, boss, company);
        logger.info("New Planification Manager created.");
    }

    public PlanificationManager(String name, double salary, Boss boss, Company company, Map<Integer, Employee> employees) {
        super(name, "Planification", "Planification Manager", salary, boss, company, employees);
        logger.info("New Planification Manager created.");
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException {
        String role = employee.getRole();
        if (role.equalsIgnoreCase("Architect") && employee instanceof Architect) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (role.equalsIgnoreCase("Civil Engineer") && employee instanceof Architect) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else {
            throw new EmployeeException("Invalid role");
        }
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException {
        switch (ROLES) {
            case ARCHITECT:
                Architect architect = new Architect(name, salary, this, this.getCompany());
                super.addEmployee(architect);
                logger.info("Employee added.");
                break;
            case CIVIL_ENGINEER:
                CivilEngineer civilEngineer = new CivilEngineer(name, salary, this, this.getCompany());
                super.addEmployee(civilEngineer);
                logger.info("Employee Added.");
                break;
            default:
                throw new EmployeeException("Incorrect Role");
        }
    }

    public double generatePlanificationBudget(Construction construction) throws ConstructionException {
        ConstructionTypes type = construction.getType();
        switch (type) {
            case HOUSE:
                try {
                    return estimateHouseBudget(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case CHURCH:
                try {
                    return estimateChurchBudget(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case HOSPITAL:
                try {
                    return estimateHospitalBudget(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case SKYSCRAPER:
                try {
                    return estimateSkyscraperBudget(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case MULTIPURPOSE_BUILDING:
                try {
                    return estimateMultipurposeBudget(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            default:
                throw new ConstructionException("Invalid Construction");
        }
    }

    public double estimateConstructionTime(Construction construction) throws ConstructionException {
        ConstructionTypes type = construction.getType();
        switch (type) {
            case HOUSE:
                try {
                    return estimateHouseTime(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case CHURCH:
                try {
                    return estimateChurchTime(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case HOSPITAL:
                try {
                    return estimateHospitalTime(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case SKYSCRAPER:
                try {
                    return estimateSkyscraperTime(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case MULTIPURPOSE_BUILDING:
                try {
                    return estimateMultipurposeTime(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            default:
                throw new ConstructionException("Invalid Construction");
        }
    }

    private double estimateHouseBudget(Construction construction) throws ConstructionSpecificationsException {
        House house = (House) construction;
        if (house.getSize() != null && house.getMaterial() != null && house.getFloors() > 0) {
            double budget = 0;
            Size size = house.getSize();
            String material = house.getMaterial().toLowerCase();
            int floors = house.getFloors();


            switch (material) {
                case "straw":
                    budget = 100;
                    break;
                case "wood":
                    budget = 1000;
                    break;
                case "brick":
                    budget = 5000;
                    break;
            }

            if (size == Size.SMALL) {
                budget *= 0.75;
            } else if (size == Size.BIG) {
                budget *= 1.25;
            }

            if (floors > 1) {
                budget *= floors * 1.5;
            }

            if (house.isGarden()) {
                budget += 100;
            }

            logger.info("Cost by house specifications added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the cost of the house");
        }
    }

    private double estimateHouseTime(Construction construction) throws ConstructionSpecificationsException {
        House house = (House) construction;
        if (house.getSize() != null && house.getMaterial() != null && house.getFloors() > 0) {
            double time = 0;
            Size size = house.getSize();
            String material = house.getMaterial().toLowerCase();
            int floors = house.getFloors();
            switch (material) {
                case "straw":
                    time = 1;
                    break;
                case "wood":
                    time = 3;
                    break;
                case "brick":
                    time = 6;
                    break;
            }

            if (size == Size.SMALL) {
                time *= 0.75;
            } else if (size == Size.BIG) {
                time *= 1.25;
            }

            if (floors > 1) {
                time *= floors * 1.5;
            }

            if (house.isGarden()) {
                time += 0.25;
            }

            logger.info("Construction time estimated successfully.");
            return time;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the necessary time to build the house");
        }
    }

    private double estimateChurchBudget(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double budget = 10000;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                budget *= 0.75;
            } else if (size == Size.BIG) {
                budget *= 1.5;
            }

            if (floors > 1) {
                budget *= floors * 1.5;
            }

            logger.info("Cost by house specifications added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the cost of the house");
        }
    }

    private double estimateChurchTime(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double time = 12;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                time *= 0.75;
            } else if (size == Size.BIG) {
                time *= 1.25;
            }

            if (floors > 1) {
                time *= floors * 1.5;
            }

            logger.info("Construction time estimated successfully.");
            return time;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the necessary time to build the house");
        }
    }

    private double estimateHospitalBudget(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double budget = 25000;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                budget *= 0.75;
            } else if (size == Size.BIG) {
                budget *= 2;
            }

            if (floors > 1) {
                budget *= floors * 1.5;
            }

            logger.info("Cost by house specifications added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the cost of the house");
        }
    }

    private double estimateHospitalTime(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double time = 14;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                time *= 0.75;
            } else if (size == Size.BIG) {
                time *= 1.25;
            }

            if (floors > 1) {
                time *= floors * 1.5;
            }

            logger.info("Construction time estimated successfully.");
            return time;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the necessary time to build the house");
        }
    }

    private double estimateSkyscraperBudget(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double budget = 70000;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                budget *= 0.75;
            } else if (size == Size.BIG) {
                budget *= 1.5;
            }

            if (floors > 10) {
                budget *= floors * 1.5;
            } else {
                budget *= floors * 1.1;
            }

            logger.info("Cost by house specifications added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the cost of the house");
        }
    }

    private double estimateSkyscraperTime(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double time = 24;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                time *= 0.75;
            } else if (size == Size.BIG) {
                time *= 1.25;
            }

            if (floors > 1) {
                time *= floors * 1.5;
            }

            logger.info("Construction time estimated successfully.");
            return time;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the necessary time to build the house");
        }
    }

    private double estimateMultipurposeBudget(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double budget = 10000;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                budget *= 0.75;
            } else if (size == Size.BIG) {
                budget *= 1.5;
            }

            if (floors > 1) {
                budget *= floors * 1.5;
            }

            logger.info("Cost by house specifications added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the cost of the house");
        }
    }

    private double estimateMultipurposeTime(Construction construction) throws ConstructionSpecificationsException {
        if (construction.getSize() != null && construction.getFloors() > 0) {
            double time = 12;
            Size size = construction.getSize();
            int floors = construction.getFloors();

            if (size == Size.SMALL) {
                time *= 0.75;
            } else if (size == Size.BIG) {
                time *= 1.25;
            }

            if (floors > 1) {
                time *= floors * 1.5;
            }

            logger.info("Construction time estimated successfully.");
            return time;
        } else {
            throw new ConstructionSpecificationsException("There are not enough requirements to calculate the necessary time to build the house");
        }
    }
}
