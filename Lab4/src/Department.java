
public abstract class Department {
	protected String departmentName;
	protected String departmentHead;
	protected int numOfEmployee;
	
	public Department() {
		departmentName = null;
		departmentHead = null;
		numOfEmployee = 0;
	}
	
	public Department(String dN, String dH, int numE) {
		departmentHead = dH;
		departmentName = dN;
		numOfEmployee = numE;
	}
	
	public String toString() {
		return "The head of the " + departmentName + " department is " + departmentHead + ", which has " + numOfEmployee + " employees."; 
	}
	abstract public String introduce();
}
