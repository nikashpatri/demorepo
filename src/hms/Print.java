package hms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.sl.draw.geom.SqrtExpression;
import java.lang.Math;
public class Print {

	public static void main(String[] args) {
		int sum=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("enter total item");
       
        int a=sc.nextInt();
        List<String> str=new ArrayList<String>();
        int[] y=new int[a];
        for(int i=0;i<a;i++)
        {
           System.out.println("enter the name of item"+" "+i);
          String str1=sc.nextLine();
           str.add(str1);
        }
           for (int k = 0; k < a; k++)
           {
        	   System.out.println("enter the price of item"+" "+k);
               y[k]=sc.nextInt();
		   }
        
        for(int j=0;j<a;j++)
        {
            System.out.println("price of "+str.get(j)+"is "+y[j]);
            sum=sum+y[j];
        }
        System.out.println("Total price:"+sum);
	}

}
