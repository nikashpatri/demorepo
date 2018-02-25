package hms;

import java.util.Scanner;

public class Customer implements Runnable {
	Account account;
	private String name;
	private int acno;
	
	public Customer(String name,int acno,Account account)
	{
		this.name=name;
		this.acno=acno;
		this.account=account;
	}

	public void run() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the ammount");
		int amount=scan.nextInt();
		account.withdraw(amount);
	}
	

}
