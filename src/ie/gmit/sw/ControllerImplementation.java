package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * The Class Controller.
 */
// Controller - Class that is responsible for all classes executing
public class ControllerImplementation implements Controller{
	
	/** The hasher. */
	// initializes instances of classes that are going to be used	
	HasherImplementation hasher = new HasherImplementation();
	
	/** Creates an instance of the ShingleGenerator for generating shingles. */
	ShingleGenerator sg = new ShingleGenerator();
	
	/** Creates an instance of the DataServicesImplementation for storing and getting books. */
	DataServicesImplementation ds = new DataServicesImplementation(); 
	
	/**  Creates an instance of the for calculating the similarity between documents. */
	JaccardImplementation jaccard = new JaccardImplementation();
	
	
	/** Creates an instance of the. */
	private ArrayList<String> words = new ArrayList<String>();
	
	/** The hashes. */
	private Set<Integer> hashes = new TreeSet<Integer>();
	
	/** The books. */
	private List<Book> books;
	
	/** The title. */
	private String title;
	
	/** The results. */
	private ArrayList<Double> results = new ArrayList<Double>();
	
	/** The list string. */
	private String listString = "";
	

	/**
	 * Sets the title.
	 *
	 * @param title the title
	 * @return the string
	 */
	// sets the title of the document being uploaded
	public String setTitle(String title){
		this.title = title;
		return title;
	}
	
	/**
	 * Generate shingles.
	 * Assigns the response to 'words'
	 * @param line 
	 */
	
	// passes in lines from the document and creates shingles
	public void generateShingles(String line){
		words = sg.generateShingle(line);
		
	}
	
	/**
	 * Min hasher.
	 */
	// gets the minHash of the words being passed in
	public void minHasher(){
		hashes = hasher.minHash(words);		
		submitDocument(); // executes the submit document method
	}
	
	/**
	 * Submit document.
	 */
	// submits a document to the database
	public void submitDocument(){
		ds.storeBook(title, hashes); // passes in the title of the document and the hashed shingles
		getLibrary(); // executes the getLibrary method
	}
	
	/**
	 * Gets the library.
	 * Gets a list of objects
	 * @return the library 
	 */
	public void getLibrary(){
		books = ds.getBooks(); // gets a list of book objects from the database
		jaccard.splitJaccard(books); // the books are split and compared against the most recently uploaded book
		results = jaccard.getJaccard(); // gets the results from comparing documents together
		setResults(results); // sets the results
		System.out.println(getResults());
	}
	
	/**
	 * Sets the results.
	 *
	 * @param res the new results
	 */
	public void setResults(ArrayList<Double> res){

		for(Double i : res){
			listString += i + "\t";
		}
	}
	
	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public String getResults(){
		return this.listString;
	}
	
}
