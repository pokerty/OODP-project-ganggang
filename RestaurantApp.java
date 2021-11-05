package oodpassignment;
import java.util.Scanner;

public class RestaurantApp {

	

	// public static void startApp() {
	// // to initialise everything
	// MenuBoundary menuBoundary = new MenuBoundary(menuLogic);
	// ReservationBoundary reservationBoundary = new
	// ReservationBoundary(reservationLogic);
	// TableBoundary tableBoundary = new TableBoundary(tableLogic);
	// OrderBoundary orderBoundary = new OrderBoundary(orderLogic);
	// ReportBoundary reportBoundary = new ReportBoundary(reportLogic);
	// StaffBoundary staffBoundary = new StaffBoundary(staffLogic);
	// }

	public void start() {

		// startApp();
		MenuLogic menuLogic = new MenuLogic();
		CheckTable tableLogic = new TableLogic();
		ReservationLogic reservationLogic = new ReservationLogic(tableLogic);
		ReportLogic reportLogic = new ReportLogic();
		StaffLogic staffLogic = new StaffLogic();
		Report report = new Report();
		OrderLogic orderLogic = new OrderLogic(report,reportLogic,menuLogic,(FreeTable)tableLogic,staffLogic);

		// to initialise everything
		MenuBoundary menuBoundary = new MenuBoundary();
		ReservationBoundary reservationBoundary = new ReservationBoundary();
		TableBoundary tableBoundary = new TableBoundary();
		//OrderBoundary orderBoundary = new OrderBoundary();
		//ReportBoundary reportBoundary = new ReportBoundary();
		StaffBoundary staffBoundary = new StaffBoundary();

		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the category: ");
		System.out.printf("1. Menu\n2. Reservation\n3.Table\n4. Order\n5. Report\n6. Staff\n");
		int cChoice = sc.nextInt();
		while(cChoice!=-1) {
		switch (cChoice) {
		case 1:
		{
			System.out.println("Choose a function in Menu: ");
			System.out.println("1. Display Menu\n2. Create menu items\n3. Remove menu items\n4. Update menu items\n");
			System.out.println("5. Display Promo Menu\n6.Create Promo Menu\n7.Remove Promo Menu\n8.Update Promo Menu ");
			int mChoice = sc.nextInt();

			switch (mChoice) {
			case 1:
				menuBoundary.displayMenu(menuLogic);
				break;
			case 2:
				menuBoundary.createMenuItems(menuLogic);
				break;
			case 3:
				menuBoundary.removeMenuItems(menuLogic);
				break;
			case 4:
				System.out.println("1. Change ID\n2. Change Name\n3. Change Description\n4. Change Price\n");
				int choicethird = sc.nextInt();
				switch(choicethird) {
				case(1):
					menuBoundary.updateMenuItemID(menuLogic);
					break; 
				case(2):
					menuBoundary.updateMenuItemName(menuLogic);
					break; 
				case(3):
					menuBoundary.updateMenuItemDescription(menuLogic);
					break;
				case(4):
					menuBoundary.updateMenuItemPrice(menuLogic);
					break;
				default:
					System.out.println("Please choose a valid option.");
					break;
				}
				break;
			case 5:
				menuBoundary.displayPromoMenu(menuLogic);
				break;
			case 6:
				menuBoundary.createPromoSet(menuLogic);
				break;
			case 7:
				menuBoundary.removePromoSet(menuLogic);
				break;
			case 8:
				System.out.println("1. Change ID\n2. Change Name\n3. Change Description\n4. Change Price\n");
				int choicefourth = sc.nextInt();
				switch(choicefourth) {
				case(1):
					menuBoundary.updateSetID(menuLogic);
					break; 
				case(2):
					menuBoundary.updateSetName(menuLogic);
					break; 
				case(3):
					menuBoundary.updateSetDescription(menuLogic);
					break;
				case(4):
					menuBoundary.updateSetPrice(menuLogic);
					break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
			}
		}
			
		case(2):
			System.out.println("Choose a function in Reservation:");
			System.out.println("1. Make reservation\n2. Remove reservation\n3. Check reservation\n");
			int rChoice = sc.nextInt();

			switch (rChoice) {
			case 1:
				reservationBoundary.makeReservation(reservationLogic);
				break;
			case 2:
				reservationBoundary.removeReservation(reservationLogic); // ignore error
				break;
			case 3:
				reservationBoundary.checkReservation(reservationLogic);
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 3:
			System.out.println("Choose a function in Table:");
			System.out.println("1.Check table availability");
			int tChoice = sc.nextInt();

			switch (tChoice) {
			case 1:
				tableBoundary.checkTableAvailability((TableLogic)tableLogic);
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 4:
			System.out.println("Choose a function in Order:");
			System.out.println("1. View Order\n2. New Order\n3. Add item to order\n4. Remove item from order");
			int oChoice = sc.nextInt();

			switch (oChoice) { // TOCHANGE: not finalised
			case 1:
				System.out.println("Enter order number"); 
				int orderno = sc.nextInt(); 
				orderLogic.viewOrder(orderno);
				break;
			case 2:
				orderLogic.newOrder();
				break;
			case 3:
				System.out.println("Enter order number"); 
				int orderno1 = sc.nextInt(); 
				orderLogic.addItemToOrder(orderno1, menuLogic);
				break;
			case 4:
				System.out.println("Enter order number"); 
				int orderno2 = sc.nextInt(); 
				orderLogic.removeItemFromOrder(orderno2);
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 5:
			System.out.println("Choose a function in Report:");
			System.out.println("1. Print revenue\n2. Print Promotion Set\n3. Print Ala Carte\n");
			int reportChoice = sc.nextInt();

			switch (reportChoice) { // TOCHANGE: not finalised
			case 1:
				reportLogic.calculateTotalRevenue();
				break;
			case 2:
				reportLogic.calculateSetPromoRevenue();
				break;
			case 3:
				reportLogic.calculateAlaCateRevenue();
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 6:
			System.out.println("Choose a function in Staff:");
			System.out.println("1. Add staff\n2. Display staff\n");
			int sChoice = sc.nextInt();

			switch (sChoice) {
			case 1:
				staffBoundary.addStaff(staffLogic);
				break;
			case 2:
				staffBoundary.displayStaff(staffLogic);
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		default:
			System.out.println("Please choose a valid option.");
			break;
		}
		System.out.println("Choose the category: ");
		System.out.printf("1. Menu\n2. Reservation\n3.Table\n4. Order\n5. Report\n6. Staff\n");
		cChoice = sc.nextInt();
	}
}
	
}