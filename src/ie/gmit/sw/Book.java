package ie.gmit.sw;

import java.util.Set;
import java.util.TreeSet;

public class Book {

	private String name;
	private Set<Integer> hashes = new TreeSet<Integer>();
	//private ArrayList<String> hashes = new ArrayList<String>();
	
	public Book(){
		
	}
	
	public Book(String name, Set<Integer> hashes){
		this.name = name;
		this.hashes = hashes;

	}
	
	

	public Set<Integer> getHashes() {
		return hashes;
	}

	public void setHashes(Set<Integer> hashes) {
		this.hashes = hashes;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", hashes=" + hashes + "]";
	}
	
	
}
