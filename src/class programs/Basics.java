package webdriver;

public class Basics {
	
	private String str;
	protected String str1;
	 		String str2;
	public String str3;
	
	public void sample1(){
		 str="Nagesh"; //Local declaration
		System.out.println("Welcome :"+str);
	}
	public void sample2(){
		 str="Rajesh";
		System.out.println("Welcome :"+str);
	}
	public void sample3(){
		 str="Suresh";
		System.out.println("Welcome :"+str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basics b=new Basics();
		b.sample1();
		b.sample2();
		b.sample3();

	}

}
