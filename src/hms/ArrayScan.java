package hms;

import java.util.Scanner;

public class ArrayScan {
	 
	public static void findBiggestno()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int arraysize=sc.nextInt();
		int[] x=new int[arraysize];
		for(int i=0;i<arraysize;i++)
		{
			System.out.println("enter the value of "+i+" index");
			x[i]=sc.nextInt();
		}
		int b1=0;
		int b2=0;
		for (int i = 0; i < x.length; i++) {
			
			if(b1<x[i])
			{
				b2=b1;
				b1=x[i];
			}
			else if(b2<x[i])
			{
				b2=x[i];
			}
		}
		System.out.println("First Biggest No is "+b1);
		System.out.println("Second Biggest No is "+b2);
	}

	public static void main(String[] args) {
		
     ArrayScan.findBiggestno();
	}

}
