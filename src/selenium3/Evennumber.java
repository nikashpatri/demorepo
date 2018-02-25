package selenium3;

public class Evennumber {
	public static void main(String[] args)
	{
		int n=0;
		for(int i=1;i<=10;i++)
		{
			if(i%2==0)
			{
				n=i+n;
			}
		}
	System.out.println(n);
	}
}
