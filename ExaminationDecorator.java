
public abstract class ExaminationDecorator implements IPatientTypes {
	
	public abstract void addoperation(IPatientTypes examination);
	
	public abstract String printoperation();
	
	public abstract int cost();
	
	
	
}