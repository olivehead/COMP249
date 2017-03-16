
public class HRDepartment extends Department {
	protected int numOfTrainees;
	protected String nameOfTrainees;

	public HRDepartment() {
		super();
		numOfTrainees = 0;
		nameOfTrainees = null;
	}
	public HRDepartment(String dH, int numE, int numT, String nameT) {
		super("Human Resource", dH, numE);
		numOfTrainees = numT;
		nameOfTrainees = nameT;
	}
	
	public String toString() {
		return super.toString() + "There are " + numOfTrainees + " trainees who's names are the following: " + nameOfTrainees;
	}

	public String introduce() {
		return super.departmentHead + " is the head of the " + super.departmentName + " " + toString();
	}
}
