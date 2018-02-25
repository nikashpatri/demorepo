package hms;

public class StringReverse {
	
	public static void reverse(String str1)
	{
		String str2="";
		char[] ch=str1.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			str2=str2+ch[i];
		}
		System.out.println(str2);
		if(str1.equals(str2))
		{
			System.out.println(str1+"  is palindrome");
		}
		else
		{
			System.out.println(str1+"  is not palindrome");
		}
	}

	public static void main(String[] args) {
		
   reverse("nikashpatri");
	}

}
