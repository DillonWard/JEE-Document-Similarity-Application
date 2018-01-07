package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class ShingleGenerator {

    Set<Integer> hashes = new TreeSet<Integer>();
	ArrayList<String> words = new ArrayList<String>();
	List<List<String>> shingleParts = new ArrayList<List<String>>();
	ArrayList<String> shingleStrSet = new ArrayList<String>();

    String title;
    
	public ShingleGenerator() {
		super();
	}

	
	public void bookName(String s){
		title = s;
	}

	public void generateShingle(String line){
		
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
	}   	
	
	public void ready(){
        store(hashes);

	}
	
	public static void listResult(ObjectSet result) {
		
		System.out.println(result.size());
		
		 while(result.hasNext()) {
		
			 System.out.println(result.next());
		
		 }
		
	}
	
	public void store(Set<Integer> hashes){
		
		Book book = new Book(title, hashes);

		ObjectContainer db = Db4oEmbedded.openFile("database.db4o");
		
		try	
		{
			ObjectSet b = db.queryByExample(Book.class);
			listResult(b);
			db.commit();
		}
		
		catch(Exception e)
		{
			db.rollback();
		}
		
		finally
		{
			db.close();
		}
		
	}
}
