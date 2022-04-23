
public class Doctorvisit extends ExaminationDecorator {
	private int cost=15;
	private IPatientTypes examination;

	public Doctorvisit(IPatientTypes examination) {
		this.examination=examination;
	}
	
	public Doctorvisit() {
		
	}

	@Override
	public void addoperation(IPatientTypes examination) {
		this.examination=examination;

	}

	@Override
	public String printoperation() {
		
		if (examination==null) {
			return "doctorvisit";
		}
		else {
			return "doctorvisit"+" "+examination.printoperation();
		}

	}

	@Override
	public int cost() {
		if (examination==null) {
			return cost;
		}
		else {
			return cost+ examination.cost();
		}

	}
}
