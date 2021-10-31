import java.util.List;

public class TableLogic implements CheckTable{
	private List<Table> tables ;

	public TableLogic() {
		for(int i=1;i<4;i++){
			tables.add(new Table(i, 2));
		}
		for(int i=4;i<7;i++){
			tables.add(new Table(i, 4));
		}
		for(int i=7;i<10;i++){
			tables.add(new Table(i, 6));
		}
		for(int i=10;i<13;i++){
			tables.add(new Table(i, 8));
		}
		for(int i=13;i<16;i++){
			tables.add(new Table(i, 10));
		}
	}


	public int giveTable(int customerPax) {
		for(int i = 0;i<tables.size();i++){
			if(tables.get(i).getSizeOfTable()>=customerPax&&!tables.get(i).getIsOccupied()){
				tables.get(i).changeOccupied();
				return tables.get(i).getTableNumber();
			}
		}
		return -1;
	}

	public Boolean checkTableAvailability(int customerPax) {
		for(int i = 0;i<tables.size();i++){
			if(tables.get(i).getSizeOfTable()>=customerPax&&!tables.get(i).getIsOccupied()){
				return true;
			}
		}
		return false;
	}

	public void freeTable(int tableNumber) {
		if(tables.get(tableNumber).getIsOccupied())
		{
			tables.get(tableNumber).changeOccupied();
		}
		tables.get(tableNumber).changeOccupied();
	}


}