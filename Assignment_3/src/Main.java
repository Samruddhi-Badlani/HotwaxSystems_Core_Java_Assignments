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
		Manage_Employees managerEmployees = new Manage_Employees("src/employees");
		for(Employee employee : managerEmployees.list_of_employees) {
			employee.printDetails();
		}
		
		
	}
	
	
	// To load the data into the arraylist 
	

}
