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
			br.close();
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
			br.close();
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
	
	// Get the content of the webpage through the URL
	public ArrayList<String> content_of_url(String website_address){
		
		ArrayList<String> content = new ArrayList<String>();
		try {
			URL url = new URL(website_address);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(url.openStream()));
			String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	        	content.add(inputLine);
	        }
	        in.close();
				        
		
		return content;
		}
		catch(MalformedURLException exception) {
			exception.printStackTrace();
			return null;
		}
		catch(IOException exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	//Get the count of a word in the content of the webpage
	public int get_my_count(String word,ArrayList<String> content ) {
		
		int frequency = 0;
		for(String line : content ) {
			if(line.contains(word)) {
				frequency++;
			}
		}
		return frequency;
	}
	
}
