package oodpassignment;

/**
 * An interface to be used by ReservationLogic so as to allocate and deallocate
 * tables when reservations are made and cancelled respectively
 * 
 * @author Chang Wei
 * @version 1.0
 * @since 06/11/2021
 *
 */
public interface CheckTable {
	/**
	 * abstract method of giveTable - to allocate a table if available
	 * 
	 * @param pax  no of pax per table
	 * @param hour time of dining by hr
	 * @return returns a value to indicate if table is given or not
	 */
	public int giveTable(int pax, int hour);

	/**
	 * abstract method, to mark the table as unoccupied
	 * 
	 * @param TableNumber table number of customer
	 * @param hour        time of dining
	 */
	public void freeTable(int TableNumber, int hour);
}
