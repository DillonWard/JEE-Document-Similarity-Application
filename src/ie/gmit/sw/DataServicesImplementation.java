package ie.gmit.sw;

import java.util.List;
import java.util.Set;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class DataServicesImplementation implements DataServices {
	private List<Book> library;
	
	JaccardImplementation comp = new JaccardImplementation();

	public void storeBook(String title, Set<Integer> hashes) {
		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");

		Book newBook = new Book(title, hashes);
		
		System.out.println(newBook);

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

		getBooks();

	}
	
	public void getBooks() {
		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");

		try {

			library = db.queryByExample(Book.class);
			comp.compareJaccard(library);
			db.commit();
		}

		catch (Exception e) {
			db.rollback();
		}

		finally {
			db.close();
		}

	}

}
