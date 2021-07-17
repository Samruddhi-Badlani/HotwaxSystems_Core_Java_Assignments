import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		try {
			File file = new File("src/employees");
			if(file.exists()) {
				System.out.println("File found successfully");
				Scanner infileScanner = new Scanner(file);
				infileScanner.useDelimiter("[;]");
				while (infileScanner.hasNext()) {
					System.out.print(infileScanner.next());
				}
				infileScanner.close();
				
			}
			else {
				System.out.print("Error ");
			}
			
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			
			
		
		
	}

}
