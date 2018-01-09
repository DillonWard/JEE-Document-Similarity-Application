package ie.gmit.sw;

public class ControllerProxy {
	
	ControllerImplementation cont = new ControllerImplementation();

	public void generateShingles(String line){
		cont.generateShingles(line);
		
	}

	public String getResults(){
		return cont.getResults();
	}
	
	public String setTitle(String title){
		return cont.setTitle(title);
	}
	
	public void minHasher(){
		cont.minHasher();
	}


}
