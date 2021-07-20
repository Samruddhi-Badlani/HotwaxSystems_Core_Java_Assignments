import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage_Employees {
	
	public  String file_name="src/employees";
	public   ArrayList<Employee> list_of_employees;
	
	
	// To load the data into the collection
	public Manage_Employees(String file_name) {
		// TODO Auto-generated constructor stub
		this.file_name=file_name;
		this.list_of_employees = new ArrayList<Employee>();
		try {
			File file = new File(file_name);
			if(file.exists()) {
				System.out.println("File found successfully");
				Scanner infileScanner = new Scanner(file);
				infileScanner.useDelimiter("[;]");
				while (infileScanner.hasNext()) {
					String lineString = infileScanner.next();
					String[] objDetailsStrings = lineString.split("[,]");
//					System.out.println("obje length"+objDetailsStrings.length);
					String name = objDetailsStrings[0];
					String email = objDetailsStrings[1];
					int age = Integer.parseInt(objDetailsStrings[2]);
					Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(objDetailsStrings[3]);
					Employee employee = new Employee();
					employee.setName(name);
					employee.setEmail(email);
					employee.setAge(age);
					employee.setDob(dob);
					this.list_of_employees.add(employee);
				}
				infileScanner.close();
				
			}
			else {
				System.out.print("Error ");
			}
			
		}
		catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// To add the record of employee
	public  void add_employee() {
		
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.println("Enter the following details of the employee:");
		System.out.print("Name:  ");
		String name = scanner.next();
		System.out.print("Email:  ");
		String email = scanner.next();
		System.out.print("Age:  ");
		int age = scanner.nextInt();
		System.out.print("Date in dd/MM/yyyy format :  ");
		String date_in_string = scanner.next();		
		Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(date_in_string);
		Employee newEmployee = new Employee();
		newEmployee.setName(name);
		newEmployee.setEmail(email);
		newEmployee.setAge(age);
		newEmployee.setDob(dob);
		this.list_of_employees.add(newEmployee);
		
		
		}
		catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}
	
}
