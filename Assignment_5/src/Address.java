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
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void printAddress() {
		
		System.out.println("City    : "+city);
		System.out.println("State   : "+city);
		System.out.println("PinCode : "+pinCode);
		System.out.println("Country : "+country);
		
		
	}
	
	
}
