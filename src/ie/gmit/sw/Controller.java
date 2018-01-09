package ie.gmit.sw;

import java.util.ArrayList;

public interface Controller {
	public String setTitle(String title);
	public void generateShingles(String line);
	public void minHasher();
	public void submitDocument();
	public void getLibrary();
	public void setResults(ArrayList<Double> res);
	public String getResults();
}
