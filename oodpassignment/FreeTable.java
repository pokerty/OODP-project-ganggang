package oodpassignment;

/**
 * An interface to be used by OrderLogic so deallocate a table when the order
 * invoice is issued (bill is paid and customers left)
 * 
 * @author Chang Wei
 * @version 1.0
 * @since 06/11/2021
 *
 *
 */
public interface FreeTable {
	/**
	 * abstract method of freeTable to be implemented by class implementing the
	 * interface should free a table according to table number and time of dining
	 * (by hr)
	 * 
	 * @param tableNumber tablenumber of customer (where he/she sat)
	 * @param hour        hour of when customer made his reservation / came to dine
	 */
	public void freeTable(int tableNumber, int hour);
}
