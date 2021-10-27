import java.util.List;

public class TableLogic {
	private List<Table> tables ;

	public TableLogic() {

	}

	public void addTable(int tableNumber,int sizeOfTable) {
		if(tables.size()==0) {
			tables.add(new Table(tableNumber, sizeOfTable));
			return;
		}
		for(int i = 0;i<tables.size();i++) {
			if(tables.get(i).getSizeOfTable()>=sizeOfTable)
			tables.add(i,new Table(tableNumber, sizeOfTable));
			return;
		}
		tables.add(new Table(tableNumber, sizeOfTable));
	}

	public int giveTable(int customerPax) {
		for(int i = 0;i<tables.size();i++){
			if(tables.get(i).getSizeOfTable()>=customerPax&&!tables.get(i).getIsOccupied()){
				tables.get(i).operation();
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

	public Boolean freeTable(int tableNumber) {
		for(int i = 0;i<tables.size();i++){
			if(tables.get(i).getTableNumber()>=tableNumber){
				tables.get(i).operation();
				return true;
			}
		}
		return false;
	}


}