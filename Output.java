import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
	public static ArrayList<String> outputtxt= new ArrayList<String>();
	
	public void writing(String a) {
		outputtxt.add(a);
		
	}
	
	  public void writing(ArrayList<String> outputtxt){
		    
		    File file = new File("output.txt");
		    try(BufferedWriter a = new BufferedWriter(new FileWriter(file))){
		    	for(int i =0 ; i< outputtxt.size(); i++) {
		    	String b= outputtxt.get(i);
		        a.write(b);
		        a.newLine();
		    	}
		    	a.close();
		        
		    } catch (IOException e) {
		        System.out.println("Unable to read file " +file.toString());
		        
		    }
	  }
	
	

}
