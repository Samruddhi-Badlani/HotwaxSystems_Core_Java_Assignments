import java.io.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0;
		System.out.println("SELECT ANY SHAPE FROM THE FOLLOWING");
		Scanner scanner=new Scanner(System.in);
		while(choice!=6) {
			System.out.println("1. Square");
			System.out.println("2. Rectangle");
			System.out.println("3. Circle");
			System.out.println("4. Triangle");
			System.out.println("5. Cube");
			System.out.println("6. Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the side of the square: ");
				double side = scanner.nextInt();
				Square mySquare = new Square(side);
				mySquare.printDetais();
				break;
			case 6:
				System.out.println("Program exited successfully");
				break;
			default:
				break;
			}
		}

	}

}
