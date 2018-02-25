package selenium3;

import java.util.Scanner;

public class Primenumber_Forloop {
	public static void main(String[] args)
	{
		int n,r,i;
		Scanner obj=new Scanner(System.in);
		System.out.println("enter the number");
		n=obj.nextInt();
		
		for( i=2;i<5;i++)
		{
			r=n%i;
			if(r==0)
			{
				break;
			}
		}
		if(i==n)
		{
		System.out.println("entered number is a prime number");
		}
		else
		{
			System.out.println("entered number is not a prime number");
		}
	}

}
