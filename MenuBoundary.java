package oodpassignment;

import java.util.*;


public class MenuBoundary {
	Scanner sc = new Scanner(System.in);

	
	/** 
	 * takes in input for displaymenu
	 * @param menuLogic
	 */
	public void displayMenu(MenuLogic menuLogic) {
		System.out.print("Enter the menu to display\nmain:1\ndessert:2\ndrink:3\n");
		int categorynum = sc.nextInt();
		
		menuLogic.displayMenu(categorynum); 
	}

	
	/** 
	 * takes in inputs for createmenuitems
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
	 * takes in inputs for removemenuitem
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
	 * takes in inputs for updatemenuitemid
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
	 * takes in inputs for updatemenuitemname
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
	 * takes in inputs for updatemenuitemdescription
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
	 * takes in inputs for updatemenuitemprice
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
	 * displays promotional set menu
	 * @param menuLogic
	 */
	public void displayPromoMenu(MenuLogic menuLogic){
		System.out.print("Promo Menu:\n");
		menuLogic.displayPromoMenu();
		
	}



	 
	 /** 
	  * takes in inputs for createpromoset
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
	 * takes in inputs for removepromoset
	 * @param menuLogic
	 */
	public void removePromoSet(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID to remove\n");
		int SetId = sc.nextInt();
		menuLogic.removePromoSet(SetId);
	}

	
	/** 
	 * takes in inputs for updatesetid
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
	 * takes in inputs for updatesetname
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
	 * takes in inputs for updatesetdescription
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
	 * takes in inputs for updatesetprice
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
	  * takes in inputs for additemtoset
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
	 * takes in inputs for removeitemfromset
	 * @param menuLogic
	 */
	public void removeItemFromSet(MenuLogic menuLogic){
		System.out.print("Enter the Promotional Set ID\n");
		int SetId = sc.nextInt();
		System.out.print("Enter the item ID to remove\n");
		int id = sc.nextInt();
		menuLogic.removeItemFromSet(SetId, id);
	}

}