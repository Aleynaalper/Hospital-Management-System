import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Patient implements IDataAccessObject {
	
	public static ArrayList<String> patientlist= new ArrayList<String>();
	
	public void Read() {
		ReadFile a= new ReadFile();
		String[] b=a.readFile("patient.txt");
		for(int i=0; i<b.length; i++) {
			patientlist.add(b[i]);
		}
		
	}

	//@Override
	public void Add(String patient) {
		boolean a= true;
		String[] array=patient.split("\t");
		for(int i = 0 ;i<patientlist.size(); i++) {
			String[] array2=patientlist.get(i).split("\t");
			if(Integer.valueOf(array[0])<Integer.valueOf(array2[0])) {
				patientlist.add(i,patient);
				a=false;
				i=patientlist.size();
			}
		}
		if(a) {
		patientlist.add(patient);
		}

		
	}

	//@Override
	public void Remove(String Id) {
		for(int i=0;i<patientlist.size();i++) {
			String[] control=patientlist.get(i).split("	");
			if( control[0].equals(Id)) {
			patientlist.remove(patientlist.get(i));
			}	
		}
	}
	
	public String Finding(String Id) {
		String name;
		for(int i=0; i<patientlist.size(); i++) {
			String[] control=patientlist.get(i).split("	");
			if( control[0].equals(Id)){
				String[] control2=control[1].split("\\s");
				name=control2[0];
				return name;
			}	
		}
		return null;
	}
	
	
	  public void writing(ArrayList<String> patientlist){
		    
		    File file = new File("patient.txt");
		    try(BufferedWriter a = new BufferedWriter(new FileWriter(file,false))){
		    	for(int i =0 ; i< patientlist.size(); i++) {
		    	String b= patientlist.get(i);
		        a.write(b);
		        a.newLine();
		    	}
		    	a.close();
		        
		    } catch (IOException e) {
		        System.out.println("Unable to read file " +file.toString());
		        
		    }
	  }
	  
	  
	  public String[] sorting() {
		  String[] patients= new String[patientlist.size()];
		  
		  for(int i=0; i<patientlist.size(); i++) {
			  patients[i]=patientlist.get(i);
			 
		    }
		  for(int j=0;j<patients.length;j++) {
			  for(int k=j+1;k<patients.length;k++) {
				  String[] patients2= patients[j].split("\t")[1].split(" ");
				  String[] patients3= patients[k].split("\t")[1].split(" ");
				  
				  if(patients2[0].compareTo(patients3[0])>0) {
					  String a=patients[j];
					  patients[j]=patients[k];
					  patients[k]=a;  
				  }

			  }
			 
			  }
		  return patients;
	
		  }
		  
	  }


