package oodpassignment;

public class MenuItems {

	public enum courseType {
		main, drink, dessert
	}
	private int id; 
	private String name;
	private courseType category;
	private String description;
	private float price;


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
	 * to get menuitem id
	 * @return int
	 */
	public int getID() {
		return this.id;
	}
	
	/** 
	 * to change menuitem id
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}

	
	/** 
	 * to get menuitem name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * to change menuitem name 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * to get menuitem type
	 * @return courseType
	 */
	public courseType getCategory() {
		return this.category;
	}
	
	/** 
	 * to change menuitem type
	 * @param category
	 */
	public void setCategory(courseType category) {
		this.category = category;
	}

	
	/** 
	 * to get menuitem description
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}
	
	/** 
	 * to change menuitem description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * to get menuitem price
	 * @return float
	 */
	public float getPrice() {
		return this.price;
	}
	
	/** 
	 * to change menuitem price
	 * @param price
	 */
	public void setPrice(float price) {
		this.price=price;
	}

}