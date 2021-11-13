package oodpassignment;

import java.util.Scanner;

import oodpassignment.Order;

import oodpassignment.MenuLogic;

import oodpassignment.FreeTable;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Orderlogic is responsible for all the logic behind the methods related to
 * orders such as creation of orders, removal and addition of orderitems and
 * printing of order invoice
 *
 * @author chang wei
 * @version 1.0
 * @since 07/11/2021
 * 
 */
public class OrderLogic {

    /**
     * holds the list of orders that are currently in the system
     */
    private ArrayList<Order> orderList;
    /**
     * TableLogic which is of the FreeTable type since we only want to utilise one
     * function of TableLogic. Demonstrates principles I and D
     */
    private FreeTable table;
    /**
     * staffLogic to be responsible for outputting the correct staff as the one who
     * took the various orders
     */
    private StaffLogic staffLogic;

    Scanner sc = new Scanner(System.in);

    /**
     * The constructor for orderlogic
     * 
     * @param table      the table class of type FreeTable
     * @param staffLogic the class that implements the logic for all staff related
     *                   functions
     */
    public OrderLogic(FreeTable table, StaffLogic staffLogic) {
        // txt implementation

        ArrayList<Order> orderList = new ArrayList<Order>();
        this.orderList = orderList;
        this.table = table;
        this.staffLogic = staffLogic;
        System.out.println("OrderLogic start-up complete.");
    }

    /**
     * creates a new order
     * 
     * @param tableNumber  table number of order
     * @param memberStatus whether the customer is a member of the restaurant
     * @return returns the new order object
     */
    public int newOrder(int tableNumber, String memberStatus) {
        boolean isMember = false;
        if (memberStatus == "y" || memberStatus == "Y")
            isMember = true;

        Staff staff = staffLogic.handler();

        Order order = new Order(tableNumber, isMember, staff);
        orderList.add(order); // addition of order to order list (collection)
        return (orderList.size() - 1);

    }

    /**
     * adds a new menu item to the order
     * 
     * @param ordernumber    order number
     * @param menuLogic      the class that implements all the logics behind menu
     * @param categoryChoice the type of item you want to add to order
     * @param orderIDChoice  ID of item you want to add
     */
    public void addItemToOrder(int ordernumber, MenuLogic menuLogic, int categoryChoice, int orderIDChoice) {
        Order order = orderList.get(ordernumber);

        if (categoryChoice == 1)
            order.getOrderItems().add(menuLogic.addItemsToOrder(orderIDChoice, categoryChoice));
        if (categoryChoice == 2)
            order.getOrderItems().add(menuLogic.addItemsToOrder(orderIDChoice, categoryChoice));
        if (categoryChoice == 3)
            order.getOrderItems().add(menuLogic.addItemsToOrder(orderIDChoice, categoryChoice));
        if (categoryChoice == 4)
            order.getPromoItems().add(menuLogic.addPromoToOrder(orderIDChoice));// adding promo set returned
    }

    /**
     * removes a menu item from the order
     * 
     * @param ordernumber  order number of order
     * @param removeChoice ID of the menu item you want to remove from order
     */
    public void removeItemFromOrder(int ordernumber, int removeChoice) {
        Order order = orderList.get(ordernumber);
        // need to add remove for promo item
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            if (removeChoice == order.getOrderItems().get(i).getID())
                order.removeOrderItems(order.getOrderItems(), order.getOrderItems().get(i));
        }
    }

    /**
     * Chooses the correct order object from the list of order objects using the
     * order number
     * 
     * @param ordernumber the order number
     * @return returns the correct order object
     */
    public Order viewOrder(int ordernumber) {
        return orderList.get(ordernumber);
    }

    /**
     * settles the bill, to input the order to records for tabulation of revenue to
     * free up the currently used table as well bill will differ based on whether
     * the customer is a member or not
     * 
     * @param ordernumber the order number
     * @param report      the object where order invoice will store the completed
     *                    orders at
     */
    public void printOrderInvoice(int ordernumber, Report report) {
        Order order = orderList.get(ordernumber);
        System.out.println("========CZ2002 RESTAURANT========");
        System.out.println("Server: " + order.getStaff().getName() + "\tTable: " + order.getTableNumber());
        System.out.println("Date: " + order.getTimeStamp());
        System.out.println("_____________________________");
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            System.out.println("(" + order.getOrderItems().get(i).getID() + ")" + " "
                    + order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
        }
        System.out.println("_____________________________");
        float subTotal = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            subTotal += order.getOrderItems().get(i).getPrice();
        }

        System.out.println("SUB-TOTAL: " + subTotal);
        if (order.getMember() == true) {
            subTotal = (float) 0.9 * subTotal;
            System.out.println("Members discount (10%): " + subTotal);
            System.out.println("GST: " + subTotal * 0.07);
            System.out.println("\nTOTAL: " + subTotal * 1.07);
        } else {
            System.out.println("GST: " + subTotal * 0.07);
            System.out.println("\nTOTAL: " + subTotal * 1.07);
        }
        System.out.println("Thank you for dining with us!");

        table.freeTable(order.getTableNumber() - 1, order.getTimeStamp().getHours());
        report.getOrders().add(order);

    }

}