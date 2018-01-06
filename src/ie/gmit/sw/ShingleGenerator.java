package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;


public class ShingleGenerator {

    Set<Integer> hashes = new TreeSet<Integer>();
    
	public ShingleGenerator() {
		super();
	}

	public void store(Set<Integer> hashes){
		
		Book book = new Book("10,000 Days" , hashes);
		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");
		
		try	
		{
			//db.store(book);		
			ObjectSet<Book> res = db.queryByExample(Book.class);
			System.out.println(res.toString());
			db.commit();
		
		}
		finally
		{
		 
			db.close();
		}
		
	}

	public void generateShingle(String line){
		
		ArrayList<String> words = new ArrayList<String>();
		List<List<String>> shingleParts = new ArrayList<List<String>>();
		ArrayList<String> shingleStrSet = new ArrayList<String>();
		//ArrayList<Integer> shingleSet = new ArrayList<>(); 
		
        String[] wordSplit = line.split(" ");
        final int N = words.size();
        final int shingleSize = 3;
        
        //store(line);
        
        for(int i = 0; i < wordSplit.length; i++){
        	
        	words.add(wordSplit[i]);
        }
        
        
        for (int i = 0; i < N; i += shingleSize) {
        	shingleParts.add( new ArrayList<>(words.subList(i,  Math.min(N, i + shingleSize))));
        
		}
        
        for(List<String> part: shingleParts){
        	shingleStrSet.add(String.join(" ", part));
        	String shingle = String.join(" ", part);
        	hashes.add(shingle.hashCode());
        }
        
        store(hashes);
        
	}       
		
	

}
