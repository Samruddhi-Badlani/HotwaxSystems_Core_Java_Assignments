import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		ArrayList<Employee> list_of_employees =load_data_in_list();
		System.out.print(list_of_employees.size());	
			
		
		
	}
	
	
	// To load the data into the arraylist 
	public static ArrayList<Employee> load_data_in_list(){
		
		ArrayList<Employee> employeeDetails = new ArrayList<Employee>();
		try {
			File file = new File("src/employees");
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
					employeeDetails.add(employee);
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
		
		return employeeDetails;
	}

}
