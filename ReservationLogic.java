
package assignmentOODP;

import java.util.ArrayList; // import the ArrayList class

public class ReservationLogic {

	private ArrayList<Reservation> reservations;
	private CheckTable checkTable;

	public ReservationLogic() {
		this.reservations = new ArrayList <Reservation>(); 
		
		System.out.println("ReservationLogic start-up complete"); 
	}

	public void makeReservation() {
		Reservation reservation = new Reservation(); 
		reservations.add(reservation); 
	}
	
	public void makeReservation(int month, int day, int hour, int minute, int pax, String name, int contact){
		int tableNumber = checkTable.giveTable();
		if(tableNumber==-1) { //no table 
			System.out.println("No available tables, sorry!"); 
			return; 
		}
		Reservation reservation = new Reservation(month,day,hour,minute,pax,name,contact,tableNumber); 
		reservations.add(reservation); 
		
	}

	/**
	 * 
	 * @param Boolean
	 */
	public void removeReservation(int Boolean) {
		// TODO - implement ReservationLogic.removeReservation
		throw new UnsupportedOperationException();
	}

	public void checkReservation() {
		// TODO - implement ReservationLogic.checkReservation
		throw new UnsupportedOperationException();
	}

}
