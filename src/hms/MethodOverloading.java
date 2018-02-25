package hms;

public class MethodOverloading {
	
	public void displayResult(int x,int y)
	{
		int result=x+y;
		System.out.println(result);
	}
	
	public void displayResult(int x,float y)
	{
		float Result=x*y;
		System.out.println(Result);
	}

	public static void main(String[] args) {
		
		
		MethodOverloading obj=new MethodOverloading();
		obj.displayResult(10,20.5f);
	}

}
