package oodpassignment;

import java.util.ArrayList;

public class Report {
    //period in day(s)
	private ArrayList<Order> orders; 

    public Report(){
    	ArrayList<Order> orders = new ArrayList<Order>();
    	this.orders = orders; 
    }

    public ArrayList<Order> getOrders() {
    	return orders; 
    }

}