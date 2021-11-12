package oodpassignment;

/**
 * Table entity class to contain the attributes needed by a table such as the
 * size of table, table number, whether it is currently occupied
 *
 * @author zheng ying
 * @since 07/11/2021
 * @version 1.0
 * 
 * 
 */
public class Table {
	/**
	 * table number of a particular table
	 */
	private int tableNumber;
	/**
	 * maximum number of people the table can accommodate
	 */
	private int sizeOfTable;
	/**
	 * tells us whether the current table is used or not
	 */
	private Boolean isOccupied = false;

	/**
	 * constructor for table, inputs required are table and size of table, which is
	 * gotten from user from the boundary class
	 * 
	 * @param tableNumber tablenumber of table
	 * @param sizeOfTable no of customer table can accomodate
	 */
	public Table(int tableNumber, int sizeOfTable) {
		this.sizeOfTable = sizeOfTable;
		this.tableNumber = tableNumber;

	}

	/**
	 * getter method for table number
	 * 
	 * @return table number
	 */
	public int getTableNumber() {
		return tableNumber;

	}

	/**
	 * getter method for size of table
	 * 
	 * @return the size of table - how many customers it can accomodate
	 */
	public int getSizeOfTable() {
		return sizeOfTable;

	}

	/**
	 * getter method for whether table is occupied
	 * 
	 * @return boolean return of whether table is occupied
	 */
	public Boolean getIsOccupied() {
		return isOccupied;
	}

	/**
	 * method to change the occupancy of a table - flips false to true, true to
	 * false
	 */
	public void changeOccupied() {
		if (isOccupied) {
			isOccupied = false;
			return;
		} else {
			isOccupied = true;
		}
	}

}