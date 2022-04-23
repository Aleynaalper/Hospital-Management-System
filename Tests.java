
public class Tests extends ExaminationDecorator {
	private int cost=7;
	private IPatientTypes examination;

	public Tests(IPatientTypes examination) {
		this.examination=examination;
	}
	
	public Tests() {
		
	}

	@Override
	public void addoperation(IPatientTypes examination) {
		this.examination=examination;

	}

	@Override
	public String printoperation() {
		
		if (examination==null) {
			return "tests";
		}
		else {
			return "tests"+" "+examination.printoperation();

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
