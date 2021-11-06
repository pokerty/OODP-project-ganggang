package oodpassignment;



/**
 * 
 * @author Chang Wei 
 * @version 1.0 
 * @since 06/11/2021
 *
 *An interface to be used by OrderLogic so deallocate a table when the order invoice is issued
 * (bill is paid and customers left) 
 */
public interface FreeTable {
	public void freeTable(int tableNumber, int hour); 
}
