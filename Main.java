
public class Main {
	
	public static void main (String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Management management1= new Management(new ReadFile());
	
		String[] lines=management1.read("input.txt");
		management1.seperation(lines);
			
	}

}
