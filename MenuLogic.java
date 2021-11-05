package oodpassignment;

import java.util.ArrayList; 
import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;


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

		try {
			//READ MENU TXT, all print lines can be commented out
			Scanner sc = new Scanner(new File("Menu.txt"));
			while(sc.hasNext()){
				//System.out.print("Enter the item ID\n");
				int id = sc.nextInt();
				sc.nextLine();
				//System.out.print("Enter the item name\n");
				String name = sc.nextLine();
				//System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n"); 
				int categorynum = sc.nextInt(); //category has to be in numbers
				sc.nextLine();
				//System.out.print("Enter the item description\n");
				String description = sc.nextLine();
				//System.out.print("Enter the item price\n");
				float price = sc.nextFloat();
				sc.nextLine();
				menuItemsList.add(new MenuItems(id, name, categorynum, description, price));
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
			ArrayList<MenuItems>SetItems = new ArrayList<MenuItems>();
			while(sc2.hasNext()){
				//for each set get the bundle details
				//System.out.print("Enter the item ID\n");
				int SetId = sc2.nextInt();
				sc2.nextLine();
				//System.out.print("Enter the item name\n");
				String SetName = sc2.nextLine();
				//System.out.print("Enter the item description\n");
				String SetDescription = sc2.nextLine();
				//System.out.print("Enter the item price\n");
				float SetPrice = sc2.nextFloat();
				sc2.nextLine();
				//then add the menu items inside
				do{
					//System.out.print("Enter the item ID\n");
					int id = sc2.nextInt();
					sc2.nextLine();
					//System.out.print("Enter the item name\n");
					String name = sc2.nextLine();
					//System.out.print("Enter the item category\nmain:1\ndessert:2\ndrink:3\n"); 
					int categorynum = sc2.nextInt(); //category has to be in numbers
					sc2.nextLine();
					//System.out.print("Enter the item description\n");
					String description = sc2.nextLine();
					//System.out.print("Enter the item price\n");
					float price = sc2.nextFloat();
					sc2.nextLine();
					SetItems.add(new MenuItems(id, name, categorynum, description, price));
				}while(sc2.nextInt()!=-1); //to end the taking in of menuitems write -1

				promo.add(new PromotionalSet(SetId, SetName, SetDescription, SetPrice, SetItems));
				SetItems.clear(); //clear list
				
			}
			
			
		}
		catch(FileNotFoundException e){
			e.getMessage(); 
			e.printStackTrace();
		}
			
			
		
	}

// MENU FUNCTIONS
	public void displayMenu(int choice) {
		switch (choice){
			case 1:
				System.out.print("Mains:\n");
				for (int i=0; i<mains.size(); i++){
					System.out.println(mains.get(i).getName());
				}
				break;
			case 3:
				System.out.print("Drinks:\n");
				for (int i=0; i<drinks.size(); i++){
					System.out.println(drinks.get(i).getName());
				}
				break;
			case 2:
				System.out.print("Desserts:\n");
				for (int i=0; i<desserts.size(); i++){
					System.out.println(desserts.get(i).getName());
				}
				break;
		}
	}

	public void createMenuItems(int id, String name, int choice, String description, float price) {
		switch (choice){
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

	public void removeMenuItems(int id, int choice) {
		switch (choice){
			case 1:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.remove(i);
					}
				}
				break;
			case 3:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.remove(i);
					}
				}
				break;
			case 2:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.remove(i);
					}
				}
				break;
		}
	}

	public void updateMenuItemID(int id, int choice, int newid) {
		switch (choice){
			case 1:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setID(newid);
					}
				}
				break;
			case 3:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setID(newid);
					}
				}
				break;
			case 2:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setID(newid);
					}
				}
				break;
		}
	}
	public void updateMenuItemName(int id, int category, String newname) {
		switch (category){
			case 1:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setName(newname);
					}
				}
				break;
			case 3:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setName(newname);
					}
				}
				break;
			case 2:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setName(newname);
					}
				}
				break;
		}
	}

	public void updateMenuItemDescription(int id, int category, String newdescription) {
		switch (category){
			case 1:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setDescription(newdescription);
					}
				}
				break;
			case 3:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setDescription(newdescription);
					}
				}
				break;
			case 2:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setDescription(newdescription);
					}
				}
		}
		
	}

	public void updateMenuItemPrice(int id, int category, float newprice) {
		switch (category){
			case 1:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						mains.get(i).setPrice(newprice);
					}
				}
				break;
			case 3:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						drinks.get(i).setPrice(newprice);
					}
				}
				break;
			case 2:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getID()==id){
						desserts.get(i).setPrice(newprice);
					}
				}
				break;
		}
	}
	public MenuItems addItemsToOrder(int id, int category) {
		switch (category){
			case 1:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getID()==id){
						return mains.get(i);
					}
				}
				break;
			case 3:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getID()==id){
						return drinks.get(i);
					}
				}
				break;
			case 2:
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
			System.out.println(promo.get(i).getName());
			System.out.println(promo.get(i).getID()); 
			System.out.println(promo.get(i).getDescription()); 
			System.out.println(promo.get(i).getPrice()); 
			System.out.println("Items in this set:\n");
			ArrayList<MenuItems> SetItems = new ArrayList<MenuItems>();
			
			SetItems = promo.get(i).getMenuItems();
			for(int k=0; k<SetItems.size(); k++){
				System.out.println(SetItems.get(k).getName());
				System.out.println(SetItems.get(k).getID());
				System.out.println(SetItems.get(k).getDescription());
				System.out.println(SetItems.get(k).getPrice());
			}	
		
			
	}
}

	
	public void createPromoSet(int SetId, String SetName, String SetDescription, float SetPrice, ArrayList<Integer>listOfIDs){
		ArrayList<MenuItems> listOfItems = new ArrayList<MenuItems>(); 
		int i,j; 
		for(i =0;i<listOfIDs.size();i++) {
			for(j=0; j<mains.size();j++) {
				if(listOfIDs.get(i)==mains.get(j).getID()) {
					listOfItems.add(mains.get(j));
				}
			}
			for(j=0; j<desserts.size();j++) {
				if(listOfIDs.get(i)==desserts.get(j).getID()) {
					listOfItems.add(desserts.get(j));
				}
			}
			for(j=0; j<drinks.size();j++) {
				if(listOfIDs.get(i)==drinks.get(j).getID()) {
					listOfItems.add(drinks.get(j));
				}
			}
		}
		promo.add(new PromotionalSet(SetId, SetName, SetDescription, SetPrice,listOfItems)); 
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

	public void addItemToSet(int SetId, int itemID){
		int j; 
		int found=0; 
		MenuItems item = null;
		for(j=0; j<mains.size();j++) {
			if(itemID==mains.get(j).getID()) {
				item = mains.get(j); 
				found =1; 
				break; 
			}
		}
		
		if(found!=1) {
			for(j=0; j<desserts.size();j++) {
				if(itemID==desserts.get(j).getID()) {
					item = desserts.get(j); 
					break; 
				}
			}
			for(j=0; j<drinks.size();j++) {
				if(itemID==drinks.get(j).getID()) {
					item = drinks.get(j); 
					break;
				}
			}
		}
	
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).addItemsToSet(item);
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