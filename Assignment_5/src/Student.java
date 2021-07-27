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
	
}
