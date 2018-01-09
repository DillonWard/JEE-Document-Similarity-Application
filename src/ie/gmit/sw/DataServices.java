package ie.gmit.sw;

import java.util.List;
import java.util.Set;

public interface DataServices {
	
	public List<Book> getBooks();
	public void storeBook(String title,Set<Integer> hashes);
	
}
