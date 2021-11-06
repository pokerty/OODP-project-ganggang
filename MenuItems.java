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

	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public courseType getCategory() {
		return this.category;
	}
	public void setCategory(courseType category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return this.price;
	}
	public void setPrice(float price) {
		this.price=price;
	}

}