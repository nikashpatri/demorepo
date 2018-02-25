package hms;

import java.util.Scanner;

public class input {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i <= 2; i++) {
			System.out.print("enter a String And an integer");
			String str1=scan.nextLine();
			int n=scan.nextInt();
			scan.nextLine();
			System.out.println(str1+"..."+n);
		}

	}

}
