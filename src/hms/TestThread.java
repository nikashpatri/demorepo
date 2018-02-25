package hms;

public class TestThread {

	public static void main(String[] args) {
		Account account1 = new Account(2000,"SavingsAccount");
		Customer c1 = new Customer("Nikash", 1234, account1);
		Customer c2 = new Customer("rashmi", 1234, account1);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}

}
