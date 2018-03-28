package model;

public class Bank {

	private int id;
	private String accountName;
	private String accountNumber;
	private double balance;
	
	public Bank(){
		super();
	}
	public Bank(int id, String accountName, String accountNumber, double balance) {
		this.id = id;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	
}
