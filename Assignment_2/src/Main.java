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
			while(choice!=9) {
					// Options of the shapes available
					System.out.println("1. Square");
					System.out.println("2. Rectangle");
					System.out.println("3. Circle");
					System.out.println("4. Triangle");
					System.out.println("5. Cube");
					System.out.println("6. Cuboid");
					System.out.println("7. Sphere");
					System.out.println("8. Cylinder");
					System.out.println("9. Exit");
					
					try {
						choice = scanner.nextInt();

					
					
						switch (choice) {
						// Square 
						case 1:
							System.out.print("Enter the side of the square: ");
							double side = scanner.nextDouble();
							Square mySquare = new Square(side);
							if(mySquare.checkValidity(side)) {
								mySquare.printDetails();
							}
							break;
							
						// Rectangle	
						case 2:
							System.out.print("Enter the length of the rectangle ");
							double length = scanner.nextDouble();
							System.out.print("Enter the breadth of the rectangle ");
							double breadth = scanner.nextDouble();
							Rectangle myRectangle = new Rectangle(length, breadth);
							if(myRectangle.checkValidity(length, breadth)) {
								myRectangle.printDetails();
							}
							break;
						
						// Circle	
						case 3:
							System.out.print("Enter the radius of the circle ");
							double radius = scanner.nextDouble();
							Circle myCircle = new Circle(radius);
							if(myCircle.checkValidity(radius)) {
								myCircle.printDetails();
							}
							break;
						
						// Triangle
						case 4:
							System.out.print("Enter side1 = ");
							double side1 = scanner.nextDouble();
							System.out.print("Enter side2 = ");
							double side2 = scanner.nextDouble();
							System.out.print("Enter side3 = ");
							double side3 = scanner.nextDouble();
							Triangle myTriangle = new Triangle(side1, side2, side3);
							if(myTriangle.checkValidity(side1, side2, side3)) {
								myTriangle.printDetails();
							}
							break;
							
						// Cube
						case 5:
							System.out.print("Enter the side of the Cube: ");
							side = scanner.nextDouble();
							Cube myCube = new Cube(side);
							if(myCube.checkValidity(side)) {
								myCube.printDetails();
							}
							break;
							
						// Cuboid 	
						case 6:
							System.out.print("Enter the length of the cuboid ");
							length = scanner.nextDouble();
							System.out.print("Enter the breadth of the cuboid ");
							breadth = scanner.nextDouble();
							System.out.print("Enter the height of the cuboid ");
							double height = scanner.nextDouble();
							Cuboid myCuboid = new Cuboid(length, breadth, height);
							if(myCuboid.checkValidity(length, breadth)) {
								myCuboid.printDetails();
							}
							break;
							
						// Sphere
						case 7:
							System.out.print("Enter the radius of the sphere ");
							radius = scanner.nextDouble();
							Sphere mySphere = new Sphere(radius);
							if(mySphere.checkValidity(radius)) {
								mySphere.printDetails();
							}
							break;
							
						// Cylinder
						case 8:
							System.out.print("Enter the radius of the cylinder ");
							radius = scanner.nextDouble();
							System.out.print("Enter the height of the cuboid ");
						    height = scanner.nextDouble();
							Cylinder myCylinder = new Cylinder(radius, height);
							if(myCylinder.checkValidity(radius, height)) {
								myCylinder.printDetails();
							}
							break;
							
						case 9:
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
