package oodpassignment;

public class Table {

	private int tableNumber;
	private int sizeOfTable;
	private Boolean isOccupied=false;

	public Table(int tableNumber,int sizeOfTable) {
		this.sizeOfTable = sizeOfTable;
		this.tableNumber = tableNumber;

	}

	public int getTableNumber() {
		return tableNumber;

	}

	public int getSizeOfTable() {
		return sizeOfTable;

	}
	public Boolean getIsOccupied(){
		return isOccupied;
	}
	public void changeOccupied() {
		if(isOccupied){
			isOccupied=false;
			return;
		}
		isOccupied=true;
	}

}