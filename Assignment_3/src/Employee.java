import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {

	private String name ;
	private String email ;
	private int age ;
	private Date dob ;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		
		this.name="samruddhi";
		this.email="samuddhi4227132@gmail.com";
		this.age = 20;
		this.dob = new Date();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getAge() {
		return age;
	}
	public Date getDob() {
		return dob;
	}
	
	@Override
	public String toString() {
		
		String employeeString ="";
		StringBuffer employeeStringBuffer = new StringBuffer(name);
		employeeStringBuffer.append(",");
		employeeStringBuffer.append(email);
		employeeStringBuffer.append(",");
		employeeStringBuffer.append(Integer.toString(age));
		employeeStringBuffer.append(",");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		employeeStringBuffer.append(dateFormat.format(dob));
		employeeStringBuffer.append(";");
		employeeString = new String(employeeStringBuffer);
		return toString();
	}
	
	public void printDetails() {
		System.out.println("Name : "+getName());
		System.out.println("Age : "+getAge());
		System.out.println("Email : "+getEmail());
		System.out.println("DOB : "+getDob());
	}
}
