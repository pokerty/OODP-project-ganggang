package oodpassignment; 

import java.util.Scanner; 

public class ReservationBoundary {
 
	public ReservationBoundary() {
	}
	
	Scanner sc = new Scanner(System.in); 

	
	public void makeReservation(ReservationLogic reservationLogic) {
		String name; 
		int month, day, hour, pax, contact; 
		System.out.println("Please enter customer name to make reservation!"); 
		name = sc.nextLine(); 
		System.out.println("Please enter the number of pax"); 
		pax = sc.nextInt(); 
		System.out.println("Please enter month of desired reservation"); 
		month= sc.nextInt(); 
		System.out.println("Please enter day of desired reservation"); 
		day = sc.nextInt(); 
		System.out.println("Please enter time(hour) of desired reservation: (12:00/14:00/16:00/18:00/20:00)"); 
		hour = sc.nextInt();
		//minute will be 0. Reservation in chunks of 2 hr 
		System.out.println("Please enter contact details"); 
		contact = sc.nextInt(); 
		reservationLogic.makeReservation(month, day, hour, 0, pax, name, contact);
	}

	
	public void removeReservation(ReservationLogic reservationLogic) { 
		String name;  
		System.out.println("Please enter the reservation table number"); 
		int tablenumber = sc.nextInt(); 
		System.out.println("Please enter the reservation's customer name!"); 
		name = sc.next(); 
		reservationLogic.removeReservation(tablenumber,name,false); //manual removal of reservation 
	}

	public void checkReservation(ReservationLogic reservationLogic) {
		String name;  
		System.out.println("To check reservation, please enter the reservation table number"); 
		int tablenumber = sc.nextInt(); 
		System.out.println("To check reservation, please enter the customer name!"); 
		name = sc.next(); 
		reservationLogic.checkReservation(tablenumber, name); 
	}

}