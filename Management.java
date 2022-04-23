
public class Management {
	private IDataAccessObject object1;
	private IReadFile object2;
	Patient a1= new Patient();
	Admission a2=new Admission();
	Output a3=new Output();
	
	public Management(IDataAccessObject object1) {
		this.object1=object1;
	
	}
	
	public Management( IReadFile object2) {
		this.object2=object2;
	}
	
	public String[] read(String path) {
		return object2.readFile(path);
	}
		
	public void seperation (String[] lines) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		a1.Read();
		a2.Read();
		for(int i=0;i<lines.length;i++) {
			String[] a= lines[i].split("\\s"); 
			if(a[0].equals("AddPatient")) {
				String patient=a[1]+"	"+a[2]+" "+a[3]+"	"+a[4]+"	Address: "+a[5]+" "+a[6]+" "+a[7];
				a1.Add(patient);
				String situation="Patient "+a[1]+" "+a[2]+" added";
				a3.writing(situation);
			}
			
			else if(a[0].equals("RemovePatient")) {
				String Id=a[1];
				String situation="Patient "+a[1]+" "+a1.Finding(Id)+" removed";
				a3.writing(situation);
				a1.Remove(Id);
				a2.Remove(Id);
			}
			
			else if(a[0].equals("CreateAdmission")) {
				String admission=a[1]+"	"+a[2];
				a2.Add(admission);
				a3.writing("Admission "+a[1]+" created");
				
			}
			
			
			else if(a[0].equals("AddExamination")){
				a2.add2(lines[i]);
				a3.writing(a[2]+" examination added to admission "+a[1]);
				
			}

			else if(a[0].equals("TotalCost")) {
				int totalcost=0;
				a3.writing("TotalCost for admission "+a[1]);
				for(int j=0; j<a2.admissions.size();j++) {
					String[] line1=a2.admissions.get(j).split("	");
					if(a[1].equals(line1[0])) {
						for(int k=j+1; k<a2.admissions.size(); k++) {
							String[] line2=a2.admissions.get(k).split("	");
							if(line2[0].length()>4) {
								String[] line3=line2[1].split("\\s");
								if(line2[0].equals("Inpatient")) {
									String x;
									String y;
									String z;
									if(line3.length==3) {
										IPatientTypes inpatient=new Inpatient();
										if(line3[0].substring(0,1).equals("i")) {
											x="I"+ line3[0].substring(1);;
									
											y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
											z=line3[2].substring(0,1).toUpperCase()+ line3[2].substring(1);;
										}
										else if(line3[1].substring(0,1).equals("i")) {
											y="I"+ line3[0].substring(1);;
										
											x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;										
											z=line3[2].substring(0,1).toUpperCase()+ line3[2].substring(1);;
										}
										else if(line3[2].substring(0,1).equals("i")) {
											z="I"+ line3[0].substring(1);;

											x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
											y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										}
							
										else {
										x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
										y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										z=line3[2].substring(0,1).toUpperCase()+ line3[2].substring(1);;
										}

										IPatientTypes p=((IPatientTypes) Class.forName(x).newInstance());
										IPatientTypes pp=((IPatientTypes) Class.forName(y).newInstance());
										IPatientTypes ppp=((IPatientTypes) Class.forName(z).newInstance());
										
										pp.addoperation(ppp);
										p.addoperation(pp);
										inpatient.addoperation(p);
										totalcost+=inpatient.cost();
										String output="        "+inpatient.printoperation()+" "+inpatient.cost()+"$";
										a3.writing(output);
											
									}
											
									else if(line3.length==2) {
										IPatientTypes inpatient=new Inpatient();
										if(line3[0].substring(0,1).equals("i")) {
											x="I"+ line3[0].substring(1);;
									
											y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										}
										else {
										x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
										y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										}
										IPatientTypes p=((IPatientTypes) Class.forName(x).newInstance());
										IPatientTypes pp=((IPatientTypes) Class.forName(y).newInstance());
										
										p.addoperation(pp);
										inpatient.addoperation(p);
										totalcost+=inpatient.cost();
										String output="        "+inpatient.printoperation()+" "+inpatient.cost()+"$";
										a3.writing(output);
										
								
										
									}
										
									else if(line3.length==1) {
										IPatientTypes inpatient=new Inpatient();
										if(line3[0].substring(0,1).equals("i")) {
											x="I"+ line3[0].substring(1);;
										}
										else {
											x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);
										}
										IPatientTypes p=((IPatientTypes) Class.forName(x).newInstance());
										
										
										inpatient.addoperation(p);
										totalcost+=inpatient.cost();
										String output="        "+inpatient.printoperation()+" "+inpatient.cost()+"$";
										a3.writing(output);
										
									}
										
									else {
										IPatientTypes inpatient=new Inpatient();
										totalcost+=inpatient.cost();
										String output="        "+inpatient.printoperation()+" "+inpatient.cost()+"$";
										a3.writing(output);
										
									}
								}
								else if(line2[0].equals("Outpatient")) {
									String x;
									String y;
									String z;
									if(line3.length==3) {
										IPatientTypes outpatient=new Outpatient();
										if(line3[0].substring(0,1).equals("i")) {
											x="I"+ line3[0].substring(1);;
									
											y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
											z=line3[2].substring(0,1).toUpperCase()+ line3[2].substring(1);;
										}
										else if(line3[1].substring(0,1).equals("i")) {
											y="I"+ line3[0].substring(1);;
										
											x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;										
											z=line3[2].substring(0,1).toUpperCase()+ line3[2].substring(1);;
										}
										else if(line3[2].substring(0,1).equals("i")) {
											z="I"+ line3[0].substring(1);;

											x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
											y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										}
							
										else {
										x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
										y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										z=line3[2].substring(0,1).toUpperCase()+ line3[2].substring(1);;
										}

										IPatientTypes p=((IPatientTypes) Class.forName(x).newInstance());
										IPatientTypes pp=((IPatientTypes) Class.forName(y).newInstance());
										IPatientTypes ppp=((IPatientTypes) Class.forName(z).newInstance());
										
										pp.addoperation(ppp);
										p.addoperation(pp);
										outpatient.addoperation(p);
										totalcost+=outpatient.cost();
										String output="        "+outpatient.printoperation()+" "+outpatient.cost()+"$";
										a3.writing(output);
											
									}
											
									else if(line3.length==2) {
										IPatientTypes outpatient=new Outpatient();
										if(line3[0].substring(0,1).equals("i")) {
											x="I"+ line3[0].substring(1);;
									
											y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										}
										else if(line3[1].substring(0,1).equals("i")) {
											y="I"+ line3[0].substring(1);;
										
											x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
										}
										else {
										x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
										y=line3[1].substring(0,1).toUpperCase()+ line3[1].substring(1);;
										}
										IPatientTypes p=((IPatientTypes) Class.forName(x).newInstance());
										IPatientTypes pp=((IPatientTypes) Class.forName(y).newInstance());
										
										p.addoperation(pp);
										outpatient.addoperation(p);
										totalcost+=outpatient.cost();
										String output="        "+outpatient.printoperation()+" "+outpatient.cost()+"$";
										a3.writing(output);
										
								
										
									}
										
									else if(line3.length==1) {
										IPatientTypes outpatient=new Outpatient();
										if(line3[0].substring(0,1).equals("i")) {
											x="I"+ line3[0].substring(1);;
										}
										else {
										x=line3[0].substring(0,1).toUpperCase()+ line3[0].substring(1);;
										}

										IPatientTypes p=((IPatientTypes) Class.forName(x).newInstance());
										
										outpatient.addoperation(p);
										totalcost+=outpatient.cost();
										String output="        "+outpatient.printoperation()+" "+outpatient.cost()+"$";
										a3.writing(output);
										
									}
										
									else {
										IPatientTypes outpatient=new Outpatient();
										totalcost+=outpatient.cost();
										String output="        "+outpatient.printoperation()+" "+outpatient.cost()+"$";
										a3.writing(output);
										
									}
								}
								
							}
							else {
								break;
							}
						}	
					}
				
					
				}
				
				
			a3.writing("        "+"Total: "+totalcost+"$");	
			}
			else if(a[0].equals("ListPatients")) {
				a3.writing("Patient List:");
				String[] list=a1.sorting();
				for(int m=0; m< list.length;m++) {
					a3.writing(list[m].replace("\t", " "));
				}
				
			}
		
	}
		a1.writing(Patient.patientlist);
		a2.writing(a2.admissions);
		a3.writing(Output.outputtxt);
		
	
		
		
	}

}
