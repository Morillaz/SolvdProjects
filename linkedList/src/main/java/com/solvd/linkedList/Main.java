package com.solvd.linkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(25);
        list.add(25);
        list.add(25);
        list.add(39);
        list.add(32);

        logger.info("Printing list with numbers:");

        for (Integer i: list) {
            logger.info(i);
        }

        System.out.println("Printing list after some numbers has been removed:");

        list.remove((Integer) 2);
        list.remove((Integer) 39);

        for (Integer i: list) {
            logger.info(i);
        }

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!");

        logger.info("Printing list with Strings:");

        for (String i: list2) {
            logger.info(i);
        }

        logger.info("Printing list after some Strings has been removed:");

        list2.remove("Hello");
        list2.remove("!");

        for (String i: list2) {
            logger.info(i);
        }
    }
}
