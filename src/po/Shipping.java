package po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Shipping implements java.io.Serializable{

	private String shippingNo;
	private Date date;
	private Customer customer;
	private String phoneNumber;
	private String address;
	private ShippingCompany shippingCompany;
	private double cost;
	private String agent;
	private Set<ShippingDetail> shippingDetailSet = new HashSet<ShippingDetail>();
	

	public Shipping() {
	}

	public Shipping(String shippingNo, Date date, Customer customer, String phoneNumber, String address,
			ShippingCompany shippingCompany, double cost, String agent) {
		super();
		this.shippingNo = shippingNo;
		this.date = date;
		this.customer = customer;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.shippingCompany = shippingCompany;
		this.cost = cost;
		this.agent = agent;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getAgent() {
		return agent;
	}
	
	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "Shipping [shippingNo=" + shippingNo + ", date=" + date + ", customer=" + customer + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", shippingCompany=" + shippingCompany + ", cost=" + cost
				+ ", agent=" + agent + ", shippingDetailSet=" + shippingDetailSet + "]";
	}
}
