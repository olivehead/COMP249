
public class Driver {
	public static void main (String[] args) {
		BankAccount[] ba1 = new BankAccount[2];
		ba1[1] = new SavingAccount();
		ba1[0] = new CheckingAccount();
		for(int i=0;i<2;i++) {
			System.out.println(ba1[i]);
		}
		
		
	}
}
