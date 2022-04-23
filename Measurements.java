
public class Measurements extends ExaminationDecorator {
	private int cost=5;
	private IPatientTypes examination;

	public Measurements(IPatientTypes examination) {
		this.examination=examination;
	}
	
	public Measurements() {
		
	}

	@Override
	public void addoperation(IPatientTypes examination) {
		this.examination=examination;

	}

	@Override
	public String printoperation() {
		
		if (examination==null) {
			return "measurements";
		}
		else {
			return "measurements"+" "+examination.printoperation();
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
