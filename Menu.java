import java.util.*;
import MenuItems.courseType; 
public class Menu {

	private ArrayList<MenuItems> main;
	private ArrayList<MenuItems> drinks;
	private ArrayList<MenuItems> desserts;
	private ArrayList<MenuItems> promoItems;
	private ArrayList<MenuItems> menuItemsList;

	public Menu() {
		main = new ArrayList<MenuItems>();
		drinks = new ArrayList<MenuItems>();
		desserts = new ArrayList<MenuItems>();
		promoItems = new ArrayList<MenuItems>();
		menuItemsList = new ArrayList<MenuItems>();
		for (int i=0; i<menuItemsList.size(); i++){
			switch (menuItemsList.get(i).category){
				case 'main':
					main.add(menuItemsList.get(i));
					break;
				case 'drink':
					drinks.add(menuItemsList.get(i));
					break;
				case 'dessert':
					desserts.add(menuItemsList.get(i));
					break;
			}
		}
		throw new UnsupportedOperationException();
	}

	public void createMenuItems() {
		// TODO - implement Menu.createMenuItems
		throw new UnsupportedOperationException();
	}

	public void displayMenu() {
		// TODO - implement Menu.displayMenu
		throw new UnsupportedOperationException();
	}

	public void addItemsToOrder() {
		// TODO - implement Menu.addItemsToOrder
		throw new UnsupportedOperationException();
	}

	public void removeMenuItems() {
		// TODO - implement Menu.removeMenuItems
		throw new UnsupportedOperationException();
	}

	public void updateMenuItems() {
		// TODO - implement Menu.updateMenuItems
		throw new UnsupportedOperationException();
	}

}