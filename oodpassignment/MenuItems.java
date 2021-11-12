package oodpassignment;

/**
 * The MenuItems class is the entity class that contains the attributes of our
 * different dishes
 * 
 * @author hong po
 * @since 06/11/2021
 * @version 1.0
 *
 */
public class MenuItems {
	/**
	 * 
	 * An enum that shows the different types of MenuItems, namely mains, drinks and
	 * desserts
	 *
	 */
	public enum courseType {
		main, drink, dessert
	}

	/**
	 * A unique identifier for each kind of dish
	 */
	private int id;

	/**
	 * Name of the dish
	 */
	private String name;
	/**
	 * Category of the dish which is defined by the courseType enum
	 */
	private courseType category;
	/**
	 * Description of the menu item we are selling
	 */
	private String description;
	/**
	 * price of the menu item
	 */
	private float price;

	/**
	 * constructor of MenuItems which creates a MenuItems object with its
	 * corresponding attributes
	 * 
	 * @param id          ID of dish
	 * @param name        Name of dish
	 * @param choice      Reflects the type of dish, 1 = mains, 2 = dessert, 3 =
	 *                    drinks
	 * @param description The description of the dish
	 * @param price       The price of the dish
	 */
	public MenuItems(int id, String name, int choice, String description, float price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		switch (choice) {
		case (1):
			this.category = courseType.main;
			break;
		case (3):
			this.category = courseType.drink;
			break;
		case (2):
			this.category = courseType.dessert;
			break;
		}
	}

	/**
	 * getter method for ID of a menu item
	 * 
	 * @return ID ID of dish
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * setter method for ID of a menu item
	 * 
	 * @param id The ID you want to set for the dish
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * getter method for name menu item
	 * 
	 * @return name The name of the dish
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter method for name of menu item
	 * 
	 * @param name enter the name you want to name the dish
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter method for courseType (enum) for menu item
	 * 
	 * @return returns what kind of dish it is, either a main, drink or dessert
	 */
	public courseType getCategory() {
		return this.category;
	}

	/**
	 * setter method for courseType (enum) for menu item
	 * 
	 * @param category sets what kind of dish it is - mains or drinks or desserts
	 */
	public void setCategory(courseType category) {
		this.category = category;
	}

	/**
	 * getter method for description of menu item
	 * 
	 * @return the current description of menu item
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * setter method for description of menu item
	 * 
	 * @param description the description you want the dish to have
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getter method for price of menu item
	 * 
	 * @return price the price of the dish
	 */
	public float getPrice() {
		return this.price;
	}

	/**
	 * setter method for price of menu item
	 * 
	 * @param price the price you want to set the dish
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}