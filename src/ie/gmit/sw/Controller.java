package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Controller {

	HasherImplementation hasher = new HasherImplementation();
	ShingleGenerator sg = new ShingleGenerator();
	DataServicesImplementation ds = new DataServicesImplementation(); 
	
	private ArrayList<String> words = new ArrayList<String>();
	private Set<Integer> hashes = new TreeSet<Integer>();
	private String title;
	
	public String setTitle(String title){
		this.title = title;
		return title;
	}
	
	public void generateShingles(String line){
		words = sg.generateShingle(line);
		
	}
	
	public void minHasher(){
		hashes = hasher.minHash(words);		
		submitDocument();
	}
	
	public void submitDocument(){
		//System.out.println(title + hashes);
		ds.storeBook(title, hashes);
	}
	
	
		
}
