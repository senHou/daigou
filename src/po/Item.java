package po;

public class Item {
	protected int id;
	protected Brand brand;
	protected String name;

	public Item() {
	}

	public Item(int id, Brand brand, String name) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", brand=" + brand + ", name=" + name + "]";
	}

}
