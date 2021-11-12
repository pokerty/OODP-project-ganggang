package oodpassignment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import oodpassignment.MenuItems;

/**
 * The Order class is a entity class storing the details regarding the orders
 * made by customers such as the time, table number, list of menu items, list of
 * promo items
 * 
 * @author minhwan
 * @since 07/11/2021
 * @version 1.0
 *
 */
public class Order {
    /**
     * table number where the order is from
     */
    private int tableNumber;
    /**
     * the time where the first order is created
     */
    private Date timeStamp;
    /**
     * the list of MenuItems that was ordered
     */
    private ArrayList<MenuItems> orderItems;
    /**
     * the list of promotional set items that was orderd
     */
    private ArrayList<PromotionalSet> promoItems;
    /**
     * whether the customer is a member or not - to qualify for discount when paying
     * later
     */
    private boolean isMember;
    /**
     * the staff member that took the order
     */
    private Staff staff;

    /**
     * constructor to create an Order object
     * 
     * @param tableNumber the table number where the order came from
     * @param isMember    whether the customer is a member of the restaurant -
     *                    boolean
     * @param staff       the staff that took the customer's order (an object)
     */
    public Order(int tableNumber, boolean isMember, Staff staff) {
        Calendar cal = Calendar.getInstance();
        Date timestamp = cal.getTime(); // getting the date for timestamp

        this.tableNumber = tableNumber;
        this.timeStamp = timestamp;
        ArrayList<MenuItems> orderArrayList = new ArrayList<MenuItems>();
        this.orderItems = orderArrayList;
        this.isMember = isMember;
        this.staff = staff;
        ArrayList<PromotionalSet> promoItem = new ArrayList<PromotionalSet>();
        this.promoItems = promoItem;

    }

    /**
     * a constructor that is used to create order objects from txt file as part of
     * records - a different constructor is to be used for creation of new orders
     * 
     * @param tableNumber the table number where the order came from
     * @param isMember    whether the customer is a member of the restaurant -
     *                    boolean
     * @param staff       staff the staff that took the customer's order (an object)
     * @param time        the time of order
     */
    public Order(int tableNumber, boolean isMember, Staff staff, Calendar time) {
        Calendar cal = time;
        Date timestamp = cal.getTime(); // getting the date for timestamp

        this.tableNumber = tableNumber;
        this.timeStamp = timestamp;
        ArrayList<MenuItems> orderArrayList = new ArrayList<MenuItems>();
        this.orderItems = orderArrayList;
        this.isMember = isMember;
        this.staff = staff;
        ArrayList<PromotionalSet> promoItem = new ArrayList<PromotionalSet>();
        this.promoItems = promoItem;

    }

    // get and set functions
    /**
     * getter method for tablenumber of order
     * 
     * @return table number of a particular order
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * setter method for table number
     * 
     * @param tableNumber table number of order
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * getter method for the time when order was made
     * 
     * @return calendar object
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * getter method for promotional items in the order
     * 
     * @return ArrayList of promotional items in the order
     */
    public ArrayList<PromotionalSet> getPromoItems() {
        return promoItems;
    }

    /**
     * getter method for menu items in the order
     * 
     * @return ArrayList of menu items in the order
     */
    public ArrayList<MenuItems> getOrderItems() {
        return orderItems;
    }

    /**
     * adds additional order items to the existing order which is in the form of an
     * array list
     * 
     * @param orderItems the list of orders (an arraylist)
     * @param menuItems  the menu item you wish to add to an existing order
     */
    public void setOrderItems(ArrayList<MenuItems> orderItems, MenuItems menuItems) {
        orderItems.add(menuItems);
    }

    /**
     * removes menu items from the existing order which is in the form of an array
     * list
     * 
     * @param orderItems the list of orders (an arraylist)
     * @param menuItems  the menu item you wish to remove from the order
     */
    public void removeOrderItems(ArrayList<MenuItems> orderItems, MenuItems menuItems) {
        orderItems.remove(menuItems);
    }

    /**
     * getter method that returns the staff object which represents the staff that
     * took the order
     * 
     * @return staff object
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * setter method for staff object that took the order
     * 
     * @param staff staff object you wish to set as the one who took the order
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     * getter method for whether a customer is a member or not (boolean)
     * 
     * @return boolean value of whether the customer is a member
     */
    public boolean getMember() {
        return isMember;
    }

    /**
     * setter method for whether customer is a member or not (boolean)
     * 
     * @param member boolean value of whether the customer is a member
     */
    public void setMember(boolean member) {
        isMember = member;
    }
}