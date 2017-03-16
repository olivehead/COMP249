
public class Driver {

	public static void main(String[] args) {
		Department[] dp1 = new Department[2];
		dp1[0] = new FinanceDepartment("Bob", 3, 10000.00);
		dp1[1] = new HRDepartment("Frank", 5, 3, "George");
		for(int i=0;i<2;i++) {
		System.out.println(dp1[i]);
		}
		
	}

}
