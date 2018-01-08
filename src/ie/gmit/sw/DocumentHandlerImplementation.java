package ie.gmit.sw;

import java.util.Set;

public class DocumentHandlerImplementation implements DocumentHandler{

	DataServicesImplementation ds = new DataServicesImplementation();
	private String title;
	private Set<Integer> hashes;
	
	public void setTitle(String title){
		this.title = title;
		System.out.println(title);
	}
	
	public void setHashes(Set<Integer> hashes){
		this.hashes = hashes;
		System.out.println(hashes);
		
		submit(title, hashes);
	}
	
	public void submit(String title, Set<Integer>hashes){
		System.out.println(title + hashes);
		
		//ds.storeBook(title, hashes);
		
	}

}
