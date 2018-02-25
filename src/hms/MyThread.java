package hms;

import java.util.Scanner;

public class MyThread extends Thread {
	static String[] stringArray;

	public void produce() {
		stringArray = new String[5];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = scan.next();
		}

	}

	public void run() {
		synchronized (this) {
			produce();
			this.notify();
		}
	}

}
