package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class ShingleGenerator implements Shingle  {

	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> shingleStrSet = new ArrayList<String>();

	private List<List<String>> shingleParts = new ArrayList<List<String>>();
	List<Book> library;
	
	HasherImplementation hasher = new HasherImplementation();
	JaccardImplementation comp = new JaccardImplementation();	

	public ShingleGenerator() {
		super();
	}

	public ArrayList<String>  generateShingle(String line) {

		String[] wordSplit = line.split(" ");
		final int N = words.size();
		final int shingleSize = 3;

		for (int i = 0; i < wordSplit.length; i++) {

			words.add(wordSplit[i]);
		}

		for (int i = 0; i < N; i += shingleSize) {
			shingleParts.add(new ArrayList<>(words.subList(i, Math.min(N, i + shingleSize))));

		}

		for (List<String> part : shingleParts) {
			shingleStrSet.add(String.join(" ", part));
		}
		//System.out.println(shingleStrSet);

		//hasher.minHash(shingleStrSet);
		
		return shingleStrSet;

	}	
	
	
	
	
	
}
