package oodpassignment;

import java.util.Scanner;

import oodpassignment.Order;

import oodpassignment.MenuLogic;

/**
 * OrderBoundary is the class that takes in inputs for all methods related to
 * Orders
 * 
 * @author zheng ying chang wei
 * @version 1.0
 * @since 07/11/2021
 *
 *
 */
public class OrderBoundary {

    /**
     * views the list of orders that are currently in the system - inputs to be
     * taken in in this class done via orderLogic object that was passed in
     * 
     * @param orderLogic the class that implements the logic behind all order
     *                   methods
     */
    public void viewOrder(OrderLogic orderLogic) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter order number:");
        Order order = orderLogic.viewOrder(sc.nextInt());
        System.out.println("TABLE NO.: " + order.getTableNumber());
        System.out.println(order.getTimeStamp());
        System.out.println("ORDER: ");
        float subTotal = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            System.out.println(order.getOrderItems().get(i).getName() + " $" + order.getOrderItems().get(i).getPrice());
            subTotal += order.getOrderItems().get(i).getPrice();
        }
        for (int i = 0; i < order.getPromoItems().size(); i++) {
            System.out.println(order.getPromoItems().get(i).getName() + " $" + order.getPromoItems().get(i).getPrice());
            subTotal += order.getPromoItems().get(i).getPrice();
        }
        System.out.println("Total excluding discounts and GST: $" + subTotal);
    }

    /**
     * creation of a new order object - inputs to be taken in in this class done
     * with orderlogic and menulogic object menulogic helps to return the relevant
     * menu items to be part of the order object orderlogic is responsible for the
     * logic behind the creation of the order object
     * 
     * @param orderLogic the class that implements the logic behind all order
     *                   methods
     * @param menuLogic  the class that implements the logic behind all methods
     *                   regarding the menu
     */
    public void newOrder(OrderLogic orderLogic, MenuLogic menuLogic) {
        Scanner sc = new Scanner(System.in);
        System.out.println("INPUT TABLE NO.: ");
        int tableNumber = sc.nextInt();

        System.out.println("MEMBER? (Y/N)");
        String memberStatus = sc.next();
        int ordernumber = orderLogic.newOrder(tableNumber, memberStatus);
        System.out.println("Order number is :" + ordernumber);
        System.out.println("\n");
        addItemToOrder(orderLogic, menuLogic, ordernumber);

    }

    /**
     * adds an additional item to a currently existing order - inputs to be taken in
     * in this class to determine which order, we have order number to help us
     * differentiate menulogic to help return the correct menu item we want to add
     * to the otder orderlogic to be responsible for the logic behind the addition
     * of the additional menu item to the correct order
     * 
     * @param orderLogic  the class that implements the logic behind all order
     *                    methods
     * @param menuLogic   the class that implements the logic behind all methods
     *                    regarding the menu
     * @param ordernumber the order number of the order
     */
    public void addItemToOrder(OrderLogic orderLogic, MenuLogic menuLogic, int ordernumber) {
        Scanner sc = new Scanner(System.in);
        int categoryChoice = 0;
        System.out.println("Menu:");
        while (true) {
            System.out.println("Input category: (1)MAIN (2)DESSERT (3)DRINKS (4)PROMO SET (5)Terminate");
            categoryChoice = sc.nextInt();
            if (categoryChoice == 5)
                break;
            if (categoryChoice != 4)
                menuLogic.displayMenu(categoryChoice);
            else
                menuLogic.displayPromoMenu();
            System.out.println("Input ItemID to add: ");
            int orderIDChoice = sc.nextInt();
            orderLogic.addItemToOrder(ordernumber, menuLogic, categoryChoice, orderIDChoice);

        }
    }

    /**
     * removes a chosen item from a currently existing order - inputs to be taken in
     * in this class orderlogic to be used to view what is currently in the order
     * and lets the user choose the item to be removed via its ID
     * 
     * @param orderLogic the class that implements the logic behind all order
     *                   methods
     */
    public void removeItemFromOrder(OrderLogic orderLogic) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number:");
        int ordernumber = sc.nextInt();
        System.out.println("CHOOSE AN ITEM TO REMOVE:");
        for (int i = 0; i < orderLogic.viewOrder(ordernumber).getOrderItems().size(); i++) {
            System.out.println("ID: " + orderLogic.viewOrder(ordernumber).getOrderItems().get(i).getID() + "\t"
                    + orderLogic.viewOrder(ordernumber).getOrderItems().get(i).getName());
        }
        System.out.println("Enter ID to remove: ");
        int removeChoice = sc.nextInt();
        orderLogic.removeItemFromOrder(ordernumber, removeChoice);

    }

    /**
     * 
     * @param orderLogic the class that implements the logic behind all order
     *                   methods
     * @param report     the report object where it is suppose to update
     */
    public void printOrderInvoice(OrderLogic orderLogic, Report report) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number:");
        int ordernumber = sc.nextInt();
        orderLogic.printOrderInvoice(ordernumber, report);

    }
}