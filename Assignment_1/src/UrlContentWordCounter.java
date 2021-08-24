import java.net.*;
import java.util.Comparator;

import java.util.Collections;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UrlContentWordCounter {
	
	
	public Map<String, Integer> myOutputForEachWord;
	public UrlContentWordCounter(){
		myOutputForEachWord = new HashMap<String, Integer>();
	}
	
	public ArrayList<String> readUrlsFromFile() {
		
		try {
			ArrayList<String> listOfFiles = new ArrayList<String>();
			File file1 = new File("src/URLS");
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String st;
			while ((st = br.readLine()) != null) {
			    listOfFiles.add(st);
			}
			br.close();
			return listOfFiles;
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
	
	public ArrayList<String> readWordsFromFile() {
		
		try {
			ArrayList<String> listOfWords = new ArrayList<String>();
			File file1 = new File("src/Words");
			BufferedReader br = new BufferedReader(new FileReader(file1));
			String st;
			while ((st = br.readLine()) != null) {
			    listOfWords.add(st);
			    
			}
			br.close();
			return listOfWords;
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
	public ArrayList<String> contentOfUrl(String website_address){
		
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
	public int getMyCount(String word,ArrayList<String> content ) {
		
		int frequency = 0;
		for(String line : content ) {
			if(line.contains(word)) {
				frequency++;
				
			}
		}
		return frequency;
	}
	
	// Get the word count for each word in a file for a particular URL
	public Map<String,Integer> processOneUrl(String url){
		
		Map<String, Integer> wordFrequencyCountMap = new HashMap<String, Integer>();
		ArrayList<String> content = contentOfUrl(url);
		ArrayList<String> myWords = readWordsFromFile();
		for(String word : myWords) {
			int count = getMyCount(word,content);
			wordFrequencyCountMap.put(word,count);
			
		}
	return wordFrequencyCountMap;		
	}
	
	public Map<String, Integer> sortByValue(Map<String, Integer> map) {
	
		//convert HashMap into List   
		boolean order=false;
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());  
		//sorting the list elements  
		Collections.sort(list, new Comparator<Entry<String, Integer>>()   {  
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)   {  
				if (order)   {  
					//compare two object and return an integer  
					return o1.getValue().compareTo(o2.getValue());
				}   
				else   {  
					return o2.getValue().compareTo(o1.getValue());  
				}  
			}  
		});  
		//prints the sorted HashMap  
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();  
		for (Entry<String, Integer> entry : list)   {  
			sortedMap.put(entry.getKey(), entry.getValue());  
		}  
		return sortedMap;  
	}
	
	//Process all the URLS 
	public Map<String,Map<String, Integer>> processAllUrls(){
		
		Map<String, Map<String, Integer>> urlMap = new HashMap<String,Map<String, Integer>>();
		
		ArrayList<String> myUrls = readUrlsFromFile();
		for(String url : myUrls) {
			ArrayList<String> content = contentOfUrl(url);
			ArrayList<String> myWords = readWordsFromFile();
			Map<String, Integer> wordFrequencyCountMap = new HashMap<String, Integer>();
			for(String word : myWords) {
				int count = getMyCount(word, content);
				wordFrequencyCountMap.put(word, count);
				if(myOutputForEachWord.containsKey(word)) {
					myOutputForEachWord.put(word, myOutputForEachWord.get(word)+count);
					//System.out.println("hello");
				}
				else {
					myOutputForEachWord.put(word, count);
				}
			}
			wordFrequencyCountMap=sortByValue(wordFrequencyCountMap);
			urlMap.put(url, wordFrequencyCountMap);
		}
	return urlMap;		
	}
}
