package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ShingleGenerator.
 */
public class ShingleGenerator implements Shingle  {

	/** The words. */
	private ArrayList<String> words = new ArrayList<String>();
	
	/** The shingle str set. */
	private ArrayList<String> shingleStrSet = new ArrayList<String>();

	/** The shingle parts. */
	private List<List<String>> shingleParts = new ArrayList<List<String>>();
	
	/** The library. */
	List<Book> library;
	
	/** The hasher. */
	HasherImplementation hasher = new HasherImplementation();
	
	/** The comp. */
	JaccardImplementation comp = new JaccardImplementation();	

	/**
	 * Instantiates a new shingle generator.
	 */
	public ShingleGenerator() {
		super();
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Shingle#generateShingle(java.lang.String)
	 */
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
		return shingleStrSet;

	}	
	
	
	
	
	
}
