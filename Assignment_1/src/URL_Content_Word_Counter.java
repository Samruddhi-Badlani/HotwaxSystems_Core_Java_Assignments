import java.net.*;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Collections;
import java.awt.Choice;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.activation.MailcapCommandMap;
public class URL_Content_Word_Counter {
	public Map<String, Integer> my_output_for_each_word;
	public URL_Content_Word_Counter(){
		my_output_for_each_word=new HashMap<String, Integer>();
	}
	
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
	
	// Get the word count for each word in a file for a particular URL
	public Map<String,Integer> process_one_url(String url){
		
		Map<String, Integer> word_frequency_countMap = new HashMap<String, Integer>();
		ArrayList<String> content = content_of_url(url);
		ArrayList<String> my_words = read_words_from_file();
		for(String word : my_words) {
			int count = get_my_count(word,content);
			word_frequency_countMap.put(word, count);
			
		}
	return word_frequency_countMap;		
	}
	
	public Map<String, Integer> sortByValue(Map<String, Integer> map) {
	
		//convert HashMap into List   
		boolean order=false;
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());  
		//sorting the list elements  
		Collections.sort(list, new Comparator<Entry<String, Integer>>()   
		{  
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)   
		{  
		if (order)   
		{  
		//compare two object and return an integer  
		return o1.getValue().compareTo(o2.getValue());}   
		else   
		{  
		return o2.getValue().compareTo(o1.getValue());  
		}  
		}  
		});  
		//prints the sorted HashMap  
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();  
		for (Entry<String, Integer> entry : list)   
		{  
		sortedMap.put(entry.getKey(), entry.getValue());  
		}  
		return sortedMap;  
	}
	
	//Process all the URLS 
	public Map<String,Map<String, Integer>> process_all_urls(){
		
		Map<String, Map<String, Integer>> url_map = new HashMap<String,Map<String, Integer>>();
		
		ArrayList<String> my_urls = read_urls_from_file();
		for(String url : my_urls) {
			ArrayList<String> content = content_of_url(url);
			ArrayList<String> my_words = read_words_from_file();
			Map<String, Integer> word_frequency_countMap = new HashMap<String, Integer>();
			for(String word : my_words) {
				int count = get_my_count(word,content);
				word_frequency_countMap.put(word, count);
				if(my_output_for_each_word.containsKey(word)) {
					my_output_for_each_word.put(word, my_output_for_each_word.get(word)+count);
					//System.out.println("hello");
				}
				else {
					my_output_for_each_word.put(word,count);
				}
			}
			word_frequency_countMap=sortByValue(word_frequency_countMap);
			url_map.put(url, word_frequency_countMap);
		}
	return url_map;		
	}
}
