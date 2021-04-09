package com.solvd.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(25);
        list.add(25);
        list.add(25);
        list.add(39);
        list.add(32);

        System.out.println("Printing list with numbers:");

        for (Integer i: list) {
            System.out.println(i);
        }

        System.out.println("Printing list after some numbers has been removed:");

        list.remove((Integer) 2);
        list.remove((Integer) 39);

        for (Integer i: list) {
            System.out.println(i);
        }

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!");

        System.out.println("Printing list with Strings:");

        for (String i: list2) {
            System.out.println(i);
        }

        System.out.println("Printing list after some Strings has been removed:");

        list2.remove("Hello");
        list2.remove("!");

        for (String i: list2) {
            System.out.println(i);
        }
    }
}
