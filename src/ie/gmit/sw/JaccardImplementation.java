package ie.gmit.sw;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jdt.internal.compiler.ast.IntersectionCastTypeReference;

public class JaccardImplementation {
	
	private double jaccardIndex;
	private int intersection;
	private int union;
	private Set<Integer> indexA = new TreeSet<Integer>();
	private Set<Integer> indexB = new TreeSet<Integer>();
	private Set<Integer> n;
	
	public void splitJaccard(List<Book> library){
		
		final int len = library.size() - 1;

		indexA = library.get(len).getHashes();
		
		for(int i = 0; i < len; i++){
			
			indexB = library.get(i).getHashes();
			compareJaccard(indexA, indexB);
			
		}		
	}
	
	private void compareJaccard(Set<Integer> a, Set<Integer> b) {
		
		Set<Integer> n = new TreeSet<Integer>(a);
		union = a.size() + b.size();
		
		n = new TreeSet<Integer>(a);
		
		n.retainAll(b);
		
		intersection = n.size();
		
		jaccardIndex =  Double.valueOf(intersection) / (Double.valueOf(union) - Double.valueOf(intersection));
		jaccardIndex = jaccardIndex * 100;
		System.out.println(String.format("%.3f", jaccardIndex));
	}

	public double getJaccard(){
		
		return this.jaccardIndex;
	}
}
