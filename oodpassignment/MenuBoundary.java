package oodpassignment;

import java.util.*;

/**
 * MenuBoundary is the boundary class for menu related functions, where inputs
 * are taken in here via the java Scanner class
 * 
 * @author chang wei hong po
 * @since 06/11/2021
 * @version 1.0
 * 
 *
 */

public class MenuBoundary {
	Scanner sc = new Scanner(System.in);

	/**
	 * in displayMenu(), the Menu will be displayed via using the menuLogic object
	 * which is passed in as an argument
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void displayMenu(MenuLogic menuLogic) {
		System.out.print("Enter the menu to display\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();

		menuLogic.displayMenu(categorynum);
	}

	/**
	 * create additional MenuItems not previously in the loaded .txt file. The item
	 * ID,name,category,description and price will be scanned in and added to the
	 * collection of MenuItems this is done via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void createMenuItems(MenuLogic menuLogic) {

		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the item name\n");
		String name = sc.nextLine();
		System.out.print("Enter the item category\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the item description\n");
		String description = sc.nextLine();
		System.out.print("Enter the item price\n");
		float price = sc.nextFloat();
		sc.nextLine();

		menuLogic.createMenuItems(id, name, categorynum, description, price);
	}

	/**
	 * removes the desired menu item from the list of menu items through the use of
	 * item ID and item category (each item has its own unique ID which allows us to
	 * identify them) this is done via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void removeMenuItems(MenuLogic menuLogic) {

		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();
		menuLogic.removeMenuItems(id, categorynum);

	}

	/**
	 * changes the item ID of a MenuItem to a new item ID this is done via menuLogic
	 * object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateMenuItemID(MenuLogic menuLogic) {
		System.out.print("Enter the old item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the new item ID\n");
		int newid = sc.nextInt();
		menuLogic.updateMenuItemID(id, categorynum, newid);

	}

	/**
	 * changes the item name of a MenuItem via item ID and category this is done via
	 * menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateMenuItemName(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the new item name\n");
		String newname = sc.nextLine();
		menuLogic.updateMenuItemName(id, categorynum, newname);

	}

	/**
	 * changes the item description of a MenuItem via item ID and category this is
	 * done via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateMenuItemDescription(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the new item description\n");
		String newdescription = sc.nextLine();
		menuLogic.updateMenuItemDescription(id, categorynum, newdescription);

	}

	/**
	 * updates the item price of a MenuItem via item ID and category this is done
	 * via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateMenuItemPrice(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\n1) Main\n2) Dessert\n3) Drink\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the new item price\n");
		float newprice = sc.nextFloat();
		menuLogic.updateMenuItemPrice(id, categorynum, newprice);

	}

	/**
	 * displays the promotional set menu, which have different combinations of ala
	 * carte items\ this is done via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void displayPromoMenu(MenuLogic menuLogic) {
		System.out.print("Promo Menu:\n");
		menuLogic.displayPromoMenu();

	}

	/**
	 * creates a new promotional set which have different combinations of ala carte
	 * items this is done via menuLogic object that is passed in A unique ID, name,
	 * description,price and the menu items to be included needs to be given as
	 * input
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void createPromoSet(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the Promotional Set name\n");
		String SetName = sc.nextLine();
		System.out.print("Enter the Promotional Set description\n");
		String SetDescription = sc.nextLine();
		System.out.print("Enter the Promotional Set price\n");
		float SetPrice = sc.nextFloat();
		int itemID = 0;
		ArrayList<Integer> listOfIDs = new ArrayList<Integer>();
		while (itemID != -1) {
			displayMenu(menuLogic);
			System.out.print("Enter the ID of the menu items you want to add to set, -1 to terminate\n");
			itemID = sc.nextInt();
			listOfIDs.add(itemID);
		}
		menuLogic.createPromoSet(SetId, SetName, SetDescription, SetPrice, listOfIDs);

	}

	/**
	 * removes a promo set via its set ID this is done via menuLogic object that is
	 * passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void removePromoSet(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID to remove\n");
		int SetId = sc.nextInt();
		menuLogic.removePromoSet(SetId);
	}

	/**
	 * updates the promo set's id to a new one this is done via menuLogic object
	 * that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateSetID(MenuLogic menuLogic) {
		System.out.print("Enter the old Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the new Set ID\n");
		int newid = sc.nextInt();
		menuLogic.updateSetID(SetId, newid);
	}

	/**
	 * updates the promo set's name of your choice using set ID this is done via
	 * menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateSetName(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the new Set name\n");
		String newname = sc.nextLine();
		menuLogic.updateSetName(SetId, newname);
	}

	/**
	 * updates a promo set's description using set ID this is done via menuLogic
	 * object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateSetDescription(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the new Set description\n");
		String newdescription = sc.nextLine();
		menuLogic.updateSetDescription(SetId, newdescription);
	}

	/**
	 * will update a promo set's price using set ID this is done via menuLogic
	 * object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void updateSetPrice(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the new Set price\n");
		float newprice = sc.nextFloat();
		menuLogic.updateSetPrice(SetId, newprice);
	}

	/**
	 * will add a menu item to the promo set using set id and menu id of the menu
	 * item this is done via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void addItemToSet(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the ID of the menu item you want to add to set\n");
		int itemID = sc.nextInt();
		menuLogic.addItemToSet(SetId, itemID);
	}

	/**
	 * will remove a menu item from a promotional set using set ID as the identifier
	 * for the promo set this is done via menuLogic object that is passed in
	 * 
	 * @param menuLogic the class that handles the logical parts of menu functions
	 */
	public void removeItemsFromSet(MenuLogic menuLogic) {
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the item ID to remove\n");
		int id = sc.nextInt();
		menuLogic.removeItemsFromSet(SetId, id);
	}

}