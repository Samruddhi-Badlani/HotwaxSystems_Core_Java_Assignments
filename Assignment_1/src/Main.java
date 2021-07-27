import java.util.ArrayList;
import java.util.Map;
public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//Creating an object of the class 
		UrlContentWordCounter myCounter = new UrlContentWordCounter();
		Map<String, Map<String, Integer>> resultMap = myCounter.processAllUrls();
		System.out.println("OUTPUT #1\n ========\n");
		for(Map.Entry<String, Map<String, Integer>> my_Map : resultMap.entrySet()) {
			System.out.println(my_Map.getKey());
			int top_words_count =3;
			int count_words=0;
			Map<String, Integer> word_map = my_Map.getValue();
			for(Map.Entry<String, Integer> wordEntry : word_map.entrySet()) {
				count_words++;
				if(count_words > top_words_count) {
					break;
				}
				System.out.println(wordEntry.getKey()+" "+wordEntry.getValue());
			}
		}
		System.out.println("==============================");
		System.out.println("OUTPUT #2");
		myCounter.myOutputForEachWord=myCounter.sortByValue(myCounter.myOutputForEachWord);
		for(Map.Entry<String, Integer> entry:myCounter.myOutputForEachWord.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
