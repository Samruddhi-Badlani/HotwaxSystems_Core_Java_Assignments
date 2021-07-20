import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
//		System.out.println("Hello world!");
//		Manage_Employees managerEmployees = new Manage_Employees("src/employees");
//		for(Employee employee : managerEmployees.list_of_employees) {
//			employee.printDetails();
//		}
	
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
	
	
	
	

}
