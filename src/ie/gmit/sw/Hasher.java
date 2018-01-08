package ie.gmit.sw;

import java.util.List;
import java.util.Set;

public interface Hasher {
	
	public Set<Integer> minHash(List<String> shingles);
	
}
