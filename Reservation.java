package oodpassignment;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * 
 * @author chang wei 
 * @since 07/11/2021 
 * @version 1.0 
 *Reservation class is an entity class that stores data regarding reservation
 *such as the date and time of reservation, no of pax, name of customer who made the reservation
 *contact details and the table number to be allocated to the customer
 */

public class Reservation {

	/**
	 * calendar class which records date and time of reservation 
	 */
	private Calendar dateandtime;
	/**
	 * the number of customers that the reservation is for 
	 */
	private int pax;
	/**
	 * name of the customer who made the reservation 
	 */
	private String name;
	/**
	 * contact number of customer who made the reservation 
	 */
	private int contact;
	/**
	 * table number / table to be allcoted to the customer 
	 */
	private int tableNumber;

	/**
	 * reservation constructor to create reservation object 
	 * should not be used if correct parameters were passed in 
	 */
	public Reservation() {
		// Using Calendar class
	    Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);      // NOTE!!! : Month from 0 to 11
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    int minute = cal.get(Calendar.MINUTE);
	    
	    Calendar date = new GregorianCalendar(year,month,day,hour,minute);
	    this.dateandtime = date;
	    this.pax = 0; 
	    this.name = "Invalid"; 
	    this.contact = 0; 
	    this.tableNumber=0; 
	}
	
	/**
	 * the correct constructor to be used to create a reservation object 
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param pax
	 * @param name
	 * @param contact
	 * @param tableNumber
	 */
	public Reservation(int month, int day, int hour, int minute, int pax, String name, int contact, int tableNumber) {
		// Using Calendar class
	    Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    
	    Calendar date = new GregorianCalendar(year,month,day,hour,minute);
	    this.dateandtime = date;
	    this.pax = pax; 
	    this.name = name; 
	    this.contact = contact; 
	    this.tableNumber=tableNumber; 
		
	}

	//getters and setters 

	/**
	 * getter for date and time of reservation 
	 * @return returns a calendar object that records the date and time of reservation 
	 */
	public Calendar getDateandtime() {
		return dateandtime;
	}

/**
 * setter for date and time of reservation 
 * @param dateandtime to pass in calendar object 
 */
	public void setDateandtime(Calendar dateandtime) {
		this.dateandtime = dateandtime;
	}

	/**
	 * getter for no of pax in reservation 
	 * @return
	 */
	public int getPax() {
		return pax;
	}

/**
 * setter for no of pax for reservation 
 * @param pax
 */
	public void setPax(int pax) {
		this.pax = pax;
	}

/**
 * getter for name of customer who made reservation 
 * @return
 */
	public String getName() {
		return name;
	}

/**
 * setter for name of customer who made reservation 
 * @param name
 */
	public void setName(String name) {
		this.name = name;
	}

/**
 * getter for contact of customer who made reservation
 * @return
 */
	public int getContact() {
		return contact;
	}

/**
 * setter method for contact of customer who made reservation 
 * @param contact
 */
	public void setContact(int contact) {
		this.contact = contact;
	}

/**
 * getter method for table number of the table to be allocated to the customer who made the reservation 
 * @return tablenumber 
 */
	public int getTableNumber() {
		return tableNumber;
	}

/**
 * setter method  for table number of the table to be allocated to the customer who made the reservation 
 * @param tableNumber
 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

}