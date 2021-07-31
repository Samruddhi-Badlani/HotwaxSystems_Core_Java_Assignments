import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student  implements Serializable{
	
	private String firstName ;
	private Date dateOfBirth;
	private Address address;
	
	public Student(String firstName, String dateOfBirth, Address address) {
		
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		try {
			this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		
		try {
			this.dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
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
