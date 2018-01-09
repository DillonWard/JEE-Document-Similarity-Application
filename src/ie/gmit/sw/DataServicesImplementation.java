package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class DataServicesImplementation implements DataServices {
	private List<Book> library;

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
	
	public  List<Book> getBooks() {
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
