import java.io.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int choice = 0;  // Choice stores the user choice to perform the further operations
		System.out.println("SELECT ANY SHAPE FROM THE FOLLOWING");
		Scanner scanner=new Scanner(System.in);
		
		//Menu driven program to find the details of the shapes
		while(choice!=6) {
			
			// Options of the shapes available
			System.out.println("1. Square");
			System.out.println("2. Rectangle");
			System.out.println("3. Circle");
			System.out.println("4. Triangle");
			System.out.println("5. Cube");
			System.out.println("6. Exit");
			
			choice = scanner.nextInt();
			
			switch (choice) {
			// Square 
			case 1:
				System.out.print("Enter the side of the square: ");
				double side = scanner.nextDouble();
				Square mySquare = new Square(side);
				mySquare.printDetails();
				break;
				
			// Rectangle	
			case 2:
				System.out.print("Enter the length of the rectangle ");
				double length = scanner.nextDouble();
				System.out.print("Enter the breadth of the rectangle ");
				double breadth = scanner.nextDouble();
				Rectangle myRectangle = new Rectangle(length, breadth);
				myRectangle.printDetails();
				break;
				
			case 6:
				System.out.println("Program exited successfully");
				break;
			default:
				System.out.println("Invalid choice ");
				break;
			}
		}

	}

}
