package hms;

import java.util.HashSet;
import java.util.Set;

public class PalindromeInSubstring {

	public static void scanPalindrome(String str1) {
		String str2 = "";
		Set<String> s = new HashSet<String>();
		char[] ch = str1.toCharArray();
		for (int i = 0; i < ch.length - 1; i++) {
			for (int j = 2; j <= ch.length - 1; j++) {
				try {
					str2 = str1.substring(i, j + i);
				} 
				catch (Exception e) {
					str2 = str1.substring(i);
					StringBuilder str3 = new StringBuilder(str2);
					String str4 = str3.reverse().toString();
					if (str2.equals(str4)) {

						s.add(str2);
					}

					break;

				}

				StringBuilder str3 = new StringBuilder(str2);
				String str4 = str3.reverse().toString();
				if (str2.equals(str4)) {

					s.add(str2);
				}

			}
		}
		if (!s.isEmpty()) {
			System.out.println("Palindrome substrings are: ");
			System.out.println(s);
		} else
			System.out.println("There is no palindrome substring in the Word! ");
	}

	public static void main(String[] args) {
		scanPalindrome("nikashhhs");
	}

}
