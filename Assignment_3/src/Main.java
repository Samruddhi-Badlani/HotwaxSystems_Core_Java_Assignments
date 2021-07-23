
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		ManageEmployees managerEmployees = new ManageEmployees("src/employees");
		
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
		
		
		
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
//		
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
		
		
			
		
	}
	
	
	
	

}
