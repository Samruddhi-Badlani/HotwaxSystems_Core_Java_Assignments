import java.util.ArrayList;
import java.util.Map;
public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//Creating an object of the class 
		URL_Content_Word_Counter myCounter = new URL_Content_Word_Counter();
		Map<String, Map<String, Integer>> resultMap = myCounter.process_all_urls();
		
		for(Map.Entry<String, Map<String, Integer>> my_Map : resultMap.entrySet()) {
			System.out.println(my_Map.getKey());
			Map<String, Integer> word_map = my_Map.getValue();
			for(Map.Entry<String, Integer> wordEntry : word_map.entrySet()) {
				System.out.println(wordEntry.getKey()+" "+wordEntry.getValue());
			}
		}
	}

}
