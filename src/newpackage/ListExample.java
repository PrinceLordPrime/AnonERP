package newpackage;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shan
 */
public class ListExample {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");

        System.out.println("Inserted in 'order': ");
        printList(myList);
        System.out.println("\n");
        System.out.println("Inserted out of 'order': ");

        // Clear the list
        myList.clear();

        myList.add("four");
        myList.add("five");
        myList.add("one");
        myList.add("two");
        myList.add("three");

        printList(myList);
    }

    private static void printList(ArrayList<String> myList) {
        for (String string : myList) {
            System.out.println(string);
        }
    }
}