package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


// TODO: Auto-generated Javadoc
/**
 * The Class DataServicesImplementation.
 *
 */

public class DataServicesImplementation implements DataServices {
	
	/** The library. */
	private List<Book> library; // creates a new list of book objects

	/* Stores a new book to the database
	 * first the hashes and the title of the uploaded book is passed in
	 * then the new book is stored in the database
	 * once stored, the database is closed
	 */
	 
	/*
	 * (non-Javadoc)
	 * @see ie.gmit.sw.DataServices#storeBook(java.lang.String, java.util.Set)
	 */
	
	public void storeBook(String title, Set<Integer> hashes) {
		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");
		Book newBook = new Book(title, hashes);

		
		try {
			db.store(newBook);
			db.commit();
		}

		catch (Exception e) {

			db.rollback();
		}

		finally {
			db.close();
		}

	}
	

	/*
	 * Creates a list of Book Objects to be compared against
	 * populates the list of objects with entries from the database
	 */
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.DataServices#getBooks()
	 */
	public List<Book> getBooks() {
		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");

		try {

			library = new ArrayList<Book>( db.queryByExample(Book.class));
			db.commit();
			return library;
		}

		catch (Exception e) {
			
			db.rollback();
			return null;
		}

		finally {
			db.close();
		}		
	}
}
