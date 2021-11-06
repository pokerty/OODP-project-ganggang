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
		StaffLogic staffLogic = new StaffLogic();
		Report report = new Report();
		ReportLogic reportLogic = new ReportLogic(report);
		OrderLogic orderLogic = new OrderLogic(report,(FreeTable)tableLogic,staffLogic);

		// to initialise everything
		MenuBoundary menuBoundary = new MenuBoundary();
		ReservationBoundary reservationBoundary = new ReservationBoundary();
		TableBoundary tableBoundary = new TableBoundary();
		OrderBoundary orderBoundary = new OrderBoundary();
		ReportBoundary reportBoundary = new ReportBoundary();
		StaffBoundary staffBoundary = new StaffBoundary();

		Scanner sc = new Scanner(System.in);
		System.out.println("\nChoose the category: ");
		System.out.printf("1. Menu\n2. Reservation\n3. Table\n4. Order\n5. Report\n6. Staff\n-1. Terminate\n");
		int cChoice = sc.nextInt();
		while(cChoice!=-1) {
		switch (cChoice) {
		case 1:
		{
			System.out.println("Choose a function in Menu: ");
			System.out.println("1. Display Menu\n2. Create menu items\n3. Remove menu items\n4. Update menu items");
			System.out.println("5. Display Promo Menu\n6. Create Promo Menu\n7. Remove Promo Menu\n8. Update Promo Menu ");
			int mChoice = sc.nextInt();
			sc.nextLine(); 

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
				sc.nextLine(); 
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
				System.out.println("1. Change ID\n2. Change Name\n3. Change Description\n4. Change Price\n"
						+ "5.Add item to set\n6.Remove item from set");
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
				case(5):
					menuBoundary.addItemToSet(menuLogic);
					break;
				case(6):
					menuBoundary.removeItemsFromSet(menuLogic);
					break; 
					
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
			}
			break;
		}
			
		case(2):
			System.out.println("Choose a function in Reservation:");
			System.out.println("1. Make reservation\n2. Remove reservation\n3. Check reservation\n");
			int rChoice = sc.nextInt();
			sc.nextLine(); 

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
			System.out.println("1. View Order\n2. New Order\n3. Add item to order\n4. Remove item from order\n5.Print Order Invoice");
			int oChoice = sc.nextInt();

			switch (oChoice) { 
			case 1:
				orderBoundary.viewOrder(orderLogic);
				break;
			case 2:
				orderBoundary.newOrder(orderLogic,menuLogic);
				break;
			case 3:
				
				System.out.println("Please enter order number!"); 
				int ordernumber = sc.nextInt();
				orderBoundary.addItemToOrder(orderLogic, menuLogic,ordernumber);
				break;
			case 4:
				orderBoundary.removeItemFromOrder(orderLogic);
				break;
			case 5: 
				orderBoundary.printOrderInvoice(orderLogic);
				break;
				
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 5:
			System.out.println("Choose a function in Report:");
			System.out.println("1. Print revenue by period\n2. Print Promotion Set by period\n3. Print Ala Carte by period\n");
			int reportChoice = sc.nextInt();
			switch (reportChoice) { // TOCHANGE: not finalised
			case 1:
				reportBoundary.reportTotal(reportLogic);
				break;
			case 2:
				reportBoundary.reportSetPromo(reportLogic);
				break;
			case 3:
				reportBoundary.reportAlaCarte(reportLogic);
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
		System.out.println("\nChoose the category: ");
		System.out.printf("1. Menu\n2. Reservation\n3.Table\n4. Order\n5. Report\n6. Staff\n-1.Terminate\n");
		cChoice = sc.nextInt();
	}
		
		System.out.println("Terminating...Saving reservations,reports,staff."); 
		reservationLogic.saveReservation(); //save reservation onto txt 
		staffLogic.staffsOverwrite(); //save changes to staff onto txt 
		reportLogic.saveReport();
		
		
}
	
}