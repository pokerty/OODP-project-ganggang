package oodpassignment;

import java.util.Scanner;

/**
 * *TableBoundary is a boundary class that is responsible for taking in inputs
 * from the user to be used in the methods regarding tables. Logic to be
 * provided by tableLogic class
 * 
 * @author zheng ying
 * @since 07/11/2021
 * @version 1.0
 */

public class TableBoundary {

    Scanner scanner = new Scanner(System.in);

    /**
     * allocates a free table according to the needs of the customer will indicate
     * if there are no free tables available tableLogic to implement the logics
     * behind the allocation - inputs taken in here
     * 
     * @param tableLogic tableLogic the class responsible for the logics behind
     *                   table
     */
    public void giveTable(TableLogic tableLogic) {
        System.out.println("Enter the number of customers:");
        int customerPax = scanner.nextInt();
        System.out.println("Enter the time of reservation:");
        int hour = scanner.nextInt();
        int tablenumber = tableLogic.giveTable(customerPax, hour);
        if (tablenumber != -1) {
            System.out.printf("Table %d allocated\n", tableLogic.giveTable(customerPax, hour));
            return;
        }
        System.out.printf("Table not allocated\n");
    }

    /**
     * checks if there are any free tables for a particular size of customers -
     * inputs taken in here tableLogic to implement the logics behind the checking
     * for a free and suitable table
     * 
     * @param tableLogic tableLogic the class responsible for the logics behind
     *                   table
     */
    public void checkTableAvailability(TableLogic tableLogic) {
        System.out.println("Enter the number of customers:");
        int customerPax = scanner.nextInt();
        System.out.println("Enter the hour of reservation:");
        int hour = scanner.nextInt();
        System.out.println("");
        if (tableLogic.checkTableAvailability(customerPax, hour)) {
            System.out.printf("There are tables available\n");
            return;
        }
        System.out.printf("There are no tables available\n");
    }

    /**
     * deallocates a table and sets it to unoccupied status - inputs taken in here
     * tableLogic to implement the logics behind the deallocation
     * 
     * @param tableLogic the class responsible for the logics behind table
     */
    public void freeTable(TableLogic tableLogic) {
        System.out.println("Enter the table number to free:");
        int tableNumber = scanner.nextInt();
        System.out.println("Enter the time of reservation:");
        int hour = scanner.nextInt();
        System.out.println("");
        tableLogic.freeTable(tableNumber, hour);
        System.out.println("Table is freed\n");
    }

}