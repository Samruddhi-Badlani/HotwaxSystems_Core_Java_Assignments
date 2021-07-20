import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
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
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

public class Manage_Employees {
	
	public  String file_name="src/employees";
	public   ArrayList<Employee> list_of_employees;
	public  HashMap<Integer, Employee> map_of_employees;
	
	
	// To load the data into the collection
	public Manage_Employees(String file_name) {
		// TODO Auto-generated constructor stub
		this.file_name=file_name;
		this.list_of_employees = new ArrayList<Employee>();
		this.map_of_employees = new HashMap<Integer, Employee>();
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
					this.map_of_employees.put(employee.getId(),employee);
					FileOutputStream fileOutputStream2 = new FileOutputStream("src/employees_objects",true);
					ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
					objectOutputStream2.writeObject(employee);
					objectOutputStream2.close();
					fileOutputStream2.close();
				
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
			this.map_of_employees.put(newEmployee.getId(), newEmployee);
			
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
			System.out.print("NEW EMPLOYEE "+newEmployee.toString());
			writer.write(employeeString);
			writer.close();
			fileWriter.close();
			System.out.println("Employee details added successfully");
			
			
		}
		catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Invalid input");
		}
		catch (ParseException e) {
			System.out.println("Invalid input");
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println("IO exception occured");
		}
	}
	
	
	// To show all the details of all employees
	public void showAllDetails() {
		
	try {
			FileInputStream fileInputStream = new FileInputStream("src/employees_objects");
			while(true) {
				try {
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object obj = objectInputStream.readObject();
			if(obj==null) {
				break;
			}
			Employee xEmployee = (Employee)obj;
				xEmployee.printDetails();
			}
			catch (EOFException e) {
				// TODO: handle exception
				break;
			}
			
			
			}
	}

	catch (FileNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
	}
	
	// To delete the employee through the id 
	public Employee deleteEmployee(int id) {
		
		if(this.map_of_employees.containsKey(id)) {
			System.out.println("yes the employee is there ");
			System.out.print("Following are the details ");
			this.map_of_employees.get(id).printDetails();
			try {
				String filePath = this.file_name;
			    String result = fileToString(filePath);
			    
			    //Replacing the word with desired one
			    result = result.replaceAll(this.map_of_employees.get(id).toString(), "");
			    
			    
			    //Rewriting the contents of the text file
			    FileWriter fileWriter = new FileWriter(new File(filePath));
			    
			    
				
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write(result);
				writer.close();
				fileWriter.close();
				System.out.println("Successfully deleted ");
				
				// Rewriting the contents in objects file
				FileInputStream fileInputStream = new FileInputStream("src/employees_objects");
				ArrayList<Employee> employees = new ArrayList<Employee>();
				while(true) {
					try {
						ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
						Object obj = objectInputStream.readObject();
						if(obj==null) {
							break;
							}
						Employee xEmployee = (Employee)obj;
						if(xEmployee.getId()!=id) {
							employees.add(xEmployee);
						}
					}
					catch (ClassNotFoundException e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					catch (EOFException e) {
						// TODO: handle exception
							break;
							}
				}
				
				File file = new File("src/employees_objects");
				if(file.delete()) {
					System.out.print("Deleted the employee successfully");
				}
				else {
					System.out.print("Error occured");
				}
				FileOutputStream fileOutputStream2 = new FileOutputStream("src/employees_objects",true);
				for(Employee myEmployee : employees ) {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream2);
					objectOutputStream.writeObject(myEmployee);
				}
				this.map_of_employees.remove(id);
				return this.map_of_employees.get(id);

			}
			catch (IOException e) {
				// TODO: handle exception
				System.out.print("IO exception has occured  ");
				return null;
			}
			
		}
		else {
			return null;
		}
		
	}
	
	public String fileToString(String filePath) {
		
		try {
			String input = null;
		    Scanner sc = new Scanner(new File(filePath));
		    StringBuffer sb = new StringBuffer();
		    while (sc.hasNextLine()) {
		    	input = sc.nextLine();
		        sb.append(input);
		      }
		      return sb.toString();
		}
		
		catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Could not find file ");
			return "null";
		}
	}
	
}
