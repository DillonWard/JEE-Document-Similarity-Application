package ie.gmit.sw;

import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface Jaccard.
 */
public interface Jaccard {
	
	/**
	 * Compare jaccard.
	 *
	 * @param library the library
	 */
	public void splitJaccard(List<Book> library);	
	/**
	 * Split jaccard.
	 *
	 * @param library the library
	 */
	public void compareJaccard(Set<Integer> a, Set<Integer> b);
}
