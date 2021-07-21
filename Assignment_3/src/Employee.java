import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Employee implements Serializable {

	private static int id_number=0;
	private String name ;
	private String email ;
	private int age ;
	private Date dob ;
	private int id;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
		id_number++;
		this.id=id_number;
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
	
	public int getId() {
		return id;
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
		return employeeString;
	}
	
	public void printDetails() {
		System.out.println("Id : "+getId());
		System.out.println("Name : "+getName());
		System.out.println("Age : "+getAge());
		System.out.println("Email : "+getEmail());
		System.out.println("DOB : "+getDob());
	}
	
	
}
// Sort the list of employees according to the names in the ascending order
class SortByNames implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}

//Sort the list of employees according to the ID in the ascending order
class SortByID implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}
	
}

//Sort the list of employees according to the Age in the ascending order
class SortByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getAge()-o2.getAge();
	}
	
}

//Sort the list of employees according to the email in the ascending order
class SortByEmail implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}
	
}

//Sort the list of employees according to the DOB in the ascending order
class SortByDOB implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getDob().compareTo(o2.getDob());
	}
	
}
