package hms;

import java.util.Scanner;

public class ExceptionHandle {
	static double balance;
	static int count;
	public static void takeInput() throws InsufficientBalanceException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount: ");
	    balance= sc.nextDouble();
	    withdraw();
	    }
	
	public static void withdraw() throws InsufficientBalanceException
	{
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount: ");
		 balance= sc.nextDouble();*/
		if(balance<=1000)
		{
			throw new InsufficientBalanceException("Please enter the currect amount"); 
		}
		else {
			System.out.println("wait while your trasaction is under process...");
			
		}
	}

	public static void main(String[] args)
	{
		while(balance<=1000){
		try {
			takeInput();	
		}
		catch (InsufficientBalanceException e) {
			
			System.out.println("Exception occured: "+e.getMessage());
		    
		}
		}
		

	}

}
