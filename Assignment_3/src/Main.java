import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import org.omg.CORBA.portable.ValueBase;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		Manage_Employees managerEmployees = new Manage_Employees("src/employees");
		
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
		
		for(Map.Entry<Integer, Employee> entry : managerEmployees.map_of_employees.entrySet()) {
			System.out.println(entry.getKey());
		}
		
		try {
		while(choice!=5) {
			System.out.println("Chose from the following opertions  ");
			System.out.println("1. Add employee details");
			System.out.println("2. Delete employee details");
			System.out.println("3. Search employee details");
			System.out.println("4. Show all  the employee details");
			System.out.println("5. Exit");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				
				managerEmployees.add_employee();
				
				
				break;
			
			case 2:
				System.out.print("Enter the id of employee: ");
				int id = scanner.nextInt();
				Employee delEmployee = managerEmployees.deleteEmployee(id);
				if(delEmployee==null) {
					System.out.print("The id is invalid !");
				}
				break;
				
			case 3:
				managerEmployees.searchEmployee();
				break;
				
			case 4:
				
				managerEmployees.showAllDetails();
				break;
			case 5:
				File file = new File("src/employees_objects");
				if(file.delete()) {
					System.out.print("Exited successfully");
				}
				else {
					System.out.print("Error occured");
				}

			default:
				break;
			}
		}
		
		
		}
		catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
//		ArrayList<Employee> my_list_to_sortArrayList = managerEmployees.list_of_employees;
//		
//		Collections.sort(my_list_to_sortArrayList,new SortByAge());
//		
//		
//		System.out.println("List sorted by age ");
//		for(Employee employee : my_list_to_sortArrayList) {
//			System.out.println(employee.getName()+"  "+employee.getAge());
//		}
//		
//        my_list_to_sortArrayList = managerEmployees.list_of_employees;
//		
//		Collections.sort(my_list_to_sortArrayList,new SortByNames());
//		
//		
//		System.out.println("List sorted by name ");
//		for(Employee employee : my_list_to_sortArrayList) {
//			System.out.println(employee.getName()+"  "+employee.getId());
//		}
//		
//		my_list_to_sortArrayList = managerEmployees.list_of_employees;
//		
//		Collections.sort(my_list_to_sortArrayList,new SortByID());
//		
//		System.out.println("List sorted by id ");
//		for(Employee employee : my_list_to_sortArrayList) {
//			System.out.println(employee.getName()+"  "+employee.getId());
//		}
//		
//		my_list_to_sortArrayList = managerEmployees.list_of_employees;
//		
//		Collections.sort(my_list_to_sortArrayList,new SortByEmail());
//		
//		System.out.println("List sorted by email ");
//		for(Employee employee : my_list_to_sortArrayList) {
//			System.out.println(employee.getName()+"  "+employee.getEmail());
//		}
//		
//		my_list_to_sortArrayList = managerEmployees.list_of_employees;
//		
//		Collections.sort(my_list_to_sortArrayList,new SortByDOB());
//		
//		System.out.println("List sorted by DOB ");
//		for(Employee employee : my_list_to_sortArrayList) {
//			System.out.println(employee.getName()+"  "+employee.getDob());
//		}
//		
		
			
		
	}
	
	
	
	

}
