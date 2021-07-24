
import java.util.Date;

public class AccountOverdrawDemo implements Runnable{
	
	private Account account;
	
	public AccountOverdrawDemo(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i < 4 ; i++) {
			
			makeWithdraw(200);
			if(account.getBalance() < 0) {
				System.out.println("Remaining balance: "+account.getBalance()+ " OVERDRAWN!!!");
				break;
			}
		}
	}
	
	private   void   makeWithdraw(int withdrawAmount) {
		
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
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Account myAccount = new Account("jointAccount");
		AccountOverdrawDemo demoAccountOverdraw = new AccountOverdrawDemo(myAccount);
		
		Thread t1 = new Thread(demoAccountOverdraw);
		t1.setName("Riya");
		
		Thread t2 = new Thread(demoAccountOverdraw);
		t2.setName("John");
		
		t1.start();
		
		t2.start();
		
		
		
		
	}

	

}
