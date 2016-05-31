package po;

public class WeekOrderItem extends Item implements java.io.Serializable{
	private int weekNo;
	private int year;
	private int quantity;

	public WeekOrderItem() {

	}

	public WeekOrderItem(int id, Brand brand, String name, int weekNo, int year, int quantity) {
		super(id, brand, name);
		this.weekNo = weekNo;
		this.year = year;
		this.quantity = quantity;
	}

	public int getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(int weekNo) {
		this.weekNo = weekNo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
