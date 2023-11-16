package application.Model;

public class PurchaseItem {
	private String id, name, brand;
	private double sellingPrice;
	private int quantity;
	public PurchaseItem(String id, String name, String brand, double sellingPrice, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	
	

}
