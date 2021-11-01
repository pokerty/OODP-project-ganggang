

import java.util.Scanner; 

public class ReservationBoundary {

	private ReservationLogic reservationLogic; 
	
	public ReservationBoundary(ReservationLogic reservationLogic) {
		this.reservationLogic = reservationLogic; 
	}
	
	Scanner sc = new Scanner(System.in); 

	
	public void makeReservation() {
		String name; 
		int month, day, hour, minute, pax, contact; 
		System.out.println("Please enter customer name to make reservation!"); 
		name = sc.next(); 
		System.out.println("Please enter the number of pax"); 
		pax = sc.nextInt(); 
		System.out.println("Please enter month of desired reservation"); 
		month= sc.nextInt(); 
		System.out.println("Please enter day of desired reservation"); 
		day = sc.nextInt(); 
		System.out.println("Please enter time(hour) of desired reservation"); 
		hour = sc.nextInt();
		System.out.println("Please enter time(minute) of desired reservation"); 
		minute = sc.nextInt(); 
		System.out.println("Please enter contact details"); 
		contact = sc.nextInt(); 
		reservationLogic.makeReservation(month, day, hour, minute, pax, name, contact);
	}

	/**
	 * 
	 * @param Boolean
	 */
	public void removeReservation() {
		String name;  
		System.out.println("Please enter the reservation table number"); 
		int tablenumber = sc.nextInt(); 
		System.out.println("Please enter the reservation's customer name!"); 
		name = sc.next(); 
		reservationLogic.removeReservation(tablenumber,name);
	}

	public void checkReservation() {
		String name;  
		System.out.println("To check reservation, please enter the reservation table number"); 
		int tablenumber = sc.nextInt(); 
		System.out.println("To check reservation, please enter the customer name!"); 
		name = sc.next(); 
		reservationLogic.checkReservation(tablenumber, name); 
	}

}
