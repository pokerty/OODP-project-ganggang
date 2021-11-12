package oodpassignment;

import java.util.ArrayList;

import oodpassignment.Order;

/**
 * the report class that holds the collection of orders whose bill has been
 * tallied for the purpose of tracking of the revenue of the restaurant
 * 
 * @author chang wei
 * @since 07/11/2021
 * @version 1.0
 *
 */
public class Report {
	// period in day(s)
	/**
	 * List of orders whose bill have been paid
	 */
	private ArrayList<Order> orders;

	/**
	 * constructor for the report class - creates an array list of orders to store
	 * the incoming orders
	 */
	public Report() {
		ArrayList<Order> orders = new ArrayList<Order>();
		this.orders = orders;
	}

	/**
	 * getter method for the array list of orders
	 * 
	 * @return returns the array list that holds all the completed orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

}