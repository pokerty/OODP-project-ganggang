package oodpassignment;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import oodpassignment.Report;

/**
 * ReportBoundary serves as the boundary class to take in inputs for all report
 * functions such as calculation of revenue of restaurant
 * 
 * @author zheng ying
 * @version 1.0
 * @since 07/11/2021
 *
 */
public class ReportBoundary {

	Scanner sc = new Scanner(System.in);

	/**
	 * prints out the total revenue of the restaurant (all items) depending on month
	 * or day - inputs to be taken in this class
	 * 
	 * @param reportLogic the class that is responsible for the logics behind report
	 *                    class
	 * @param report the class that holds the collection of orders 
	 */
	public void reportTotal(ReportLogic reportLogic, Report report) {
		// Using Calendar class
		Calendar cal = Calendar.getInstance();
		Date dateandtime = cal.getTime();
		cal.setTime(dateandtime);
		System.out.println("Enter choice");
		System.out.println("1)To get total revenue for 1 month(30days)\n2)To get total revenue for 1 day");
		int choice = sc.nextInt();
		switch (choice) {
		case (1):
			cal.add(Calendar.MONTH, -1);
			float value = reportLogic.calculateTotalRevenue(cal, report);
			System.out.println("Past 30 days revenue is : " + value);
			break;
		case (2):
			cal.add(Calendar.DAY_OF_MONTH, -1);
			float value1 = reportLogic.calculateTotalRevenue(cal, report);
			System.out.println("Past 1 day revenue is : " + value1);
			break;
		}
	}

	/**
	 * prints out the revenue from all ala carte items in a specified time frame
	 * (month/day) - inputs to be taken in this class
	 * 
	 * @param reportLogic the class that is responsible for the logics behind report
	 *                    class
	 * @param report the class that holds the collection of orders 
	 */
	public void reportAlaCarte(ReportLogic reportLogic, Report report) {
		Calendar cal = Calendar.getInstance();
		Date dateandtime = cal.getTime();
		cal.setTime(dateandtime);
		System.out.println("Enter choice");
		System.out.println("1)To get ala carte revenue for 1 month(30days)\n2)To get ala carte revenue for 1 day");
		int choice = sc.nextInt();
		switch (choice) {
		case (1):
			cal.add(Calendar.MONTH, -1);
			float value = reportLogic.calculateAlaCarteRevenue(cal, report);
			System.out.println("Past 30 days ala carte revenue is : " + value);
			break;
		case (2):
			cal.add(Calendar.DAY_OF_MONTH, -1);
			float value1 = reportLogic.calculateAlaCarteRevenue(cal, report);
			System.out.println("Past 1 day ala carte revenue is : " + value1);
			break;
		}

	}

	/**
	 * prints out the revenue from the promotional sets that was ordered in a
	 * specified time frame (month/day) - inputs to be taken in this class
	 * 
	 * @param reportLogic the class that is responsible for the logics behind report
	 *                    class
	 * @param report the class that holds the collection of orders 
	 */
	public void reportSetPromo(ReportLogic reportLogic, Report report) {
		Calendar cal = Calendar.getInstance();
		Date dateandtime = cal.getTime();
		cal.setTime(dateandtime);
		System.out.println("Enter choice");
		System.out.println("1)To get set promo revenue for 1 month(30days)\n2)To get set promo revenue for 1 day");
		int choice = sc.nextInt();
		switch (choice) {
		case (1):
			cal.add(Calendar.MONTH, -1);
			float value = reportLogic.calculateSetPromoRevenue(cal, report);
			System.out.println("Past 30 days set promo revenue is : " + value);
			break;
		case (2):
			cal.add(Calendar.DAY_OF_MONTH, -1);
			float value1 = reportLogic.calculateSetPromoRevenue(cal, report);
			System.out.println("Past 1 day set promo revenue is : " + value1);
			break;
		}

	}

}
