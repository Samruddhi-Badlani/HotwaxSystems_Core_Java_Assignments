import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class URL_Content_Word_Counter {
	public ArrayList<String> read_urls_from_file() throws Exception{
		ArrayList<String> list_of_file = new ArrayList<String>();
		File file1 = new File("src/URLS.txt");
		BufferedReader br = new BufferedReader(new FileReader(file1));
		  
		  String st;
		  while ((st = br.readLine()) != null)
		    System.out.println(st);
		return list_of_file;
	}
}
