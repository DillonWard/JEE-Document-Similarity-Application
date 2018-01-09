package ie.gmit.sw;

import java.util.Set;
import java.util.TreeSet;

// TODO: Auto-generated Javadoc
/**
 * The Class Book.
 *
 * @author dillo
 */
public class Book {

	/** The name. */
	private String name;
	
	/** The hashes. */
	private Set<Integer> hashes = new TreeSet<Integer>();
	
	
	/**
	 * Instantiates a new book.
	 */
	public Book(){
		
	}
	
	/**
	 * Instantiates a new book.
	 *
	 * @param name the name
	 * @param hashes the hashes
	 */
	public Book(String name, Set<Integer> hashes){
		super();
		this.name = name;
		this.hashes = hashes;

	}

	/**
	 * Gets the hashes.
	 *
	 * @return the hashes
	 */
	public Set<Integer> getHashes() {
		return hashes;
	}

	/**
	 * Sets the hashes.
	 *
	 * @param hashes the new hashes
	 */
	public void setHashes(Set<Integer> hashes) {
		this.hashes = hashes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [name=" + name + ", hashes=" + hashes + "]";
	}
	
	
}
