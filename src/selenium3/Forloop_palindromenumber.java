package selenium3;

public class Forloop_palindromenumber {

	public static void main(String[] args) {
		
		int x=123,y=0,r=0;
		int temp=x;
		while(x!=0)
		{
			r=x%10;
			y=y*10+r;
			x=x/10;	
		}
		System.out.println(y);
		
		if(temp==y)
		{
			System.out.println("is a palindrome number");
		}
		else {
			System.out.println("is not a palindrome number");
		}
	}


}
