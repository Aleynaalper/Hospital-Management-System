
public class Imaging extends ExaminationDecorator {
	private int cost=10;
	private IPatientTypes examination;


	public Imaging(IPatientTypes examination) {
		this.examination=examination;
	}
	
	public Imaging() {
		
	}

	@Override
	public void addoperation(IPatientTypes examination) {
		this.examination=examination;

	}

	@Override
	public String printoperation() {
		
		if (examination==null) {
			return "imaging";
		}
		else {
			return "imaging"+" "+examination.printoperation();

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