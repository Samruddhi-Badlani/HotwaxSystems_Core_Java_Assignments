import java.io.Serializable;

public class Address implements Serializable{
	
	private String city;
	private String state;
	private int pinCode;
	private String country;
	
	public Address(String city, String state, int pinCode, String country) {
		
		// TODO Auto-generated constructor stub
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.country = country;
	}
	
	
}
