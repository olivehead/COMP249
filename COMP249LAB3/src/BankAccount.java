
public class BankAccount {
	private int accountNumber;
	private String accountName;
	private double accountBalance;

	public BankAccount() {
		accountBalance = 0;
		accountName = null;
		accountNumber = 0;
	}

	public BankAccount(int accNum, String accName, double accBal) {
		accountNumber = accNum;
		accountName = accName;
		accountBalance = accBal;
	}

	public String toString() {
		return "Account Number: " + accountNumber + "\nAccount Name: " + accountName + "\nAccount Balance: "
				+ accountBalance;
	}
}
