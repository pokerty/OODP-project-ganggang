package oodpassignment;

import java.util.Scanner;

/**
 * ReservationBoundary is responsible for taking all the inputs to be used in
 * the functions involving reservations such as making of reservations removal
 * of reservations, checking of reservations
 * 
 * @author chang wei
 * @since 07/11/2021
 * @version 1.0
 * 
 */
public class ReservationBoundary {

	Scanner sc = new Scanner(System.in);

	/**
	 * takes in all the inputs required to make a reservation such as name of
	 * customer, no of pax, etc reservation made via use of reservationLogic object
	 * 
	 * @param reservationLogic the class that is responsible for the logics behind
	 *                         reservation
	 */
	public void makeReservation(ReservationLogic reservationLogic) {
		String name;
		int month, day, hour, pax, contact;
		System.out.println("Please enter customer name to make reservation!");
		name = sc.nextLine();
		System.out.println("Please enter the number of pax");
		pax = sc.nextInt();
		System.out.println("Please enter month (1-12) of desired reservation");
		month = sc.nextInt();
		month = month - 1;
		System.out.println("Please enter day of desired reservation");
		day = sc.nextInt();
		System.out.println("Please enter time(hour) of desired reservation: (12:00/14:00/16:00/18:00/20:00)");
		hour = sc.nextInt();
		// minute will be 0. Reservation in chunks of 2 hr
		System.out.println("Please enter contact details");
		contact = sc.nextInt();
		sc.nextLine();
		reservationLogic.makeReservation(month, day, hour, 0, pax, name, contact);
	}

	/**
	 * gets the necessary inputs to identify the correct reservation to remove.
	 * inputs such as customer name and table number is needed reservationLogic is
	 * used to remove the identified reservation
	 * 
	 * @param reservationLogic the class that is responsible for the logics behind
	 *                         reservation
	 */
	public void removeReservation(ReservationLogic reservationLogic) {
		String name;
		System.out.println("Please enter the reservation table number");
		int tablenumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the reservation's customer name!");
		name = sc.nextLine();
		reservationLogic.removeReservation(tablenumber, name, false); // manual removal of reservation
	}

	/**
	 * gets the necessary inputs such as table number and customer name to check the
	 * validity of a reservation. reservationLogic to implement the logics behind
	 * the checking of validity of reservation
	 * 
	 * @param reservationLogic the class that is responsible for the logics behind
	 *                         reservation
	 */
	public void checkReservation(ReservationLogic reservationLogic) {
		String name;
		System.out.println("To check reservation, please enter the reservation table number");
		int tablenumber = sc.nextInt();
		sc.nextLine();
		System.out.println("To check reservation, please enter the customer name!");
		name = sc.nextLine();
		reservationLogic.checkReservation(tablenumber, name);
	}

}