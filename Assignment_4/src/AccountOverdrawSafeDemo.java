
import java.util.Date;

public class AccountOverdrawSafeDemo implements Runnable{
	
	private Account account;
	
	public AccountOverdrawSafeDemo(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// Loop to show that a person withdraws the money from the account continuously
		for(int i = 0 ; i < 4 ; i++) {
			
			makeWithdraw(200);
			if(account.getBalance() < 0) {
				System.out.println("Remaining balance: "+account.getBalance()+ " OVERDRAWN!!!");
				break;
			}
		}
	}
	
	// To make the withdraw after checking the validity conditions
	private  synchronized void    makeWithdraw(int withdrawAmount) {
		
		
		// We can withdraw only if balance is higher or equal to the amount we want to withdraw
		// Use of date is done to show concurrent access to the same account by various persons 

		if(account.getBalance() >= withdrawAmount) {
			System.out.println(Thread.currentThread().getName()+" is going to withdraw "+withdrawAmount+"Rs current time ="+ new Date()  );
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.withdraw(withdrawAmount);
			System.out.println(Thread.currentThread().getName()+" completed the withdrawl of  "+withdrawAmount+"Rs your balance is "+account.getBalance() );
		}
		else {
			System.out.println("Insufficient Balance , your balance is "+account.getBalance());
		}
	}
	
	

	

}

