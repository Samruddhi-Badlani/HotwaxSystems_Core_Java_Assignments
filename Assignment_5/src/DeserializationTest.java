import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("src/"+args[0]);
			
			while(true) {
				try {
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					ArrayList<Student> myStoredStudents =  (ArrayList<Student>) objectInputStream.readObject();
					if(myStoredStudents != null) {
						for(Student student : myStoredStudents) {
							student.printDetails();
							System.out.println("*********************************8");
						}
					}
					else {
						objectInputStream.close();
						break;
					}
				}
				catch (EOFException e) {
					// TODO: handle exception
					break;
				} 
				
			}
			fileInputStream.close();
		}
		
		catch (FileNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		
		
		catch (IOException exception) {
			// TODO: handle exception	
			exception.printStackTrace();
		}
		
		catch (ClassNotFoundException exception) {
			
			exception.printStackTrace();
			
		}

		

	}

}
