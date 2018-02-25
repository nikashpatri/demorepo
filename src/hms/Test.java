package hms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void suppressString(String str) {
		ArrayList<String>l=new ArrayList<String>();
		Map<Character,Integer> m=new HashMap<Character,Integer>();
		char[] ch=str.toCharArray();
		for(char c:ch)
		{
			if(m.containsKey(c))
			{
				m.put(c, m.get(c)+1);
			}
			else
			{
				m.put(c, 1);
			}
		}
		Set<Character> s=m.keySet();
		for(char c:s)
		{
			
			System.out.print(c+""+m.get(c));
		}
       /*Iterator<Character>itr=s.iterator();
       while(itr.hasNext())
       {
    	   System.out.print(itr.next()+""+m.get(itr.next()));
       }*/
	}

	public static void main(String[] args) {
		
      suppressString("aaabbddggg");
	}

}
