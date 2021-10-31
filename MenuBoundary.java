import java.util.*;
import MenuItems.courseType;
import MenuLogic;
public class MenuBoundary {
	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		MenuLogic.displayMenu();
	}

	public void createMenuItems(int id, String name, MenuItems.courseType category, String description, float price) {

		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item name\n");
		name = sc.next();
		System.out.print("Enter the item category\n");
		category = (courseType)sc.next();
		System.out.print("Enter the item description\n");
		description = sc.next();
		System.out.print("Enter the item price\n");
		price = sc.nextFloat();
	}

	public void removeMenuItems(int id, courseType category) {

		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\n");
		category = (courseType)sc.next();
	}

	public void updateMenuItemID(int id, courseType category, int newid) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\n");
		category = (courseType)sc.next();
		System.out.print("Enter the new item ID\n");
		newid = sc.nextInt();

	}
	public void updateMenuItemName(int id, courseType category, String newname) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\n");
		category = (courseType)sc.next();
		System.out.print("Enter the new item name\n");
		newname = sc.next();

	}

	public void updateMenuItemDescription(int id, courseType category, String newdescription) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\n");
		category = (courseType)sc.next();
		System.out.print("Enter the new item description\n");
		newdescription = sc.next();

	}

	public void updateMenuItemPrice(int id, courseType category, float newprice) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\n");
		category = (courseType)sc.next();
		System.out.print("Enter the new item price\n");
		newprice = sc.nextFloat();

	}
}