package com.solvd.reflectionExample;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        Greeting hello = new Greeting();

        Field[] fields = hello.getClass().getFields();
        Constructor[] constructors = hello.getClass().getConstructors();
        Method[] methods = hello.getClass().getMethods();

        Arrays.stream(fields).forEach(System.out::println);
        Arrays.stream(constructors).forEach((System.out::println));
        Arrays.stream(methods).forEach((System.out::println));

        try{
            Method setMessage = hello.getClass().getMethod("setMessage", String.class);
            Method getMessage = hello.getClass().getMethod("getMessage");

            setMessage.invoke(hello, "Hi, how are you?");
            logger.info(getMessage.invoke(hello));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            logger.error(e.getMessage());
        }
    }
}
