package ie.gmit.sw;

import java.util.Set;

public interface DataServices {
	
	public void getBooks();
	public void storeBook(String title,Set<Integer> hashes);
	
}
