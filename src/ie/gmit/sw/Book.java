package ie.gmit.sw;

import java.util.Set;
import java.util.TreeSet;

public class Book {
	
	private String name;
	private String conts;
	private Set<Integer> hashes = new TreeSet<Integer>();
	
	
	public Book(String name, Set<Integer> hashes){
		this.name = name;
		this.hashes = hashes;

	}

}
