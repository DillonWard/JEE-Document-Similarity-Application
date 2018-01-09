package ie.gmit.sw;

import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface Hasher.
 */
public interface Hasher {
	
	/**
	 * Min hash.
	 *
	 * @param shingles the shingles
	 * @return the sets the
	 */
	public Set<Integer> minHash(List<String> shingles);
	
}
