package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShingleGenerator {

    ArrayList<Integer> sentenceList = new ArrayList<Integer>();

	public ShingleGenerator() {
		super();
	}


	public void generateShingle(String line){
		
		ArrayList<String> words = new ArrayList<String>();
		List<List<String>> shingleParts = new ArrayList<List<String>>();
		ArrayList<String> shingleStrSet = new ArrayList<String>();
		ArrayList<Integer> shingleSet = new ArrayList<>(); 
		
        String[] wordSplit = line.split(" ");
        final int N = words.size();
        final int shingleSize = 3;
        
        
        for(int i = 0; i < wordSplit.length; i++){
        	
        	words.add(wordSplit[i]);
        }
        
        
        for (int i = 0; i < N; i += shingleSize) {
        	shingleParts.add( new ArrayList<>(words.subList(i,  Math.min(N, i + shingleSize))));
        
		}
        
        for(List<String> part: shingleParts){
        	shingleStrSet.add(String.join(" ", part));
        	String shingle = String.join(" ", part);
        	shingleSet.add(shingle.hashCode());
        }
        
        System.out.println(shingleStrSet);
        System.out.println(shingleSet);

	}       
		
	

}
