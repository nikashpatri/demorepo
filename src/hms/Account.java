package hms;

public class Account {

	private int balance;
	private String accounttype;

	public Account(int balance,String accounttype) {
		this.balance = balance;
		this.accounttype=accounttype;
	}

	void  withdraw(int amount) {
		if (balance >= amount){
			System.out.println("Collect your cash");
			balance = balance - amount;
			System.out.println("your new balance is: " + balance);}
		else
			System.out.println("Insufficient balance");
		
		
	}
}
