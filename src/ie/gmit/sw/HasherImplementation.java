package ie.gmit.sw;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class HasherImplementation.
 */
public class HasherImplementation implements Hasher {
	
	/** The hashes. */
	private Set<Integer> hashes = new TreeSet<Integer>();
	
	/** The book min hash. */
	private Set<Integer> bookMinHash = new TreeSet<Integer>();
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Hasher#minHash(java.util.List)
	 */
	public Set<Integer> minHash(List<String> shingles){
		int k = 200;
		Random r = new Random(5);
		
		for (int i = 0; i < k; i++) { // Create k random integers
			hashes.add(r.nextInt());
		} // creates 200 random integers 
		
		for(Integer hash: hashes){
			int min = Integer.MAX_VALUE;
			
			for(String word: shingles){
				
				int minHash = word.hashCode() ^ hash;
				
				if(minHash < min)
					min = minHash;
			}

			bookMinHash.add(min);
		}
	
		return bookMinHash;
	}
	
}