
public class Inpatient implements IPatientTypes {
	private IPatientTypes examination;
	private int cost=10;
	
	public int cost() {
		if(examination==null) {
			return cost;
		}
		else {
		return cost+examination.cost();
		}
		
	}
	public void addoperation(IPatientTypes examination) {
		this.examination=examination;
		
	}
	
	public String printoperation() {
		if(examination==null) {
			return "Inpatient";
		}
		else {
			return "Inpatient"+" "+examination.printoperation();
		}

		
	}
}