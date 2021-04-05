package com.solvd.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(25);

        for (Integer i: list) {
            System.out.println(i);
        }

        list.remove((Integer) 2);

        for (Integer i: list) {
            System.out.println(i);
        }

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Hello");
        list2.add("World");
        list2.add("!");

        for (String i: list2) {
            System.out.println(i);
        }

        list2.remove("Hello");

        for (String i: list2) {
            System.out.println(i);
        }
    }
}
