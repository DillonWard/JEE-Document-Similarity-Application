package ie.gmit.sw;

import java.util.List;

public interface Jaccard {
	public void compareJaccard(List<Book> library);
	public void splitJaccard(List<Book> library);
	public double getJaccard();
}
