package ie.gmit.sw;

import java.util.List;
import java.util.Set;

public interface Shingle {

	public void generateShingle(String line);
	public Set<Integer> minHash(List<String> shingles);
}
