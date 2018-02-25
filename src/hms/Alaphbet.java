package hms;

import java.util.Scanner;

public class Alaphbet {
	
	public  static void  printNumber()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the 1st alphabet");
		String str1=sc.nextLine();
		char ch1=str1.charAt(0);
		int x=ch1;//implicit type casting
		//System.out.println(x);
		System.out.println("Enter the 2nd alphabet");
		String str2=sc.nextLine();
		char ch2=str2.charAt(0);
		int y=ch2;//implicit type casting
		//System.out.println(y);
		System.out.println();
		for(int i=x;i<=y;i++)
		{
			if(i%2==0)
			{
				char ch3=(char)i;//Explicit type casting
				System.out.println(ch3+" "+i);
			}
		}
		
	}

	public static void main(String[] args) {
		
     printNumber();
	}

}
