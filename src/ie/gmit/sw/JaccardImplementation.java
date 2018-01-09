package ie.gmit.sw;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class JaccardImplementation {
	private double intersection;


	public void compareJaccard(List<Book> library) {
		final int len = library.size() - 1;

		Set<Integer> a = library.get(len).getHashes();
		Set<Integer> b = new TreeSet<Integer>();
		Set<Integer> n = new TreeSet<Integer>(a);

		for (int i = 0; i < len; i++) {

			b = library.get(i).getHashes();
			System.out.println(a.size());
			System.out.println(b.size());
			
			n.retainAll(b);

			intersection = n.size() / (a.size() + b.size() - n.size());
			System.out.println(intersection);
		}

	}

}
