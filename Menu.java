package OOP;

public class Menu {
	private String menuId;
	private String dishName;
	private String category;
	private double pricePerTable;

	public Menu(String menuId, String dishName, String category, double pricePerTable) {
		super();
		this.menuId = menuId;
		this.dishName = dishName;
		this.category = category;
		this.pricePerTable = pricePerTable;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public void setPricePerTable(double pricePerTable) {
		this.pricePerTable = pricePerTable;
	}

	public void addDish() {
	}

	public void updateMenuPrice(double newPrice) {
		this.pricePerTable = newPrice;
	}

	public double getPricePerTable() {
		return pricePerTable;
	}

	public String getDishName() {
		// TODO Auto-generated method stub
		return dishName;
	}
}
