package oodpassignment;

import java.util.Scanner;

import oodpassignment.Job;

/**
 * This is a boundary class that uses the StaffLogic class and is responsible
 * for interacting with the user.
 */

public class StaffBoundary {

	Scanner sc = new Scanner(System.in);

	/**
	 * This method is responsible for scanning in staff details when a new staff is
	 * going to be added.
	 */
	public void addStaff(StaffLogic staffLogic) {
		System.out.println("Input staff name: ");
		String name = sc.nextLine();
		System.out.println("Input staff gender: F/M ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		System.out.println("Input staff ID: ");
		int ID = sc.nextInt();
		System.out.println("Input staff job: (0) for Manager, (1) for Waiter, (2) for Chef");
		int job = sc.nextInt();
		if (job == 0) {
			staffLogic.addStaff(name, gender, ID, Job.Manager);
		} else if (job == 1) {
			staffLogic.addStaff(name, gender, ID, Job.Waiter);
		} else {
			staffLogic.addStaff(name, gender, ID, Job.Chef);
		}
	}

	/**
	 * This method calls the displayStaff method from StaffLogic class to print out
	 * the list of staff and their details.
	 */

	public void displayStaff(StaffLogic staffLogic) {
		staffLogic.displayStaff();
	}

	/**
	 * This method calls the handler method from StaffLogic class to select a staff
	 * member who will handle an order.
	 */
	public void handler(StaffLogic staffLogic) {
		staffLogic.handler();
	}

}