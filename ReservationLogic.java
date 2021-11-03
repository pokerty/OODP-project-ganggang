
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class ReservationLogic {

	private ArrayList<Reservation> reservations;
	private CheckTable tablelogic;

	
	
	public ReservationLogic(CheckTable checkTable) {
		this.reservations = new ArrayList<Reservation>();
 		this.tablelogic = checkTable; 
		loadReservation(); 
		System.out.println("ReservationLogic start-up complete "); 
	}

	
	
	
	public void makeReservation(int month, int day, int hour, int minute, int pax, String name, int contact){
		int tableNumber = tablelogic.giveTable(pax,hour);
		if(tableNumber==-1) { //no table 
			System.out.println("No available tables at the time, sorry!"); 
			return; 
		}
		Reservation reservation = new Reservation(month,day,hour,minute,pax,name,contact,tableNumber); 
		reservations.add(reservation); 
		System.out.println("Reservation successful at table "+tableNumber+", "+day+"/"+month+","+hour+":"+minute); 
		
	}
	
	
	

	
	public void removeReservation(int tableNumber,String name, boolean expired) {
		int validity = checkReservation(tableNumber, name); 
		if(validity>=0) {
			tablelogic.freeTable(tableNumber, reservations.get(validity).getDateandtime().get(Calendar.HOUR_OF_DAY)); 
			//free up the table after reservation removal 
			reservations.remove(validity); 
			//rely on java auto garbage collection to delete reservation object. 
			if(expired==true)
				System.out.println("Reservation expired - Removed!"); 
			else
			System.out.println("Reservation will be removed! - Removed!"); 
		}
		else if(validity==-1) {
			System.out.println("No such reservation exists, unable to remove");
		}
		else {
			System.out.println("Please ensure your inputs are correct, especially tableNumber"); 
		}
		
		
	}

	public int checkReservation(int TableNumber, String name) {
		if(TableNumber>-1 && TableNumber< 15) { // change parameters 
			for(int i=0;i<reservations.size();i++) {
				if(reservations.get(i).getName().equalsIgnoreCase(name)
						&& reservations.get(i).getTableNumber() == TableNumber) {
					System.out.println("Reservation is valid on " + reservations.get(i).getDateandtime().getTime()); 
					return i; 	
				}
			}
			//finished searching, cant find 
			System.out.println("Said person does not have such a reservation!"); 
			return -1; 
			}
					
		else {  //error checking code 
			System.out.println("Table input exceeded bounds"); 
			return -2; 
		}
		
	}
	
	
	private void loadReservation(){
		try {
			int month,day,hour,minute,pax,contact,tablenumber;
			String name; 
			FileReader reservationList = new FileReader("reservationList.txt"); 
			BufferedReader reader = new BufferedReader(reservationList);
			ArrayList<String> list = new ArrayList<String>(); 
			String info = reader.readLine(); 
			while(info!=null) {
				list.add(info.replace("empty_string", "")); 
	            info = reader.readLine();
			}
			
			int i =0; 
			
			while(i<list.size()) {
				name = list.get(i); //format is first:name
				tablenumber = Integer.parseInt(list.get(i+1)); //Integer.parseInt() to convert string to integer. second is tablenum
				contact = Integer.parseInt(list.get(i+2)); //3rd is contact 
				pax = Integer.parseInt(list.get(i+3)); //4th is no of pax 
				month = Integer.parseInt(list.get(i+4)); //5th is month 
				day = Integer.parseInt(list.get(i+5)); //6th is day 
				hour = Integer.parseInt(list.get(i+6)); //7th is hour 
				minute = Integer.parseInt(list.get(i+7)); //8th is minute 
				Reservation reservation = new Reservation(month,day,hour,minute,pax,name,contact,tablenumber); //create reservation
				reservations.add(reservation); //allocate index according to table number 
				i = i+9; //should be start of next entry , don't take empty string 
			}
			
			reader.close(); //close file reader 
			
			/* for testing 
			for(int j=0;j<15;j++) {
				if(reservations[j]!=null) {
					System.out.println(reservations[j].getName()); 
				}
			}
		*/
		}
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	public void saveReservation() {
		try {
			FileWriter write = new FileWriter("reservationList.txt"); 
			@SuppressWarnings("resource")
			BufferedWriter bwrite = new BufferedWriter(write); 
			int noOfReservations = reservations.size();
			int i;   //need write in order of name,tablenumber,contact,pax,month,day,hour,minute; 
			for(i=0;i<noOfReservations;i++) {
				if(reservations.get(i)!=null){
					bwrite.write(reservations.get(i).getName());//write name
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getTableNumber())); //convert table no to string and write 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getContact())); //write contact 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getPax())); //write pax 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.MONTH))); //write month 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.DAY_OF_MONTH)));//write day 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.HOUR_OF_DAY)));
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.MINUTE)));
					bwrite.newLine();
					bwrite.newLine(); //TO SEPERATE THE DIFFERENT RESERVATIONS 
				}	
			}
			
		bwrite.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
