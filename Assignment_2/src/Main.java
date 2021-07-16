import java.io.*;
import java.util.InputMismatchException;
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
					
					try {
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
						
						// Circle	
						case 3:
							System.out.print("Enter the radius of the circle ");
							double radius = scanner.nextDouble();
							Circle myCircle = new Circle(radius);
							myCircle.printDetails();
						
						// Triangle
						case 4:
							System.out.print("Enter side1 = ");
							double side1 = scanner.nextDouble();
							System.out.print("Enter side2 = ");
							double side2 = scanner.nextDouble();
							System.out.print("Enter side3 = ");
							double side3 = scanner.nextDouble();
							Triangle myTriangle = new Triangle(side1, side2, side3);
							myTriangle.printDetails();
							break;
						case 6:
							System.out.println("Program exited successfully");
							break;
						default:
							System.out.println("Invalid choice please enter correct choice");
							break;
						}
					}
					catch (InputMismatchException e) {
						// TODO: handle exception
						System.out.print("Invalid input not an integer or double\n");
					}
					
						scanner.nextLine(); 
			}
	}
	
	

}
