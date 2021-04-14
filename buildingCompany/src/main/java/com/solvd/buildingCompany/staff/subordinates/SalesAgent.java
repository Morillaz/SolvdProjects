package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.LambdaTest;
import com.solvd.buildingCompany.client.Client;
import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.product.House;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.implementation.Boss;
import com.solvd.buildingCompany.staff.bosses.implementation.GeneralManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class SalesAgent extends Employee {
    private static final Logger logger = LogManager.getLogger(SalesAgent.class);
    public SalesAgent() {
        logger.info("New Sales Agent created.");
    }

    public SalesAgent(String name, double salary, Boss boss, Company company) {
        super(name, "Sales", "Sales Agent", salary, boss, company);
        logger.info("New Sales Agent created.");
    }

    public void informBudgetToProspect(Client<House> client) throws ConstructionException {
        if(client.getRequestedConstruction() != null){
            House prospectHouse = client.getRequestedConstruction();
            GeneralManager manager = this.getCompany().getGeneralManager();
            Double budget = manager.calculateProjectBudget(prospectHouse);
            logger.info(String.format("The total cost of the construction that %s ask us for is: $%.2f", client.getName(), budget));
            LambdaTest<House> information = new LambdaTest<>();
            information.formattedToString(prospectHouse);
            logger.info("House cost informed successfully.");

            boolean random = new Random().nextBoolean();
            if (random){
                this.getCompany().addConstructionsToBuild(prospectHouse);
            }
        } else {
            throw new ConstructionException("There is no information in the request.");
        }
    }
}
