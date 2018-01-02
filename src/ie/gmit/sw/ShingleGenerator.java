package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class ShingleGenerator {

    ArrayList<String> sentenceList = new ArrayList<String>();
	List<Integer> shingleA = new ArrayList<Integer>();
	String[] SENTENCE;
	
	public ShingleGenerator() {
		super();
	}


	public void generateShingle(String line){
		
		sentenceList.add(line);
	    String[] sentenceArray = sentenceList.toArray(new String[sentenceList.size()]);

		
	       for (int r=0;r<sentenceArray.length;r++)
	       {
	           SENTENCE = sentenceArray[r].split("(?<=[.!?])\\s*");
	           for (int i=0;i<SENTENCE.length;i++)
	           {
	               System.out.println("Sentence " + (i+1) + ": " + SENTENCE[i]);
	           }

	       }

		//System.out.println("asdasd" + t);
	}
	

}
