import java.net.*;
import java.io.*;
import java.util.ArrayList;
public class URL_Content_Word_Counter {
	public ArrayList<String> read_urls_from_file() {
		try {
			ArrayList<String> list_of_file = new ArrayList<String>();
			File file1 = new File("src/URLS");
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String st;
			while ((st = br.readLine()) != null) {
			    list_of_file.add(st);
			}
			return list_of_file;
		}
		catch (FileNotFoundException exception) {
			// TODO: handle exception
			exception.printStackTrace();
			return null;
		}
		catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return null;
		}
	
		
	}
	
	public ArrayList<String> read_words_from_file() {
		try {
			ArrayList<String> list_of_words = new ArrayList<String>();
			File file1 = new File("src/Words");
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String st;
			while ((st = br.readLine()) != null) {
			    list_of_words.add(st);
			}
			return list_of_words;
		}
		catch (FileNotFoundException exception) {
			// TODO: handle exception
			exception.printStackTrace();
			return null;
		}
		catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return null;
		}
	
		
	}
}
