package selenium3;

public class Palindrome_String {

	public static void main(String[] args) {
		
	String str="patri";
	String str1="";
	for(int i=str.length()-1;i>=0;i--)
	{
	  System.out.println(str.charAt(i));
	  str1=str1+str.charAt(i);
	  if(str.equals(str1))
	  {
		  System.out.println("palindrome");
	  }
	}

	}

}
