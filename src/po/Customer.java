package po;

import java.util.Arrays;
import java.util.List;

public class Customer implements java.io.Serializable{

	private String id;
	private String name;
	private List<Shipping> shippings;

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

	public Customer() {
	}

	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Customer(String id, String name, List<Shipping> shippings) {
		super();
		this.id = id;
		this.name = name;
		this.shippings = shippings;
	}

	public List<Shipping> getShippings() {
		return shippings;
	}

	public void setShippings(List<Shipping> shippings) {
		this.shippings = shippings;
	}

	@Override
	public String toString() {
		
//		StringBuilder sb = new StringBuilder("Customer [id=" + id + ", name=" + name + "]");
//		
//		if (shippings != null && shippings.size() > 0) {
//			for (int i = 0; i < shippings.size(); i ++) {
//				sb.append(shippings.get(i).getShippingNo()+" "+shippings.get(i).getCustomer().getName());
//			}
//		}
//		
//		return sb.toString();
		return "Customer [id=" + id + ", name=" + name + "]";
	}


}
