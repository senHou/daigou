package po;

public class ShippingDetail {
	private int id;
	private String shippingNo;
	private Item item;
	private double soldPrice;
	private int quantity;

	public ShippingDetail() {
	}
	
	public ShippingDetail(int id, String shippingNo, Item item, double soldPrice, int quantity) {
		super();
		this.id = id;
		this.shippingNo = shippingNo;
		this.item = item;
		this.soldPrice = soldPrice;
		this.quantity = quantity;
	}

	public ShippingDetail(String shippingNo, Item item, double soldPrice, int quantity) {
		super();
		this.shippingNo = shippingNo;
		this.item = item;
		this.soldPrice = soldPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ShippingDetail [id=" + id + ", shippingNo=" + shippingNo + ", item=" + item + ", soldPrice=" + soldPrice
				+ ", quantity=" + quantity + "]";
	}

}
