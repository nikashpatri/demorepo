package selenium3;

public class test2 {

	public static void main(String[] args) {
		String str1="abc";
		String str2="abc";
		System.out.println(("str1=str2"+str1).intern()=="str1=str2abc");
		

	}

}
