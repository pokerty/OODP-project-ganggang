import java.util.Scanner;

public class RestaurantApp {

	// can these new object instances be static??
	private static MenuLogic menuLogic = new MenuLogic();
	private static ReservationLogic reservationLogic = new ReservationLogic();
	private static TableLogic tableLogic = new TableLogic();
	private static OrderLogic orderLogic = new OrderLogic();
	private static ReportBoundary reportLogic = new ReportBoundary();
	private static StaffLogic staffLogic = new StaffLogic();

	// public static void startApp() {
	// // to initialise everything
	// //TODO: Add constructors that take in logic instances to boundary classes
	// MenuBoundary menuBoundary = new MenuBoundary(menuLogic);
	// ReservationBoundary reservationBoundary = new
	// ReservationBoundary(reservationLogic);
	// TableBoundary tableBoundary = new TableBoundary(tableLogic);
	// OrderBoundary orderBoundary = new OrderBoundary(orderLogic);
	// ReportBoundary reportBoundary = new ReportBoundary(reportLogic);
	// StaffBoundary staffBoundary = new StaffBoundary(staffLogic);
	// }

	public static void main(String[] args) {

		// startApp();

		// to initialise everything
		// TODO: Add constructors that take in logic instances to boundary classes
		MenuBoundary menuBoundary = new MenuBoundary(menuLogic);
		ReservationBoundary reservationBoundary = new ReservationBoundary(reservationLogic);
		TableBoundary tableBoundary = new TableBoundary(tableLogic);
		OrderBoundary orderBoundary = new OrderBoundary(orderLogic);
		ReportBoundary reportBoundary = new ReportBoundary(reportLogic);
		StaffBoundary staffBoundary = new StaffBoundary(staffLogic);

		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the category: ");
		System.out.printf("1. Menu\n2. Reservation\n3.Table\n4. Order\n5. Report\n6. Staff\n");
		int cChoice = sc.nextInt();
		switch (cChoice) {
		case 1:
			System.out.println("Choose a function in Menu: ");
			System.out.println("1. Display Menu\n2. Create menu items\n3. Remove menu items\n4. Update menu items\n");
			int mChoice = sc.nextInt();

			switch (mChoice) {
			case 1:
				menuBoundary.displayMenu();
				break;
			case 2:
				menuBoundary.createMenuItems();
				break;
			case 3:
				menuBoundary.removeMenuItems();
				break;
			case 4:
				menuBoundary.updateMenuItems(); // TOCHANGE: update only one menu category at one time
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 2:
			System.out.println("Choose a function in Reservation:");
			System.out.println("1. Make reservation\n2. Remove reservation\n3. Check reservation\n");
			int rChoice = sc.nextInt();

			switch (rChoice) {
			case 1:
				reservationBoundary.makeReservation();
				break;
			case 2:
				reservationBoundary.removeReservation(); // ignore error
				break;
			case 3:
				reservationBoundary.checkReservation();
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 3:
			System.out.println("Choose a function in Table:");
			System.out.println("1. Give a table\n2. Check table availability\n3. Free a table\n");
			int tChoice = sc.nextInt();

			switch (tChoice) {
			case 1:
				tableBoundary.giveTable();
				break;
			case 2:
				tableBoundary.checkTableAvailability();
				break;
			case 3:
				tableBoundary.freeTable();
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
				orderBoundary.viewOrder();
				break;
			case 2:
				orderBoundary.newOrder();
				break;
			case 3:
				orderBoundary.addItemToOrder();
				break;
			case 4:
				orderBoundary.removeItemFromOrder();
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
				reportBoundary.printRevenue();
				break;
			case 2:
				reportBoundary.printSetPromo();
				break;
			case 3:
				reportBoundary.printAlaCarte();
				break;
			default:
				System.out.println("Please choose a valid option.");
				break;
			}

			break;
		case 6:
			System.out.println("Choose a function in Staff:");
			System.out.println("1. Add staff\n2. Display staff\n3. Assign staff to order\n");
			int sChoice = sc.nextInt();

			switch (sChoice) {
			case 1:
				staffBoundary.addStaff();
				break;
			case 2:
				staffBoundary.displayStaff();
				break;
			case 3:
				staffBoundary.handler();
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

	}
}
