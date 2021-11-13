package oodpassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oodpassignment.Table;

import oodpassignment.FreeTable;

import oodpassignment.CheckTable;

/**
 * TAbleLogic implements the logical components behind the functions affecting
 * table such as the allocation and deallocation of tables as well as the
 * checking of availability of tables for a certain size of customers
 * 
 * Have many tables for different time periods so as to take in reservations at
 * different times since tables will be allocated if reservation is given at a
 * certain time
 * 
 * Have a total of 15 tables, 3 for 2 pax, 3 for 4 pax, 3 for 6 pax, 3 for 8 pax
 * and 3 for 10 pax
 *
 * @author zheng ying
 * @version 1.0
 * @since 07/11/2021
 * 
 *
 */
public class TableLogic implements CheckTable, FreeTable {
	/**
	 * collection of tables for time period 12pm-2pm
	 */
	private ArrayList<Table> tables_12_to_2 = new ArrayList<>();
	/**
	 * collection of tables for time period 2pm-4pm
	 */
	private ArrayList<Table> tables_2_to_4 = new ArrayList<>();
	/**
	 * collection of tables for time period 4pm-6pm
	 */
	private ArrayList<Table> tables_4_to_6 = new ArrayList<>();
	/**
	 * collection of tables for time period 6pm-8pm
	 */
	private ArrayList<Table> tables_6_to_8 = new ArrayList<>();
	/**
	 * collection of tables for time period 8pm-10pm
	 */
	private ArrayList<Table> tables_8_to_10 = new ArrayList<>();

	/**
	 * constructor of TableLogic initializes all tables of different timing as a
	 * list
	 */
	public TableLogic() {
		List<List<Table>> alltables = Arrays.asList(tables_12_to_2, tables_2_to_4, tables_4_to_6, tables_6_to_8,
				tables_8_to_10);
		for (int i = 0; i < alltables.size(); i++) {
			for (int i1 = 1; i1 < 4; i1++) {
				alltables.get(i).add(new Table(i1, 2));
			}
			for (int i2 = 4; i2 < 7; i2++) {
				alltables.get(i).add(new Table(i2, 4));
			}
			for (int i3 = 7; i3 < 10; i3++) {
				alltables.get(i).add(new Table(i3, 6));
			}
			for (int i4 = 10; i4 < 13; i4++) {
				alltables.get(i).add(new Table(i4, 8));
			}
			for (int i5 = 13; i5 < 16; i5++) {
				alltables.get(i).add(new Table(i5, 10));
			}
		}
	}

	/**
	 * allocates a table according to the hour of the reservation and the number of
	 * customers per group if a table is available
	 */
	public int giveTable(int customerPax, int hour) {
		List<Table> temp;
		if (14 <= hour && hour < 16) {
			temp = tables_2_to_4;
		} else if (16 <= hour && hour < 18) {
			temp = tables_4_to_6;
		} else if (18 <= hour && hour < 20) {
			temp = tables_6_to_8;
		} else if (20 <= hour && hour < 22) {
			temp = tables_8_to_10;
		} else if (12 <= hour && hour < 14) {
			temp = tables_12_to_2;
		} else {
			return -1;
		}

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getSizeOfTable() >= customerPax && !temp.get(i).getIsOccupied()) {
				temp.get(i).changeOccupied();
				return temp.get(i).getTableNumber();
			}
		}
		return -1;
	}

	/**
	 * checks if a table is available according to the specifications such as no of
	 * customers and the hour of dining
	 * 
	 * @param customerPax no of customers per table
	 * @param hour        hour of dining
	 * @return Boolean value whether table is available or not
	 */
	public Boolean checkTableAvailability(int customerPax, int hour) {

		List<Table> temp;
		if (12 <= hour && hour < 14) {
			temp = tables_12_to_2;
		} else if (14 <= hour && hour < 16) {
			temp = tables_2_to_4;
		} else if (16 <= hour && hour < 18) {
			temp = tables_4_to_6;
		} else if (18 <= hour && hour < 20) {
			temp = tables_6_to_8;
		} else if (20 <= hour && hour < 22) {
			temp = tables_8_to_10;
		} else {
			return false;
		}

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getSizeOfTable() >= customerPax && !temp.get(i).getIsOccupied()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * marks a table as unoccupied once bill is paid, based on table number and time
	 * of dining
	 */
	public void freeTable(int tableNumber, int hour) {

		List<Table> temp;
		if (14 <= hour && hour < 16) {
			temp = tables_2_to_4;
		} else if (16 <= hour && hour < 18) {
			temp = tables_4_to_6;
		} else if (18 <= hour && hour < 20) {
			temp = tables_6_to_8;
		} else if (20 <= hour && hour < 22) {
			temp = tables_8_to_10;
		} else if (12 <= hour && hour < 14) {
			temp = tables_12_to_2;
		} else {
			return;
		}
		if (temp.get(tableNumber).getIsOccupied()) {
			temp.get(tableNumber).changeOccupied();
		}
		// temp.get(tableNumber).changeOccupied();
	}

}
