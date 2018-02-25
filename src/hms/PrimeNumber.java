package hms;

public class PrimeNumber {

	public  static void printPrime(int n)
	{
		for(int i=2;i<=n;i++)
		{
			int k=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					k=1;
					break;
				}
			}
			if(k==0)
			{
				System.out.print(i+"  ");
			}
		}
	}
	public static void main(String[] args) {
		PrimeNumber.printPrime(40);
 
	}

}
