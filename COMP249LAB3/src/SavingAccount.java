
public class SavingAccount extends BankAccount {
	private int maxTransFree;
	private int transactionFee;

	public SavingAccount() {
		super(0, null, 0);
		maxTransFree = 3;
		transactionFee = 2;
	}

	public SavingAccount(int accNum, String accName, double accBal) {
		super(accNum, accName, accBal);
		maxTransFree = 3;
		transactionFee = 2;
	}

	public String toString() {
		return super.toString() + "\nMaximum Free Transaction : " + maxTransFree + "\nTransaction Fee: " + transactionFee;
	}

}
