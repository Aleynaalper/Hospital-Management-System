import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Admission implements IDataAccessObject {
	public ArrayList<String> admissions= new ArrayList<String>();
	
	public void Read() {
		ReadFile a= new ReadFile();
		String[] b=a.readFile("admission.txt");
		for(int i=0; i<b.length; i++) {
			admissions.add(b[i]);
		}
	}
	

	//@Override
	public void Add(String admission) {
		int b=0;
		String[]index1= admission.split("	");
		int index2=Integer.parseInt(index1[0]);
		for(int i =0; i<admissions.size();i++) {
			String[] a = admissions.get(i).split("\t");
			if(a[0].length()<5) {
				if(Integer.valueOf(a[0])> index2) {
					admissions.add(i,admission);
					b=1;
					break;
					
				}	
			}
		}
		if(b==0) {
			admissions.add(admission);
		}
		

	}
	public String add2(String admission) {
		String[] a=admission.split(" ");
		String d=a[2]+"\t";
		for(int k=3;k<a.length;k++) {
			d+=a[k]+" ";
		}
		for(int i=0;i<admissions.size();i++) {
			String[] b=admissions.get(i).split("\t");
			if(b[0].equals(a[1])){
				for(int j=i+1; j<admissions.size();j++) {
					String[] c=admissions.get(j).split("\t");
					if(c[0].length()<5) {
					
						admissions.add(j,d);
						return " ";

					}
				}
				admissions.add(d);
				return " ";
				
			}
		}
		return " ";
	}
	

	//@Override
	public void Remove(String Id) {
		for(int i=0; i<admissions.size(); i++) {
			String[]index= admissions.get(i).split("\t");
			if(index[1].equals(Id)) {
				admissions.remove(admissions.get(i));
				for(int j=i;j<admissions.size();) {
					String[] index2=admissions.get(j).split("\t");
					if(index2[0].length()>5) {
						admissions.remove(admissions.get(j));
					}
					else {
						break;
						
						
					}
				}
			}	
		}
	}
	
	 public void writing(ArrayList<String> patientlist){
		    
		    File file = new File("admission.txt");
		    try(BufferedWriter a = new BufferedWriter(new FileWriter(file,false))){
		    	for(int i =0 ; i< admissions.size(); i++) {
		    	String b= admissions.get(i);
		        a.write(b);
		        a.newLine();
		    	}
		    	a.close();
		        
		    } catch (IOException e) {
		        System.out.println("Unable to read file " +file.toString());
		        
		    }
	  }
	
	
		
	}
	
	

