import java.util.ArrayList; 
import java.util.Scanner; 
import MenuItems.courseType;
import CourseType;

public class MenuLogic { 
	// implements AddMenutoOrder 

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
		Scanner sc = new Scanner(new File("Menu.txt"));
		while(s.hasNext()){
			System.out.print("Enter the item ID\n");
			int id = sc.nextInt();
			System.out.print("Enter the item name\n");
			String name = sc.next();
			System.out.print("Enter the item category\n");
			courseType category = (courseType)sc.next();
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
	}

public void createMenuItems(int id, String name, MenuItems.courseType category, String description, float price) {
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

}