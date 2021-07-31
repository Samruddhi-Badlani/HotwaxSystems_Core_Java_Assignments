import java.io.Serializable;

public class Student  implements Serializable{
	
	private String firstName ;
	private String dateOfBirth;
	private Address address;
	
	public Student(String firstName, String dateOfBirth, Address address) {
		
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	// To print the details of the object
	public void printDetails() {
		
		System.out.println("Name    : "+firstName);
		System.out.println("DOB     : "+dateOfBirth);
		address.printAddress();
		
		
	}
	
}
