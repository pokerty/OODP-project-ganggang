package Application;
import java.util.ArrayList; 
import java.util.Scanner;
import java.io.File;

import Application.MenuItems.courseType;

public class MenuLogic { 
	// implements AddMenutoOrder 

	private ArrayList<MenuItems> mains; //array is plural, enum is singular
	private ArrayList<MenuItems> drinks;
	private ArrayList<MenuItems> desserts;
	private ArrayList<PromotionalSet> promo;

	private ArrayList<MenuItems> menuItemsList; //populate with database
	private ArrayList<MenuItems> SetItems; //to add promo items

	public MenuLogic() {
		mains = new ArrayList<MenuItems>(); 
		drinks = new ArrayList<MenuItems>();
		desserts = new ArrayList<MenuItems>();
		promo = new ArrayList<PromotionalSet>();
		menuItemsList = new ArrayList<MenuItems>();

		//READ MENU TXT, all print lines can be commented out
		Scanner sc = new Scanner(new File("Menu.txt"));
		while(sc.hasNext()){
			System.out.print("Enter the item ID\n");
			int id = sc.nextInt();
			System.out.print("Enter the item name\n");
			String name = sc.next();
			System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n"); 
			int categorynum = sc.nextInt(); //category has to be in numbers
			courseType category = courseType.main; //default coursetype
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
			String description = sc.next();
			System.out.print("Enter the item price\n");
			float price = sc.nextFloat();
			menuItemsList.add(new MenuItems(id, name, category, description, price));
		}
		for (int i=0; i<menuItemsList.size();i++){
			switch (menuItemsList.get(i).getCategory()){
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

		//READ PROMO TXT, all print lines can be commented out
		Scanner sc2 = new Scanner(new File("Promo.txt"));
		SetItems = new ArrayList<MenuItems>();
		while(sc2.hasNext()){
			//for each set get the bundle details
			System.out.print("Enter the item ID\n");
			int SetId = sc2.nextInt();
			System.out.print("Enter the item name\n");
			String SetName = sc.next();
			System.out.print("Enter the item description\n");
			String SetDescription = sc.next();
			System.out.print("Enter the item price\n");
			float SetPrice = sc.nextFloat();
			//then add the menu items inside
			do{
				System.out.print("Enter the item ID\n");
				int id = sc.nextInt();
				System.out.print("Enter the item name\n");
				String name = sc.next();
				System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n"); 
				int categorynum = sc.nextInt(); //category has to be in numbers
				courseType category = courseType.main; //default coursetype
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
				String description = sc.next();
				System.out.print("Enter the item price\n");
				float price = sc.nextFloat();
				SetItems.add(new MenuItems(id, name, category, description, price));
			}while(sc.nextInt()!=-1); //to end the taking in of menuitems write -1

			promo.add(new PromotionalSet(SetId, SetName, SetDescription, SetPrice, SetItems));
			SetItems.clear(); //clear list
			
		}
	}

// MENU FUNCTIONS
	public void displayMenu(courseType category) {
		switch (category){
			case main:
				System.out.print("Mains:\n");
				for (int i=0; i<mains.size(); i++){
					System.out.print(mains.get(i));
				}
				break;
			case drink:
				System.out.print("Drinks:\n");
				for (int i=0; i<drinks.size(); i++){
					System.out.print(drinks.get(i));
				}
				break;
			case dessert:
				System.out.print("Desserts:\n");
				for (int i=0; i<desserts.size(); i++){
					System.out.print(desserts.get(i));
				}
				break;
		}
	}

	public void createMenuItems(int id, String name, courseType category, String description, float price) {
		switch (category){
			case main:
				mains.add(new MenuItems(id, name, category, description, price));
				break;
			case drink:
				drinks.add(new MenuItems(id, name, category, description, price));
				break;
			case dessert:
				desserts.add(new MenuItems(id, name, category, description, price));
				break;
		}
	}

	public void removeMenuItems(int id, courseType category) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.remove(i);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.remove(i);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.remove(i);
					}
				}
				break;
		}
	}

	public void updateMenuItemID(int id, courseType category, int newid) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setID(newid);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setID(newid);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setID(newid);
					}
				}
				break;
		}
	}
	public void updateMenuItemName(int id, courseType category, String newname) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setName(newname);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setName(newname);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setName(newname);
					}
				}
				break;
		}
	}

	public void updateMenuItemDescription(int id, courseType category, String newdescription) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setDescription(newdescription);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setDescription(newdescription);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setDescription(newdescription);
					}
				}
				break;
		}
	}

	public void updateMenuItemPrice(int id, courseType category, float newprice) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setPrice(newprice);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setPrice(newprice);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setPrice(newprice);
					}
				}
				break;
		}
	}
	public MenuItems addItemsToOrder(int id, courseType category) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						return mains.get(i);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						return drinks.get(i);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						return desserts.get(i);
					}
				}
				break;
		}
		return null;
	}

//PROMO FUNCTIONS	
	public void displayPromoMenu(){
		System.out.print("Promotional Sets:\n");
		for (int i=0; i<promo.size(); i++){
			System.out.print(promo.get(i));
		}
	}

	public void displayPromoItems(int SetId){
		System.out.print("Items in this set:\n");
		SetItems = new ArrayList<MenuItems>();
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				SetItems = promo.get(i).getMenuItems();
				for(int j=0; j<SetItems.size(); j++){
					System.out.print(SetItems.get(j));
				}
			}
		}
	}
	public void createPromoSet(int SetId, String SetName, String SetDescription, float SetPrice, ArrayList<MenuItems> SetItems){
		promo.add(new PromotionalSet(SetId, SetName, SetDescription, SetPrice, SetItems));
	}

	public void removePromoSet(int SetId){
	for (int i=0; i<promo.size(); i++){
		if (promo.get(i).getID()==SetId){
			promo.remove(i);
		}}
	}

	public void updateSetID(int SetId, int newid){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setID(newid);
			}
		}
	}

	public void updateSetName(int SetId, String newname){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setName(newname);
			}
		}
	}

	public void updateSetDescription(int SetId, String newdescription){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setDescription(newdescription);
			}
		}
	}

	public void updateSetPrice(int SetId, float newprice){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setPrice(newprice);
			}
		}
	}

	public void addItemToSet(int SetId, MenuItems newitem){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).addItemsToSet(newitem);
			}
		}
	}

	public void removeItemsFromSet(int SetId, int id){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).removeItemsFromSet(id);
			}
		}
	}

	public PromotionalSet addPromoToOrder(int SetId){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				return promo.get(i);
			}}
		return null;
	}



}