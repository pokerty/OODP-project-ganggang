import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableLogic implements CheckTable{
	private List<Table> tables_12_to_2 ;
	private List<Table> tables_2_to_4 ;
	private List<Table> tables_4_to_6 ;
	private List<Table> tables_6_to_8 ;
	private List<Table> tables_8_to_10 ;

	public TableLogic() {
		List<List<Table>> alltables = Arrays.asList(tables_12_to_2,tables_2_to_4,tables_4_to_6,tables_6_to_8,tables_8_to_10);
		for(int i=0;i<alltables.size();i++)
		{
			for (int i1 = 1; i1 < 4; i1++) {
				alltables.get(i1).add(new Table(i1, 2));
			}
			for (int i2 = 4; i2 < 7; i2++) {
				alltables.get(i2).add(new Table(i2, 4));
			}
			for (int i3 = 7; i3 < 10; i3++) {
				alltables.get(i3).add(new Table(i3, 6));
			}
			for (int i4 = 10; i4 < 13; i4++) {
				alltables.get(i4).add(new Table(i4, 8));
			}
			for (int i5 = 13; i5 < 16; i5++) {
				alltables.get(i5).add(new Table(i5, 10));
			}
		}
	}


	public int giveTable(int customerPax,int hour) {
		List<Table> temp ;
		if(2<=hour||hour<4){
			temp=tables_2_to_4;
		}
		else if(4<=hour||hour<6){
			temp=tables_4_to_6;
		}
		else if(6<=hour||hour<8){
			temp=tables_6_to_8;
		}
		else if(8<=hour||hour<10){
			temp=tables_8_to_10;
		}
		else if(12==hour||hour<2){
			temp=tables_12_to_2;
		}
		else{
			return -1;
		}

		for(int i = 0;i<temp.size();i++){
			if(temp.get(i).getSizeOfTable()>=customerPax&&!temp.get(i).getIsOccupied()){
				temp.get(i).changeOccupied();
				return temp.get(i).getTableNumber();
			}
		}
		return -1;
	}

	public Boolean checkTableAvailability(int customerPax) {
		List<List<Table>> alltables = Arrays.asList(tables_12_to_2,tables_2_to_4,tables_4_to_6,tables_6_to_8,tables_8_to_10);
		for(int j=0;j< alltables.size();j++){
			for (int i = 0; i < alltables.get(j).size(); i++) {
				if (alltables.get(j).get(i).getSizeOfTable() >= customerPax && !alltables.get(j).get(i).getIsOccupied()) {
					return true;
				}
			}
		}
		return false;
	}

	public void freeTable(int tableNumber,int hour) {

		List<Table> temp ;
		if(2<=hour||hour<4){
			temp=tables_2_to_4;
		}
		else if(4<=hour||hour<6){
			temp=tables_4_to_6;
		}
		else if(6<=hour||hour<8){
			temp=tables_6_to_8;
		}
		else if(8<=hour||hour<10){
			temp=tables_8_to_10;
		}
		else if(12==hour||hour<2){
			temp=tables_12_to_2;
		}
		else{
			return ;
		}
		if(temp.get(tableNumber).getIsOccupied())
		{
			temp.get(tableNumber).changeOccupied();
		}
		temp.get(tableNumber).changeOccupied();
	}


}