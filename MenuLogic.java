import java.util.*;
import MenuItems.courseType; 


public class MenuLogic implements AddMenutoOrder {

	public enum courseType {
		main, drink, dessert
	}
	
	private ArrayList<MenuItems> mains;
	private ArrayList<MenuItems> drinks;
	private ArrayList<MenuItems> desserts;
	private ArrayList<PromotionalSet> promo;

	private ArrayList<MenuItems> menuItemsList; //populate with database

	public MenuLogic() {
		mains = new ArrayList<MenuItems>();
		drinks = new ArrayList<MenuItems>();
		desserts = new ArrayList<MenuItems>();
		promo = new ArrayList<PromotionalSet>();
		menuItemsList = new ArrayList<MenuItems>();
		for (int i=0; i<menuItemsList.size(); i++){
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
	}

public void createMenuItems(String name, courseType category, String description, float price) {
	switch (category){
		case main:
			mains.add(new MenuItems(name, category, description, price));
			break;
		case drink:
			drinks.add(new MenuItems(name, category, description, price));
			break;
		case dessert:
			desserts.add(new MenuItems(name, category, description, price));
			break;
	}
}

	public void displayMenu() {
		System.out.print("Mains:\n");
		for (int i=0; i<mains.size(); i++){
			System.out.print(mains.get(i));
		}
		System.out.print("Drinks:\n");
		for (int i=0; i<drinks.size(); i++){
			System.out.print(drinks.get(i));
		}
		System.out.print("Desserts:\n");
		for (int i=0; i<desserts.size(); i++){
			System.out.print(desserts.get(i));
		}
		System.out.print("Promotional Sets:\n");
		for (int i=0; i<promo.size(); i++){
			System.out.print(promo.get(i));
		}
	}

	public void addItemsToOrder() {
		// TODO - implement MenuLogic.addItemsToOrder
		throw new UnsupportedOperationException();
	}

	public void removeMenuItems(String name, courseType category) {
		switch (category){
			case main:
				for (int i=0; i<mains.size(); i++){
					if (mains.get(i).getName()==name){
						mains.remove(i);
					}
				}
				break;
			case drink:
				for (int i=0; i<drinks.size(); i++){
					if (drinks.get(i).getName()==name){
						drinks.remove(i);
					}
				}
				break;
			case dessert:
				for (int i=0; i<desserts.size(); i++){
					if (desserts.get(i).getName()==name){
						desserts.remove(i);
					}
				}
				break;
		}
	}

	public void updateMenuItems() {
		// TODO - implement MenuLogic.updateMenuItems
		throw new UnsupportedOperationException();
	}

}