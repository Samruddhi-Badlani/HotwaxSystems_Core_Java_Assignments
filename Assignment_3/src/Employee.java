import java.sql.Date;

public class Employee {

	private String name ;
	private String email ;
	private int age ;
	private String dob ;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		
		this.name="samruddhi";
		this.email="samuddhi4227132@gmail.com";
		this.age = 20;
		this.dob = "29/09/2001";
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
	
	public void setDob(String dob) {
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
	public String getDob() {
		return dob;
	}
}
