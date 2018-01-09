package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class JaccardImplementation implements Jaccard{
	
	private double jaccardIndex;
	private int intersection;
	private int union;
	private Set<Integer> indexA = new TreeSet<Integer>();
	private Set<Integer> indexB = new TreeSet<Integer>();
	private Set<Integer> n;
	private ArrayList<Double> results = new ArrayList<Double>();

	/**
	 * Split jaccard by passing in a list of objects and comparing
	 *   each in the list against the most recently added one.
	 *
	 * @param library 
	 */
	public void splitJaccard(List<Book> library){
		
		final int len = library.size() - 1;

		indexA = library.get(len).getHashes();
		
		for(int i = 0; i < len; i++){
			
			indexB = library.get(i).getHashes();
			compareJaccard(indexA, indexB);
			
		}		
	}
	
	/**
	 * Compare jaccard.
	 *
	 * @param a the a
	 * @param b the b
	 */
	public void compareJaccard(Set<Integer> a, Set<Integer> b) {
		
		Set<Integer> n = new TreeSet<Integer>(a);
		union = a.size() + b.size();
		
		n = new TreeSet<Integer>(a);
		
		n.retainAll(b);
		
		intersection = n.size();
		
		jaccardIndex =  Double.valueOf(intersection) / (Double.valueOf(union) - Double.valueOf(intersection));
		jaccardIndex = jaccardIndex * 100;
		results.add(jaccardIndex);
	}

	/**
	 * Gets the jaccard.
	 *
	 * @return the jaccard result
	 */
	public ArrayList<Double> getJaccard(){
		
		return this.results;
	}
}
