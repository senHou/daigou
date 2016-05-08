package po;

import java.util.Date;

public class WeekOrderDetail implements java.io.Serializable {

	private int itemId;
	private String itemName;
	private int brandId;
	private String brandName;
	private int weekNo;
	private int year;
	private int quantity;
	private Date createDate;

	public WeekOrderDetail() {
	}

	public WeekOrderDetail(int itemId, String itemName, int brandId, String brandName, int weekNo, int year,
			int quantity, Date createDate) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.brandId = brandId;
		this.brandName = brandName;
		this.weekNo = weekNo;
		this.year = year;
		this.quantity = quantity;
		this.createDate = createDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "WeekOrderDetail [itemId=" + itemId + ", itemName=" + itemName + ", brandId=" + brandId + ", brandName="
				+ brandName + ", weekNo=" + weekNo + ", year=" + year + ", quantity=" + quantity + ", createDate="
				+ createDate + "]";
	}
	
	
}
