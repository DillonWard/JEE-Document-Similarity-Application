package ie.gmit.sw;

import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataServices.
 */
// Interface for the DataServices that includes storing a new book to the database and retrieving all books
public interface DataServices {
	
	/**
	 * Gets the books.
	 *
	 * @return the books
	 */
	public List<Book> getBooks();
	
	/**
	 * Store book.
	 *
	 * @param title the title
	 * @param hashes the hashes
	 */
	public void storeBook(String title,Set<Integer> hashes);
	
}
