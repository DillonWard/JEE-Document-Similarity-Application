package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class ShingleGenerator implements Shingle {

	private Set<Integer> hashes = new TreeSet<Integer>();
	private Set<Integer> bookMinHash = new TreeSet<Integer>(); 

	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> shingleStrSet = new ArrayList<String>();

	private List<List<String>> shingleParts = new ArrayList<List<String>>();
	
	private String title;	
	List<Book> library;
	Book newBook;
	ComputeJaccard comp = new ComputeJaccard();

	public ShingleGenerator() {
		super();
	}

	public void generateShingle(String line) {

		String[] wordSplit = line.split(" ");
		final int N = words.size();
		final int shingleSize = 3;

		for (int i = 0; i < wordSplit.length; i++) {

			words.add(wordSplit[i]);
		}

		for (int i = 0; i < N; i += shingleSize) {
			shingleParts.add(new ArrayList<>(words.subList(i, Math.min(N, i + shingleSize))));

		}

		for (List<String> part : shingleParts) {
			shingleStrSet.add(String.join(" ", part));
			
		}
		
		minHash(shingleStrSet);
	}


	public Set<Integer> minHash(List<String> shingles){
		int k = 200;
		Random r = new Random(5);
		
		for (int i = 0; i < k; i++) { // Create k random integers
			hashes.add(r.nextInt());
		}
		
		for(Integer hash: hashes){
			int min = Integer.MAX_VALUE;
			
			for(String word: shingles){
				
				int minHash = word.hashCode() ^ hash;
				
				if(minHash < min)
					min = minHash;
			}

			bookMinHash.add(min);
		}
	
		
		return bookMinHash;
	}
	

	public void storeBook(Set<Integer> hashes) {
		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");

		newBook = new Book(title, hashes);

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
	
	public void getTitle(String title) {
		this.title = title;
		storeBook(bookMinHash);
	}

}
