

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ReservationLogic {

	private Reservation[] reservations;
	private CheckTable tablelogic;

	public ReservationLogic() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				//insert code here
			}
		};
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(runnable, 15, 15, TimeUnit.MINUTES);

		this.reservations = new Reservation[15]; //set reservations to be 15 
		
		System.out.println("ReservationLogic start-up complete without Table"); 
	}
	
	public ReservationLogic(CheckTable checkTable) {
		super(); 
		this.tablelogic = checkTable; 
		System.out.println("ReservationLogic start-up complete "); 
	}

	public void makeReservation(int month, int day, int hour, int minute, int pax, String name, int contact){
		int tableNumber = tablelogic.giveTable(pax);
		if(tableNumber==-1) { //no table 
			System.out.println("No available tables, sorry!"); 
			return; 
		}
		Reservation reservation = new Reservation(month,day,hour,minute,pax,name,contact,tableNumber); 
		reservations[tableNumber]= reservation; 
		System.out.println("Reservation successful at table "+tableNumber+", "+day+"/"+month+","+hour+":"+minute); 
		
	}

	/**
	 * 
	 * @param Boolean
	 */
	public void removeReservation(int tableNumber,String name, int month, int day,int hour, int minute) {
		int validity = checkReservation(tableNumber, name, month, day, hour, minute); 
		if(validity==1) {
			reservations[tableNumber]=null; 
			//rely on java auto garbage collection to delete reservation object 
			tablelogic.freeTable(tableNumber); 
			//free up the table after reservation removal 
			System.out.println("Reservation removed!"); 
		}
		else if(validity==0) {
			System.out.println("No such reservation exists, unable to remove");
		}
		else {
			System.out.println("Please ensure your inputs are correct, especially tableNumber"); 
		}
		
		
	}

	public int checkReservation(int TableNumber, String name, int month, int day,int hour, int minute) {
		if(TableNumber>-1 && TableNumber< 15) {
			Reservation entry; 
			entry = reservations[TableNumber]; 
			Calendar dateandtime = entry.getDateandtime();
			if(entry.getName()==name && dateandtime.get(Calendar.MONTH)==month
				&& dateandtime.get(Calendar.DAY_OF_MONTH)==day 
				&& dateandtime.get(Calendar.HOUR_OF_DAY)==hour 
				&& dateandtime.get(Calendar.MINUTE)==minute) {
				System.out.println("Reservation exists"); 
				return 1; 
			}
				
			else {
				System.out.println("No such reservation exists!"); 
				return 0; 
			}
				
		}	
		else {
			System.out.println("Table input exceeded bounds"); 
			return -1; 
		}
		
	}

}
