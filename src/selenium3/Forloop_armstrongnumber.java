package selenium3;

public class Forloop_armstrongnumber {

	public static void main(String[] args) {

		
		int x=153,r,y=0;
		int temp=x;
		while(x!=0)
		{
			int a=x%10;
			r=a*a*a;
			y=y+r;
			x=x/10;
		}
		System.out.println(y);
		if(temp==y)
		{
			System.out.println("armstrong number");
		}
		else
		{
			System.out.println("not an armstrong number");
		}
	
	}

}
