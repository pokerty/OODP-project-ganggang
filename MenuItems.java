public class MenuItems {

	public enum courseType {
		main, drinks, desserts, promotionSet
	}
	private String name;
	private courseType category;
	private String description;
	private float price;


	public MenuItems(String name, courseType category, String description, float price) {
		// TODO - implement MenuItems.MenuItems
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
		throw new UnsupportedOperationException();
	}

	public courseType getCategory() {
		return this.category;
	}
	/**
	 * 
	 * @param type
	 */
	public void setCategory(courseType category) {
		this.category = category;
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		return this.description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
		throw new UnsupportedOperationException();
	}

	public float getPrice() {
		return this.price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price=price;
		throw new UnsupportedOperationException();
	}

}