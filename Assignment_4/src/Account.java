
public class Account {

	private String name;
	private int balance;
	
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
	
	public void withdraw(int amount) {
		
		balance = balance - amount;
	}
}
