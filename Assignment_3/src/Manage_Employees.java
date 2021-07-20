import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
				
				// Reading the data from the file and storing into the arraylist
				while (infileScanner.hasNext()) {
					String lineString = infileScanner.next();
					String[] objDetailsStrings = lineString.split("[,]");
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
					
					FileOutputStream fileOutputStream2 = new FileOutputStream("src/employees_objects",true);
					ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
					objectOutputStream2.writeObject(employee);
					fileOutputStream2.close();
					objectOutputStream2.close();
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
		catch ( IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// To add the record of employee
	public  void add_employee() {
		
		Scanner scanner = new Scanner(System.in);
		try {
			
		// Getting the details of the employee 
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
		
		// Creating a new employee object
		Employee newEmployee = new Employee();
		
		//  Setting the employee details 
		newEmployee.setName(name);
		newEmployee.setEmail(email);
		newEmployee.setAge(age);
		newEmployee.setDob(dob);
		
		// Adding into the list 
		this.list_of_employees.add(newEmployee);
		
		// Creating the employee details string to write into the file
		StringBuffer employeeStringBuffer = new StringBuffer(name);
		employeeStringBuffer.append(",");
		employeeStringBuffer.append(email);
		employeeStringBuffer.append(",");
		employeeStringBuffer.append(Integer.toString(age));
		employeeStringBuffer.append(",");
		employeeStringBuffer.append(date_in_string);
		employeeStringBuffer.append(";");
		String employeeString = new String(employeeStringBuffer);
		
		FileWriter fileWriter = new FileWriter(this.file_name,true);
		FileOutputStream fileWriter2 = new FileOutputStream("src/employees_objects",true);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileWriter2);
		outputStream.writeObject(newEmployee);
		fileWriter2.close();
		outputStream.close();
		
		BufferedWriter writer = new BufferedWriter(fileWriter);
		System.out.print("NEW EMPLOYEE "+employeeString);
		writer.write(employeeString);
		writer.close();
		fileWriter.close();
		
		
		}
		catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (InputMismatchException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
