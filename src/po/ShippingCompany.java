package po;

public class ShippingCompany implements java.io.Serializable{

	private int id;
	private String name;
	private String url;

	public ShippingCompany(int id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	public ShippingCompany(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ShippingComapny [id=" + id + ", name=" + name + ", url=" + url + "]";
	}

	
}
