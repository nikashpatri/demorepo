package corejavaBasics;

public class BasicProgram {
	private String str;
	//public String str;
	public void sample1(){
		//String str=null; //Local Declaration
		str = "Mahesh"; // Assigning the value
		System.out.println("Welcome "+str);	
	}
	public void sample2(){
		//String str1="Rajesh";
		str="Rajesh";
		System.out.println("Welcome "+str);	
	}
	public void sample3(){
		//String str2="Suresh";
		str="Suresh";
		System.out.println("Welcome "+str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicProgram b=new BasicProgram(); //instance or Object
		b.sample1();
		b.sample2();
		b.sample3();

	}

}







