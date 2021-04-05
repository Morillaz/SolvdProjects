package com.solvd.buildingCompany;

import com.solvd.buildingCompany.client.Client;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.product.House;
import com.solvd.buildingCompany.staff.bosses.GeneralManager;
import com.solvd.buildingCompany.staff.bosses.SalesManager;
import com.solvd.buildingCompany.staff.subordinates.SalesAgent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        logger.info("Starting Program.");

        GeneralManager manager = RandomCompany.generateRandom();
        SalesAgent seller = null;
        try{
            SalesManager sales = manager.getEmployee("Sales");
            seller = sales.getEmployee("Sales Agent");
        } catch (EmployeeException e){
            logger.error(e.getMessage());
        }

        Client<House> prospect = new Client<>("Mario Santos", RandomHouse.generateData());
        try{
            if (seller != null) {
                seller.informBudgetToProspect(prospect);
            }
        } catch (ConstructionException e){
            logger.error(e.getMessage());
        }

        LambdaTest<House> lambda = new LambdaTest<>();
        System.out.println(lambda.formattedToString(prospect.getRequestedConstruction()));

        logger.info("Program ended successful.");
    }
}
