package oodpassignment;

import java.util.*;


public class MenuBoundary {
	Scanner sc = new Scanner(System.in);

	
	/** 
	 * @param menuLogic
	 */
	public void displayMenu(MenuLogic menuLogic) {
		System.out.print("Enter the menu to display\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		
		menuLogic.displayMenu(categorynum); 
	}

	
	/** 
	 * @param menuLogic
	 */
	public void createMenuItems(MenuLogic menuLogic) {

		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item name\n");
		String name = sc.nextLine();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the item description\n");
		String description = sc.next();
		System.out.print("Enter the item price\n");
		float price = sc.nextFloat();
		
		menuLogic.createMenuItems(id, name, categorynum, description, price);
	}

	
	/** 
	 * @param menuLogic
	 */
	public void removeMenuItems(MenuLogic menuLogic) {

		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		menuLogic.removeMenuItems(id, categorynum);
		
		}
	

	
	/** 
	 * @param menuLogic
	 */
	public void updateMenuItemID(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the new item ID\n");
		int newid = sc.nextInt();
		menuLogic.updateMenuItemID(id, categorynum, newid);

	}
	
	/** 
	 * @param menuLogic
	 */
	public void updateMenuItemName(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the new item name\n");
		String newname = sc.nextLine();
		menuLogic.updateMenuItemName(id, categorynum, newname);

	}

	
	/** 
	 * @param menuLogic
	 */
	public void updateMenuItemDescription(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the new item description\n");
		String newdescription = sc.nextLine();
		menuLogic.updateMenuItemDescription(id, categorynum, newdescription);

	}

	
	/** 
	 * @param menuLogic
	 */
	public void updateMenuItemPrice(MenuLogic menuLogic) {
		System.out.print("Enter the item ID\n");
		int id = sc.nextInt();
		System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		System.out.print("Enter the new item price\n");
		float newprice = sc.nextFloat();
		menuLogic.updateMenuItemPrice(id, categorynum, newprice);

	}
	
	/** 
	 * @param menuLogic
	 */
	public void displayPromoMenu(MenuLogic menuLogic){
		System.out.print("Promo Menu:\n");
		menuLogic.displayPromoMenu();
		
	}



	 
	 /** 
	  * @param menuLogic
	  */
	 public void createPromoSet(MenuLogic menuLogic){
	 	System.out.print("Enter the Promotional Set ID\n");
	 	int SetId = sc.nextInt();
	 	System.out.print("Enter the Promotional Set name\n");
	 	String SetName = sc.nextLine();
		System.out.print("Enter the Promotional Set description\n");
	 	String SetDescription = sc.next();
	 	System.out.print("Enter the Promotional Set price\n");
	 	float SetPrice = sc.nextFloat();
	 	System.out.print("Enter the ID of the menu items you want to add to set\n");
	 	int itemID = sc.nextInt();
	 	ArrayList<Integer> listOfIDs = new ArrayList<Integer>(); 
	 	while(itemID!=-1) {
	 		listOfIDs.add(itemID); 
		 	System.out.print("Enter the ID of the menu items you want to add to set, -1 to terminate\n");
		 	itemID = sc.nextInt();
	 	}
	 	menuLogic.createPromoSet(SetId, SetName, SetDescription, SetPrice, listOfIDs);
	 	
	 }

	
	/** 
	 * @param menuLogic
	 */
	public void removePromoSet(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID to remove\n");
		int SetId = sc.nextInt();
		menuLogic.removePromoSet(SetId);
	}

	
	/** 
	 * @param menuLogic
	 */
	public void updateSetID(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the new Set ID\n");
		int newid = sc.nextInt();
		menuLogic.updateSetID(SetId, newid);
	}

	
	/** 
	 * @param menuLogic
	 */
	public void updateSetName(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the new Set name\n");
		String newname = sc.nextLine();
		menuLogic.updateSetName(SetId, newname);
	}

	
	/** 
	 * @param menuLogic
	 */
	public void updateSetDescription(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the new Set description\n");
		String newdescription = sc.nextLine();
		menuLogic.updateSetDescription(SetId, newdescription);
	}

	
	/** 
	 * @param menuLogic
	 */
	public void updateSetPrice(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the new Set price\n");
		float newprice = sc.nextFloat();
		menuLogic.updateSetPrice(SetId, newprice);
	}

	 
	 /** 
	  * @param menuLogic
	  */
	 public void addItemToSet(MenuLogic menuLogic){
	 	System.out.print("Enter the Promotional Set ID\n");
	 	int SetId = sc.nextInt();
	 	System.out.print("Enter the ID of the menu items you want to add to set\n");
	 	int itemID = sc.nextInt();
	 	menuLogic.addItemToSet(SetId, itemID);
	 }

	
	/** 
	 * @param menuLogic
	 */
	public void removeItemsFromSet(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the item ID to remove\n");
		int id = sc.nextInt();
		menuLogic.removeItemsFromSet(SetId, id);
	}

}