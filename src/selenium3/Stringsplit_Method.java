package selenium3;

public class Stringsplit_Method {
	
	public void m1()
	{
		String str3="";
		String str="i like selenium";
		String str2=null;
		String[] str1=str.split(" ");//converting a string to string array.
		for(int i=0;i<str1.length;i++)
		{
			//System.out.println(str1[i]);
			if(str1[i].equals("selenium"))
			{
				//System.out.println("selenium");
				str2=str1[i];
				System.out.println(str2);
				for(int j=str2.length()-1;j>=0;j--)
				{
					str3=str3+str2.charAt(j);
					//System.out.println(str3);
				}
				System.out.println(str3);
		    }
		}
	}
	public void m2()
	{
		String str2="";
		String str="one,two,three,four";
		String[] str1=str.split(",");
		for(int i=0;i<str1.length;i++)
		{
			if(str1[i].contains("o"))
			{
			    str2=str1[i];
			    System.out.println(str2);
			}
		}
	}
	 
	public static void main(String[] args)
	{
		 Stringsplit_Method obj=new  Stringsplit_Method();
		 obj.m1();
		 //obj.m2();
		
		  
	}

}
