package oodpassignment;


/**
 * 
 * @author Chang Wei 
 * @version 1.0 
 * @since 06/11/2021
 * An interface to be used by ReservationLogic so as to allocate and deallocate tables when reservations
 * are made and cancelled respectively 
 */
public interface CheckTable {
	public int giveTable(int pax, int hour);
	public void freeTable(int TableNumber, int hour); 
}
