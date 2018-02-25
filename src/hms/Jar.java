package hms;

import java.util.ArrayList;
import java.util.Scanner;

public class Jar {
  static int jarweight;
  static int minjarweight;
  static int maxjarweight;
  static int count;
  static String name;
  static ArrayList<Marble> l1;
  static ArrayList l2;
  
  
 public static void main(String[] args) {
	  
for(int j=1;j<=5;j++)
{
	for (int i = 1; i <=5; i++)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the weight: ");
		int weight=sc.nextInt();
		Marble marble=new Marble(weight);
		l1.add(marble);
	}
	l2.add(l1);
}

for (int i = 0; i < l2.size(); i++) 
{
	for (int j = 0; j <((ArrayList) l2.get(i)).size(); j++) 
	{
		Marble m=(Marble) l1.get(j);
		m.findweight();
		jarweight=jarweight+m.findweight();
	}
	if(jarweight>maxjarweight)
	{
		minjarweight=maxjarweight;
		maxjarweight=jarweight;
	}
	else if(jarweight>minjarweight)
	{
		minjarweight=jarweight;
	}

}
System.out.println("minjarweight is :"+minjarweight);


}
}