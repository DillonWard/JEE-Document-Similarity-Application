package ie.gmit.sw;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ComputeJaccard {

	
	public void checkJaccard(Set<Integer> library, Set<Integer> book){
		
		Set<Integer> libraryMinHash = new TreeSet<Integer>();
		Set<Integer> bookMinHash = new TreeSet<Integer>();
		
		Iterator<Integer> libIterator = library.iterator();
		Iterator<Integer> bookIterator = book.iterator();

		//Create the set of hash integers as random numbers
		Set<Integer> hashes = new TreeSet<Integer>();
		int k = 200;
		
		Random r = new Random();
		for (int i = 0; i < k; i++){ //Create k random integers
		 hashes.add(r.nextInt());
		}
		
		for(Integer hash: hashes){
			int min = Integer.MAX_VALUE;
			
			while(libIterator.hasNext()){
				int minHash = libIterator.next() ^ hash;
				if(minHash < min) min = minHash;

			}				
			libraryMinHash.add(min);

		}
		System.out.println(libraryMinHash);

		
		for(Integer hash: hashes){
			int min = Integer.MAX_VALUE;
			
			while(bookIterator.hasNext()){
				int minHash = bookIterator.next() ^ hash;
				
				if(minHash < min) min = minHash;

			}
			bookMinHash.add(min);

		}
		System.out.println(bookMinHash);

	}
}
