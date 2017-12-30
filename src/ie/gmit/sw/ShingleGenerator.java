package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

public class ShingleGenerator {

	public static final int CHAR_GRAM_LENGTH = 10;
	List<Integer> shingleA = new ArrayList<Integer>();
	
	
	public ShingleGenerator() {
		super();
	}


	public void generateShingle(String s){
		
		shingleA.add(s.hashCode());
		System.out.println(shingleA);
	}
}
