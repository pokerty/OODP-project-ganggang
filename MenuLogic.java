package oodpassignment;

import java.util.ArrayList; 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import oodpassignment.MenuItems.courseType;

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
			//READ MENU TXT
			Scanner sc = new Scanner(new File("Menu.txt"));
			while(sc.hasNext()){
				int id = sc.nextInt();
				String name = sc.next();
				int categorynum = sc.nextInt(); //category has to be in numbers
				String description = sc.next();
				float price = sc.nextFloat();
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

			//READ PROMO TXT
			Scanner sc2 = new Scanner(new File("Promo.txt"));
			SetItems = new ArrayList<MenuItems>();
			while(sc2.hasNext()){
				//for each set get the bundle details
				int SetId = sc2.nextInt();
				String SetName = sc2.next();
				String SetDescription = sc2.next();
				float SetPrice = sc2.nextFloat();
				//then add the menu items inside
				do{
					int id = sc2.nextInt();
					String name = sc2.next();
					int categorynum = sc2.nextInt(); //category has to be in numbers
					String description = sc2.next();
					float price = sc2.nextFloat();
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
	/** 
	 * to print out menu for a category
	 * @param choice
	 */
	public void displayMenu(int choice) {
		switch (choice){
			case 1:
				System.out.print("Mains:\n");
				for (int i=0; i<mains.size(); i++){
					System.out.println(mains.get(i));
				}
				break;
			case 3:
				System.out.print("Drinks:\n");
				for (int i=0; i<drinks.size(); i++){
					System.out.println(drinks.get(i));
				}
				break;
			case 2:
				System.out.print("Desserts:\n");
				for (int i=0; i<desserts.size(); i++){
					System.out.println(desserts.get(i));
				}
				break;
		}
	}

	
	/** 
	 * to create an item and add it onto the menu
	 * @param id
	 * @param name
	 * @param choice
	 * @param description
	 * @param price
	 */
	public void createMenuItems(int id, String name, int choice, String description, float price) {
		switch (choice){
			case 1:
				mains.add(new MenuItems(id, name, choice, description, price));
				break;
			case 2:
				drinks.add(new MenuItems(id, name, choice, description, price));
				break;
			case 3:
				desserts.add(new MenuItems(id, name, choice, description, price));
				break;
		}
	}

	
	/** 
	 * to remove an item from the menu
	 * @param id
	 * @param choice
	 */
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

	
	/** 
	 * to change the id of a menuitem
	 * @param id
	 * @param choice
	 * @param newid
	 */
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
	
	/** 
	 * to change the name of a menuitem
	 * @param id
	 * @param category
	 * @param newname
	 */
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

	
	/** 
	 * to change the description of a menuitem
	 * @param id
	 * @param category
	 * @param newdescription
	 */
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

	
	/** 
	 * to change the price of a menuitem
	 * @param id
	 * @param category
	 * @param newprice
	 */
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
	
	/** 
	 * a function for searching for an item from the menu and returning it as a menuitem, for adding to orders
	 * @param id
	 * @param category
	 * @return MenuItems
	 */
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
	//to print out the menu for promotional sets
	public void displayPromoMenu(){
		System.out.print("Promotional Sets:\n");
		for (int i=0; i<promo.size(); i++){
			System.out.println(promo.get(i).getName());
			System.out.println(promo.get(i).getID()); 
			System.out.println(promo.get(i).getDescription()); 
			System.out.println(promo.get(i).getPrice()); 
			System.out.println("Items in this set:\n");
			SetItems = new ArrayList<MenuItems>();
			for (int j=0; j<promo.size(); j++){
				SetItems = promo.get(i).getMenuItems();
				for(int k=0; k<SetItems.size(); k++){
					System.out.println(SetItems.get(k).getName());
					System.out.println(SetItems.get(k).getID());
					System.out.println(SetItems.get(k).getDescription());
					System.out.println(SetItems.get(k).getPrice());
				}	
		}
			
	}
}

	
	
	/** 
	 * to create a promotional set and add it to the menu, takes in a a list of numbers for menuitem ids
	 * @param SetId
	 * @param SetName
	 * @param SetDescription
	 * @param SetPrice
	 * @param ArrayListlistOfIDs
	 */
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

	
	
	/** 
	 * to remove a promotional set from the menu
	 * @param SetId
	 */
	public void removePromoSet(int SetId){
	for (int i=0; i<promo.size(); i++){
		if (promo.get(i).getID()==SetId){
			promo.remove(i);
		}}
	}

	
	/** 
	 * to change the id of a promoset
	 * @param SetId
	 * @param newid
	 */
	public void updateSetID(int SetId, int newid){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setID(newid);
			}
		}
	}

	
	/** 
	 * to change the name of a promoset
	 * @param SetId
	 * @param newname
	 */
	public void updateSetName(int SetId, String newname){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setName(newname);
			}
		}
	}

	
	/** 
	 * to change the description of a promoset
	 * @param SetId
	 * @param newdescription
	 */
	public void updateSetDescription(int SetId, String newdescription){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setDescription(newdescription);
			}
		}
	}

	
	/** 
	 * to change the price of a promoset
	 * @param SetId
	 * @param newprice
	 */
	public void updateSetPrice(int SetId, float newprice){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).setPrice(newprice);
			}
		}
	}

	
	/** 
	 * accesses the arraylist of menuitems in a promotional set and adds an item to it
	 * @param SetId
	 * @param itemID
	 */
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
				promo.get(i).addItemToSet(item);
			}
		}
	}

	
	/** 
	 * accesses the arraylist of menuitems in a promotional set and removes an item from it
	 * @param SetId
	 * @param id
	 */
	public void removeItemFromSet(int SetId, int id){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				promo.get(i).removeItemFromSet(id);
			}
		}
	}

	
	/** 
	 * accesses the promotional set menu and searches for a set, returns it as a PromotionalSet for adding to orders
	 * @param SetId
	 * @return PromotionalSet
	 */
	public PromotionalSet addPromoToOrder(int SetId){
		for (int i=0; i<promo.size(); i++){
			if (promo.get(i).getID()==SetId){
				return promo.get(i);
			}}
		return null;
	}

	public void saveMenu() {
		try {
			FileWriter write = new FileWriter("Menu.txt"); 
			@SuppressWarnings("resource")
			BufferedWriter bwrite = new BufferedWriter(write);  //need write in order of id name category description price 
			for(int i=0;i<mains.size();i++) {
				if(mains.get(i)!=null){
					bwrite.write(Integer.toString(mains.get(i).getID())); //write id
					bwrite.newLine();
					bwrite.write(mains.get(i).getName());//write name
					bwrite.newLine();
					bwrite.write(Integer.toString(mains.get(i).getCategory())); //write category 
					bwrite.newLine();
					bwrite.write(mains.get(i).getDescription()); //write description 
					bwrite.newLine();
					bwrite.write(Float.toString(mains.get(i).getPrice())); //write price 
					bwrite.newLine();
					bwrite.newLine(); //TO SEPERATE THE DIFFERENT MENUITEMS
				}	
				for(int j=0;j<desserts.size();j++) {
					if(desserts.get(j)!=null){
						bwrite.write(Integer.toString(desserts.get(j).getID())); //write id
						bwrite.newLine();
						bwrite.write(desserts.get(j).getName());//write name
						bwrite.newLine();
						bwrite.write(Integer.toString(desserts.get(j).getCategory())); //write category 
						bwrite.newLine();
						bwrite.write(desserts.get(j).getDescription()); //write description 
						bwrite.newLine();
						bwrite.write(Float.toString(desserts.get(j).getPrice())); //write price 
						bwrite.newLine();
						bwrite.newLine(); //TO SEPERATE THE DIFFERENT MENUITEMS
					}	
					for(int k=0;k<drinks.size();k++) {
						if(drinks.get(k)!=null){
							bwrite.write(Integer.toString(drinks.get(k).getID())); //write id
							bwrite.newLine();
							bwrite.write(drinks.get(k).getName());//write name
							bwrite.newLine();
							bwrite.write(Integer.toString(drinks.get(k).getCategory())); //write category 
							bwrite.newLine();
							bwrite.write(drinks.get(k).getDescription()); //write description 
							bwrite.newLine();
							bwrite.write(Float.toString(drinks.get(k).getPrice())); //write price 
							bwrite.newLine();
							bwrite.newLine(); //TO SEPERATE THE DIFFERENT MENUITEMS
						}	
			}
			
		bwrite.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	public void savePromo() {
		try {
			FileWriter write = new FileWriter("Promo.txt"); 
			@SuppressWarnings("resource")
			BufferedWriter bwrite = new BufferedWriter(write); //need write in order of SetId SetName SetDescription SetPrice SetItems
			for(int i=0;i<promo.size();i++) {
				if(promo.get(i)!=null){
					bwrite.write(Integer.toString(promo.get(i).getID())); //write id
					bwrite.newLine();
					bwrite.write(promo.get(i).getName());//write name
					bwrite.newLine();
					bwrite.write(promo.get(i).getDescription()); //write description 
					bwrite.newLine();
					bwrite.write(Float.toString(promo.get(i).getPrice())); //write price 
					bwrite.newLine();
					SetItems = new ArrayList<MenuItems>();
					SetItems = promo.get(i).getMenuItems();
					for(int j=0;j<SetItems.size();j++) {
						if(SetItems.get(j)!=null){
							bwrite.write(Integer.toString(SetItems.get(j).getID())); //write id
							bwrite.newLine();
							bwrite.write(SetItems.get(j).getName());//write name
							bwrite.newLine();
							bwrite.write(Integer.toString(SetItems.get(j).getCategory())); //write category 
							bwrite.newLine();
							bwrite.write(SetItems.get(j).getDescription()); //write description 
							bwrite.newLine();
							bwrite.write(Float.toString(SetItems.get(j).getPrice())); //write price 
							bwrite.newLine();
						}	}
					bwrite.write("-1");
					bwrite.newLine(); //TO SEPERATE THE DIFFERENT PROMOSETS
				}	
			}
			
		bwrite.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}