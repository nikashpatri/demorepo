package selenium3;

import java.util.Scanner;

public class Table_Forloop {
	public static void main(String[] args)
	{
		int r=0,input;
		Scanner obj=new Scanner(System.in);
		System.out.println("enter the number");
		input=obj.nextInt();
		for(int i=1;i<=10;i++)
		{
			r=input*i;
			System.out.println(input+"*"+i+"="+r);
		}
	}

}
