package po;

import java.util.Date;
import java.util.Set;

public class Shipping {

	private String shippingNo;
	private Date date;
	private Customer customer;
	private long phoneNumber;
	private String address;
	private ShippingCompany shippingCompany;
	private Set<ShippingDetail> shippingDetailSet;

	public Shipping() {
	}

	public Shipping(String shippingNo, Date date, Customer customer, long phoneNumber, String address,
			ShippingCompany shippingCompany) {
		super();
		this.shippingNo = shippingNo;
		this.date = date;
		this.customer = customer;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.shippingCompany = shippingCompany;
	}

	public String getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}
	
	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	
	public Set<ShippingDetail> getShippingDetailSet() {
		return shippingDetailSet;
	}
	
	public void setShippingDetailSet(Set<ShippingDetail> shippingDetailSet) {
		this.shippingDetailSet = shippingDetailSet;
	}

	@Override
	public String toString() {
		return "Shipping [shippingNo=" + shippingNo + ", customer=" + customer.toString() + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", shippingCompany=" + shippingCompany + "]";
	}

}
