
public class CheckingAccount extends BankAccount {
	private double interestRate;

	public CheckingAccount() {
		super(0,null,0);
		interestRate =0;
	}
	public CheckingAccount(int newAccNum, String newAccName, double newAccBal, double intRate) {
		super(newAccNum, newAccName, newAccBal);
		interestRate = intRate;
	}

	public String toString() {
		return super.toString() + "\nInterest Rate: " + interestRate;
	}
}
