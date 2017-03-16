
public class FinanceDepartment extends Department {
	protected double profit;
		
	public FinanceDepartment(String dH, int numE, double newProfit) {
		super("Finance", dH, numE);
		profit = newProfit;		
	}
	
	public String toString() {
		return super.toString() + "The profit made last year was: " + profit;
	}
	public String introduce() {
		return super.toString() + " " + this.toString();
	}
}
