
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
		
		
		
		
		while(choice!=5) {
			try {
			System.out.println("Chose from the following opertions  ");
			System.out.println("1. Add employee details");
			System.out.println("2. Delete employee details");
			System.out.println("3. Search employee details");
			System.out.println("4. Show all  the employee details");
			System.out.println("5. Exit");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				
				managerEmployees.addEmployee();
				
				
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
				break;

			default:
				System.out.println("Enter the choice between 1 to 5 only");
				break;
			}
			}
			catch (InputMismatchException e) {
				// TODO: handle exception
				scanner.next();
				System.out.println(e.getMessage());
			}
		}
		
		

		
		
			
		
	}
	
	
	
	

}
