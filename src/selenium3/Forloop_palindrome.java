package selenium3;

public class Forloop_palindrome {
	
	public static void main(String[] args)
	{
		String word="nikash";
		String word2="";
		for(int i=word.length()-1;i>=0;i--)
		{
			 //System.out.println(word2);
		  word2=word2+word.charAt(i);
		  //System.out.println(word2);
		}
		if(word.equals(word2))
		{
			System.out.println("word is palindrome");
		}
		else
		{
			System.out.println("not a palindrome word");
		}
	}

}
