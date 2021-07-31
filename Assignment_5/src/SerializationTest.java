import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationTest {
	
	public static void main(String[] args) {
		
		// Creating array list for storing the students objects 
		ArrayList<Student> myStudents = new ArrayList<Student>();
		
		// Creating four student objects
		Address address1 = new Address("Indore","Madhya Pradesh",452012,"India");	
		Student student1 = new Student("rohan","20/03/2001",address1);
		
		Address address2 = new Address("Guwahati","Assam",781001,"India");	
		Student student2 = new Student("mona","29/01/2001",address2);
		
		Address address3 = new Address("Indore","Madhya Pradesh",452012,"India");	
		Student student3 = new Student("kanika","10/12/2001",address3);
		
		Address address4 = new Address("Guwahati","Assam",781001,"India");	
		Student student4 = new Student("john","13/05/2001",address4);
		
		// adding the students into the array list
		myStudents.add(student1);
		myStudents.add(student2);
		myStudents.add(student3);
		myStudents.add(student4);
		
		System.out.println(args[0]);
		
		

		try {
			
			
			FileOutputStream fileOutputStream = new FileOutputStream("src/"+args[0]);	
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(myStudents);;
			
			FileInputStream fileInputStream = new FileInputStream("src/"+args[0]);
			
			
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
	
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
