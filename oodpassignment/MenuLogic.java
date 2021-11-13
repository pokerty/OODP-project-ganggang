package oodpassignment;

import java.util.ArrayList;
import java.util.Scanner;

import oodpassignment.MenuItems;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * MenuLogic is responsible for all logics regarding functions regarding
 * menuitems and promotional items such as displaying, modifying menu and
 * promotional set items
 * 
 * @author hong po chang wei
 * @version 1.0
 * @since 07/11/2021
 *
 *
 */
public class MenuLogic {
	// implements AddMenutoOrder
	/**
	 * the collection of menu items of the mains enum type
	 */
	private ArrayList<MenuItems> mains; // array is plural, enum is singular
	/**
	 * the collection of menu items of the drinks enum type
	 */
	private ArrayList<MenuItems> drinks;
	/**
	 * the collection of menu items of the desserts enum type
	 */
	private ArrayList<MenuItems> desserts;
	/**
	 * the collection of promotional set of menu items
	 */
	private ArrayList<PromotionalSet> promo;

	/**
	 * constructor of MenuLogic object, 2 txt files, menu.txt and promo.txt will be
	 * scanned and their contents will populate the mains, drinks and dessert
	 * collections of the MenuLogic object
	 */
	public MenuLogic() {
		mains = new ArrayList<MenuItems>();
		drinks = new ArrayList<MenuItems>();
		desserts = new ArrayList<MenuItems>();
		promo = new ArrayList<PromotionalSet>();

		try {
			// READ MENU TXT, all print lines can be commented out
			ArrayList<MenuItems> menuItemsList = new ArrayList<MenuItems>();
			Scanner sc = new Scanner(new File("Menu.txt"));
			while (sc.hasNext()) {
				// System.out.print("Enter the item ID\n");
				int id = sc.nextInt();
				sc.nextLine();
				// System.out.print("Enter the item name\n");
				String name = sc.nextLine();
				// System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
				int categorynum = sc.nextInt(); // category has to be in numbers
				sc.nextLine();
				// System.out.print("Enter the item description\n");
				String description = sc.nextLine();
				// System.out.print("Enter the item price\n");
				float price = sc.nextFloat();
				menuItemsList.add(new MenuItems(id, name, categorynum, description, price));
			}
			for (int i = 0; i < menuItemsList.size(); i++) {
				switch (menuItemsList.get(i).getCategory()) {
				case main:
					mains.add(menuItemsList.get(i));
					break;
				case drink:
					drinks.add(menuItemsList.get(i));
					break;
				case dessert:
					desserts.add(menuItemsList.get(i));
					break;
				}
			}

			// READ PROMO TXT, all print lines can be commented out
			Scanner sc2 = new Scanner(new File("Promo.txt"));
			while (sc2.hasNext()) {
				ArrayList<MenuItems> SetItems = new ArrayList<MenuItems>();
				// for each set get the bundle details
				// System.out.print("Enter the item ID\n");
				int SetId = sc2.nextInt();
				sc2.nextLine();
				// System.out.print("Enter the item name\n");
				String SetName = sc2.nextLine();
				// System.out.print("Enter the item description\n");
				String SetDescription = sc2.nextLine();
				// System.out.print("Enter the item price\n");
				float SetPrice = sc2.nextFloat();
				sc2.nextLine();
				// then add the menu items inside
				do {
					// System.out.print("Enter the item ID\n");
					int id = sc2.nextInt();
					sc2.nextLine();
					// System.out.print("Enter the item name\n");
					String name = sc2.nextLine();
					// System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n");
					int categorynum = sc2.nextInt(); // category has to be in numbers
					sc2.nextLine();
					// System.out.print("Enter the item description\n");
					String description = sc2.nextLine();
					// System.out.print("Enter the item price\n");
					float price = sc2.nextFloat();
					sc2.nextLine();
					SetItems.add(new MenuItems(id, name, categorynum, description, price));
				} while (sc2.nextInt() != -1); // to end the taking in of menuitems write -1

				promo.add(new PromotionalSet(SetId, SetName, SetDescription, SetPrice, SetItems));

			}

		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

	// MENU FUNCTIONS
	/**
	 * Displays the menu to the user depending on the user's selection
	 * 
	 * @param choice which is input from MenuBoundary class
	 */
	public void displayMenu(int choice) {
		switch (choice) {
		case 1:
			System.out.print("Mains:\n");
			for (int i = 0; i < mains.size(); i++) {
				System.out.println(mains.get(i).getName() + ", ID: " + mains.get(i).getID() + ", Price: "
						+ mains.get(i).getPrice());
			}
			break;
		case 3:
			System.out.print("Drinks:\n");
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getName() + ", ID: " + drinks.get(i).getID() + ", Price: "
						+ drinks.get(i).getPrice());
			}
			break;
		case 2:
			System.out.print("Desserts:\n");
			for (int i = 0; i < desserts.size(); i++) {
				System.out.println(desserts.get(i).getName() + ", ID: " + desserts.get(i).getID() + ", Price: "
						+ desserts.get(i).getPrice());
			}
			break;
		}
	}

	/**
	 * creates a new menu item according to the specifications of the user
	 * 
	 * @param id          ID of new menu item
	 * @param name        name of new menu item
	 * @param choice      the type of menu item - 1 for main, 2 for dessert, 3 for
	 *                    drinks
	 * @param description description of the new menu item
	 * @param price       prie of the new menu item
	 */
	public void createMenuItems(int id, String name, int choice, String description, float price) {
		switch (choice) {
		case 1:
			mains.add(new MenuItems(id, name, choice, description, price));
			break;
		case 3:
			drinks.add(new MenuItems(id, name, choice, description, price));
			break;
		case 2:
			desserts.add(new MenuItems(id, name, choice, description, price));
			break;
		}
	}

	/**
	 * removes a pre-existing menu item from the current collection of menu items
	 * according to the choice of the user
	 * 
	 * @param id     id of the menu item you want to remove
	 * @param choice what kind of menu item you want to remove
	 */
	public void removeMenuItems(int id, int choice) {
		switch (choice) {
		case 1:
			for (int i = 0; i < mains.size(); i++) {
				if (mains.get(i).getID() == id) {
					mains.remove(i);
				}
			}
			break;
		case 3:
			for (int i = 0; i < drinks.size(); i++) {
				if (drinks.get(i).getID() == id) {
					drinks.remove(i);
				}
			}
			break;
		case 2:
			for (int i = 0; i < desserts.size(); i++) {
				if (desserts.get(i).getID() == id) {
					desserts.remove(i);
				}
			}
			break;
		}
	}

	/**
	 * updateMenuItemID will update the ID of a chosen menu item with its old ID
	 * 
	 * @param id     OLD ID of menu item you want to update
	 * @param choice what type of menu item it is - 1 for main, 2 for dessert, 3 for
	 *               drinks
	 * @param newid  NEW ID of menu item you wish to set
	 */
	public void updateMenuItemID(int id, int choice, int newid) {
		switch (choice) {
		case 1:
			for (int i = 0; i < mains.size(); i++) {
				if (mains.get(i).getID() == id) {
					mains.get(i).setID(newid);
				}
			}
			break;
		case 3:
			for (int i = 0; i < drinks.size(); i++) {
				if (drinks.get(i).getID() == id) {
					drinks.get(i).setID(newid);
				}
			}
			break;
		case 2:
			for (int i = 0; i < desserts.size(); i++) {
				if (desserts.get(i).getID() == id) {
					desserts.get(i).setID(newid);
				}
			}
			break;
		}
	}

	/**
	 * updateMenuItemName will update the menu item's name to a new name using its
	 * ID as identifier
	 * 
	 * @param id       ID of menu item whose name you want to change
	 * @param category - 1 for main, 2 for dessert, 3 for drinks
	 * @param newname  the new name for the menu item
	 */
	public void updateMenuItemName(int id, int category, String newname) {
		switch (category) {
		case 1:
			for (int i = 0; i < mains.size(); i++) {
				if (mains.get(i).getID() == id) {
					mains.get(i).setName(newname);
				}
			}
			break;
		case 3:
			for (int i = 0; i < drinks.size(); i++) {
				if (drinks.get(i).getID() == id) {
					drinks.get(i).setName(newname);
				}
			}
			break;
		case 2:
			for (int i = 0; i < desserts.size(); i++) {
				if (desserts.get(i).getID() == id) {
					desserts.get(i).setName(newname);
				}
			}
			break;
		}
	}

	/**
	 * updateMenuItemDescription will update the menu item's description to a new
	 * description using its ID as identifier
	 * 
	 * @param id             the ID of the item whose description you want to change
	 * @param category       - 1 for main, 2 for dessert, 3 for drinks
	 * @param newdescription the new description
	 */
	public void updateMenuItemDescription(int id, int category, String newdescription) {
		switch (category) {
		case 1:
			for (int i = 0; i < mains.size(); i++) {
				if (mains.get(i).getID() == id) {
					mains.get(i).setDescription(newdescription);
				}
			}
			break;
		case 3:
			for (int i = 0; i < drinks.size(); i++) {
				if (drinks.get(i).getID() == id) {
					drinks.get(i).setDescription(newdescription);
				}
			}
			break;
		case 2:
			for (int i = 0; i < desserts.size(); i++) {
				if (desserts.get(i).getID() == id) {
					desserts.get(i).setDescription(newdescription);
				}
			}
		}

	}

	/**
	 * updateMenuItemPrice will update the menu item's price to a new price using
	 * its ID as identifier
	 * 
	 * @param id       the id of the menu item whose price you want to change
	 * @param category - 1 for main, 2 for dessert, 3 for drinks
	 * @param newprice the new price of the item
	 */
	public void updateMenuItemPrice(int id, int category, float newprice) {
		switch (category) {
		case 1:
			for (int i = 0; i < mains.size(); i++) {
				if (mains.get(i).getID() == id) {
					mains.get(i).setPrice(newprice);
				}
			}
			break;
		case 3:
			for (int i = 0; i < drinks.size(); i++) {
				if (drinks.get(i).getID() == id) {
					drinks.get(i).setPrice(newprice);
				}
			}
			break;
		case 2:
			for (int i = 0; i < desserts.size(); i++) {
				if (desserts.get(i).getID() == id) {
					desserts.get(i).setPrice(newprice);
				}
			}
			break;
		}
	}

	/**
	 * used to add a menu item to an existing order
	 * 
	 * @param id       the item's id you wish to add to an existing order
	 * @param category - 1 for main, 2 for dessert, 3 for drinks, the type of item
	 *                 you wish to add
	 * @return a menu item object chosen by the user based on ID and category
	 */
	public MenuItems addItemsToOrder(int id, int category) {
		switch (category) {
		case 1:
			for (int i = 0; i < mains.size(); i++) {
				if (mains.get(i).getID() == id) {
					return mains.get(i);
				}
			}
			break;
		case 3:
			for (int i = 0; i < drinks.size(); i++) {
				if (drinks.get(i).getID() == id) {
					return drinks.get(i);
				}
			}
			break;
		case 2:
			for (int i = 0; i < desserts.size(); i++) {
				if (desserts.get(i).getID() == id) {
					return desserts.get(i);
				}
			}
			break;
		}
		return null;
	}

	// PROMO FUNCTIONS
	/**
	 * to display promotional set items on the console to the user
	 */
	public void displayPromoMenu() {
		for (int i = 0; i < promo.size(); i++) {
			System.out.println("\nName: " + promo.get(i).getName());
			System.out.println("ID is: " + promo.get(i).getID());
			System.out.println("Description: " + promo.get(i).getDescription());
			System.out.println("Price: $" + promo.get(i).getPrice() + "\n");
			System.out.println("Items in this set:");

			for (int k = 0; k < promo.get(i).getMenuItems().size(); k++) {
				System.out.print(promo.get(i).getMenuItems().get(k).getName() + ",");
				System.out.print(" ID is: " + promo.get(i).getMenuItems().get(k).getID());
				System.out.println("\nDescription: " + promo.get(i).getMenuItems().get(k).getDescription());
				// System.out.println(promo.get(i).getMenuItems().get(k).getPrice());
			}

		}
	}

	/**
	 * creates a new promotional set consisting of menu items from the ala carte
	 * menu
	 * 
	 * @param setId          ID of new promo set
	 * @param setName        Name of new promo set
	 * @param setDescription description of new promo set
	 * @param setPrice       price of new promo set
	 * @param listOfIDs      the list of IDs of the menu items that will form the
	 *                       new promotional set
	 */
	public void createPromoSet(int SetId, String SetName, String SetDescription, float SetPrice,
			ArrayList<Integer> listOfIDs) {
		ArrayList<MenuItems> listOfItems = new ArrayList<MenuItems>();
		int i, j;
		for (i = 0; i < listOfIDs.size(); i++) {
			for (j = 0; j < mains.size(); j++) {
				if (listOfIDs.get(i) == mains.get(j).getID()) {
					listOfItems.add(mains.get(j));
				}
			}
			for (j = 0; j < desserts.size(); j++) {
				if (listOfIDs.get(i) == desserts.get(j).getID()) {
					listOfItems.add(desserts.get(j));
				}
			}
			for (j = 0; j < drinks.size(); j++) {
				if (listOfIDs.get(i) == drinks.get(j).getID()) {
					listOfItems.add(drinks.get(j));
				}
			}
		}
		promo.add(new PromotionalSet(SetId, SetName, SetDescription, SetPrice, listOfItems));
	}

	/**
	 * removes an existing promotional set via its ID
	 * 
	 * @param setId the ID of the promo set you wish to remove
	 */
	public void removePromoSet(int SetId) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.remove(i);
			}
		}
	}

	/**
	 * updates a promotional set's old ID to a new ID
	 * 
	 * @param setId the ID of the promo set you wish to change
	 * @param newid the NEW ID of the promo set
	 */
	public void updateSetID(int SetId, int newid) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.get(i).setID(newid);
			}
		}
	}

	/**
	 * updates a promotional set's name to a new name via its ID
	 * 
	 * @param setId   the ID of the promo set whose name you want to change
	 * @param newname the new name you wish to set for the promo set
	 */
	public void updateSetName(int SetId, String newname) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.get(i).setName(newname);
			}
		}
	}

	/**
	 * updates a promotional set's description to a new description via its ID
	 * 
	 * @param setId          the set ID of the promo set
	 * @param newdescription the new description you want the promo set to have
	 */
	public void updateSetDescription(int SetId, String newdescription) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.get(i).setDescription(newdescription);
			}
		}
	}

	/**
	 * updates a promotional set's price to a new price via its ID
	 * 
	 * @param setId    the promo set's ID
	 * @param newprice the new price of the promo set
	 */
	public void updateSetPrice(int SetId, float newprice) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.get(i).setPrice(newprice);
			}
		}
	}

	/**
	 * adds an additional menu item to an existing promotional set by using the ID
	 * of the chosen menu item
	 * 
	 * @param setId  the promo set's ID
	 * @param itemID the ID of the item that you want to add
	 */
	public void addItemToSet(int SetId, int itemID) {
		int j;
		int found = 0;
		MenuItems item = null;
		for (j = 0; j < mains.size(); j++) {
			if (itemID == mains.get(j).getID()) {
				item = mains.get(j);
				found = 1;
				break;
			}
		}

		if (found != 1) {
			for (j = 0; j < desserts.size(); j++) {
				if (itemID == desserts.get(j).getID()) {
					item = desserts.get(j);
					break;
				}
			}
			for (j = 0; j < drinks.size(); j++) {
				if (itemID == drinks.get(j).getID()) {
					item = drinks.get(j);
					break;
				}
			}
		}

		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.get(i).addItemsToSet(item);
			}
		}
	}

	/**
	 * removes a specific menu item from a promotional set using the menu item's ID
	 * 
	 * @param setId the ID of the promo set
	 * @param id    the ID of the menu item you want to remove from the set
	 */
	public void removeItemsFromSet(int SetId, int id) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				promo.get(i).removeItemsFromSet(id);
			}
		}
	}

	/**
	 * adds a promotional set to an existing order
	 * 
	 * @param setId the promo set's ID
	 * @return the promotional set object that was chosen via its ID
	 */
	public PromotionalSet addPromoToOrder(int SetId) {
		for (int i = 0; i < promo.size(); i++) {
			if (promo.get(i).getID() == SetId) {
				return promo.get(i);
			}
		}
		return null;
	}

}