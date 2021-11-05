package Application;
public class MenuItems {

	public enum courseType {
		main, drink, dessert
	}
	private int id; 
	private String name;
	private courseType category;
	private String description;
	private float price;


	public MenuItems(int id, String name, courseType category, String description, float price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
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