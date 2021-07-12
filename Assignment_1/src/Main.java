import java.util.ArrayList;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//Creating an object of the class 
		URL_Content_Word_Counter myCounter = new URL_Content_Word_Counter();
		
		//Reading URLS from the file
		ArrayList<String> my_url_list= myCounter.read_urls_from_file();
		if(my_url_list!=null) {
			for(String urlString : my_url_list) {
				System.out.println(urlString);
			}
		}
		else {
			System.out.println("Error in reading URL files");
			return;
		}
		
		//Reading Words from the file
		ArrayList<String> my_word_list= myCounter.read_words_from_file();
		if(my_word_list!=null) {
			for(String wordString : my_word_list) {
				System.out.println(wordString);
			}
		}
		else {
			System.out.println("Error in reading Words files");
			return;
		}
		
		ArrayList<String>my_web_content = myCounter.content_of_url("https://www.google.com");
		int my_word_count  = myCounter.get_my_count("google", my_web_content);
		
		System.out.println(my_word_count);
	}

}
