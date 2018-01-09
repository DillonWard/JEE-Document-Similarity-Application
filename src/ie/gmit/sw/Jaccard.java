package ie.gmit.sw;

import java.util.List;

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
	public void compareJaccard(List<Book> library);
	
	/**
	 * Split jaccard.
	 *
	 * @param library the library
	 */
	public void splitJaccard(List<Book> library);
	
	/**
	 * Gets the jaccard.
	 *
	 * @return the jaccard
	 */
	public double getJaccard();
}
