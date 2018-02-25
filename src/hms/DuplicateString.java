package hms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateString {
	
	public void removeDuplicate(String str)
	{
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
			System.out.println(c+"  "+m.get(c));
		}
		
	}

	public static void main(String[] args) {
		DuplicateString obj=new DuplicateString();
				obj.removeDuplicate("java");

	}

}
