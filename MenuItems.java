package oodpassignment;
/**
 * The MenuItems class is the entity class that contains the attributes of our different dishes 
 * @author hong po 
 * @since 06/11/2021 
 * @version 1.0 
 *
 */
public class MenuItems {
/**
 * 
 *An enum that shows the different types of MenuItems, namely mains, drinks and desserts 
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
 * constructor of MenuItems which creates a MenuItems object with its corresponding attributes 
 * @param id
 * @param name
 * @param choice
 * @param description
 * @param price
 */
	public MenuItems(int id, String name, int choice, String description, float price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		switch(choice) {
		case(1): 
			this.category = courseType.main; 
			break ;
		case(3):
			this.category = courseType.drink; 
			break ;
		case(2):
			this.category = courseType.dessert; 
			break; 
		}
	}
/**
 * getter method for ID of a menu item 
 * @return ID 
 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * setter method for ID of a menu item
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * getter method for name menu item 
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * setter method for name of menu item
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter method for courseType (enum) for menu item
	 * @return
	 */
	public courseType getCategory() {
		return this.category;
	}
	/**
	 * setter method for courseType (enum) for menu item
	 * @param category
	 */
	public void setCategory(courseType category) {
		this.category = category;
	}

/**
 * getter method for description of menu item 
 * @return description of menu item 
 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * setter method for description of menu item 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getter method for price of menu item 
	 * @return price
	 */
	public float getPrice() {
		return this.price;
	}
	/**
	 * setter method for price of menu item 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price=price;
	}

}