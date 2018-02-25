package hms;

import java.util.Scanner;

public class StringPalindrome {
	
	public static void reverseString(String str1)
	{
		String str2="";
		char[] ch=str1.toCharArray();
		for (int i = ch.length-1; i>=0; i--) {
			
			str2=str2+ch[i];
		}
		System.out.println("Reverse string is "+str2);
		if(str2.equals(str1))
		{
			System.out.println(str1+": String is palindrome");
		}
		else {
			System.out.println(str1+": String is not palindrome");
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str1= sc.nextLine();
		reverseString(str1);		
	}

}
