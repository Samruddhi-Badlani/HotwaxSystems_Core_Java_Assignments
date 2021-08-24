
public class Account {

	private String name; // name of the account holder
	private int balance; // amount of money the account contains
	
	public Account(String name) {
		// TODO Auto-generated constructor stub
		
		this.balance = 1000;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	
	// To withdraw the money from the account
	public void withdraw(int amount) {
		
		balance = balance - amount;
	}
}
