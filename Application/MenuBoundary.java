package Application;
import java.util.*;

import Application.MenuItems.courseType;

public class MenuBoundary {
	Scanner sc = new Scanner(System.in);

	public void displayMenu(courseType category) {
		System.out.print("Enter the menu to display\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
	}

	public void createMenuItems(int id, String name, courseType category, String description, float price) {

		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item name\n");
		name = sc.next();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
		System.out.print("Enter the item description\n");
		description = sc.next();
		System.out.print("Enter the item price\n");
		price = sc.nextFloat();
	}

	public void removeMenuItems(int id, courseType category) {

		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
	}

	public void updateMenuItemID(int id, courseType category, int newid) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
		System.out.print("Enter the new item ID\n");
		newid = sc.nextInt();

	}
	public void updateMenuItemName(int id, courseType category, String newname) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
		System.out.print("Enter the new item name\n");
		newname = sc.next();

	}

	public void updateMenuItemDescription(int id, courseType category, String newdescription) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
		System.out.print("Enter the new item description\n");
		newdescription = sc.next();

	}

	public void updateMenuItemPrice(int id, courseType category, float newprice) {
		System.out.print("Enter the item ID\n");
		id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		switch(categorynum){
			case 1:
				category = courseType.main;
				break;
			case 2:
				category = courseType.dessert;
				break;
			case 3:
				category = courseType.drink;
				break;
		}
		System.out.print("Enter the new item price\n");
		newprice = sc.nextFloat();

	}
	public void displayPromoMenu(){
		System.out.print("Promo Menu:\n");
	}

	public void displayPromoItems(int SetId){
		System.out.print("Enter the Promotional Set ID to display\n");
		SetId = sc.nextInt();
	}

	// public void createPromoSet(int SetId, String SetName, String SetDescription, float SetPrice, ArrayList<MenuItems> SetItems){
	// 	System.out.print("Enter the Promotional Set ID\n");
	// 	SetId = sc.nextInt();
	// 	System.out.print("Enter the Promotional Set name\n");
	// 	SetName = sc.next();
	// 	System.out.print("Enter the Promotional Set description\n");
	// 	SetDescription = sc.next();
	// 	System.out.print("Enter the Promotional Set price\n");
	// 	SetPrice = sc.nextFloat();
	// 	System.out.print("Enter the Promotional Set\n");
	// 	SetItems = sc.next();
	// }

	public void removePromoSet(int SetId){
		System.out.print("Enter the Promotional Set ID to remove\n");
		SetId = sc.nextInt();
	}

	public void updateSetID(int SetId, int newid){
		System.out.print("Enter the Promotional Set ID\n");
		SetId = sc.nextInt();
		System.out.print("Enter the new Set ID\n");
		newid = sc.nextInt();
	}

	public void updateSetName(int SetId, String newname){
		System.out.print("Enter the Promotional Set ID\n");
		SetId = sc.nextInt();
		System.out.print("Enter the new Set name\n");
		newname = sc.next();
	}

	public void updateSetDescription(int SetId, String newdescription){
		System.out.print("Enter the Promotional Set ID\n");
		SetId = sc.nextInt();
		System.out.print("Enter the new Set description\n");
		newdescription = sc.next();
	}

	public void updateSetPrice(int SetId, float newprice){
		System.out.print("Enter the Promotional Set ID\n");
		SetId = sc.nextInt();
		System.out.print("Enter the new Set price\n");
		newprice = sc.nextFloat();
	}

	// public void addItemToSet(int SetId, MenuItems newitem){
	// 	System.out.print("Enter the Promotional Set ID\n");
	// 	SetId = sc.nextInt();
	// 	System.out.print("Enter the new Set price\n");
	// 	newitem = sc.next();
	// }

	public void removeItemsFromSet(int SetId, int id){
		System.out.print("Enter the Promotional Set ID\n");
		SetId = sc.nextInt();
		System.out.print("Enter the item ID to remove\n");
		id = sc.nextInt();
	}

}