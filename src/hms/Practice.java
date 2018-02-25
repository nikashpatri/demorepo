package hms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.itextpdf.text.log.SysoLogger;

public class Practice {
	static WebDriver driver;

	public static void swapWithoutThirdVariable() {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 1st number");
		a = sc.nextInt();
		System.out.println("a is: " + a);
		System.out.println("Enter the 2nd number");
		b = sc.nextInt();
		System.out.println("b is: " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After Swapping");
		System.out.println("a is: " + a + " " + "b is: " + b);
	}

	public static void fibonacciSeries() {
		int a = 1, b = 2, c = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Set the limit:");
		int x = sc.nextInt();
		System.out.println("The Required Series is...");
		System.out.print(a + " " + b);
		for (int i = 0; i < x - 2; i++) {
			c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}
	}

	public static void printWithoutLoop(int n) {
		if (n <= 10) {
			System.out.print(" " + n);
			printWithoutLoop(n + 1);
		}
	}

	public static void equlateralTriangle() {
		for (int i = 5; i >= 0; i--) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void filterDuplicate(int[] x) {
		for (int i = 0; i < x.length; i++) {
			boolean b = true;
			for (int j = 0; j < i; j++) {
				if (x[i] == x[j]) {
					b = false;
					break;
				}

			}
			if (b) {
				System.out.print(" " + x[i]);
			}
		}
	}

	public static void bubbleSort(int[] x) {
		int temp = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length - i - 1; j++) {
				if (x[j] > x[j + 1]) {
					temp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < x.length; i++) {
			System.out.print(" " + x[i]);
		}
	}

	public static void printDuplicateNumbers(int arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size:");
		int size = sc.nextInt();
		int[] x = new int[size];
		for (int i = 0; i < x.length; i++) {
			System.out.println(i + " index");
			x[i] = sc.nextInt();
		}
		System.out.println("Duplicate numbers are...");
		for (int i = 0; i < x.length; i++) {
			boolean b = false;
			for (int j = 0; j < i; j++) {
				if (x[i] == x[j]) {
					b = true;
					break;
				}
			}
			if (b) {
				System.out.print(" " + x[i]);
			}
		}
	}

	public static void printDuplicateNumbers() {
		Set<Integer> s1 = new HashSet<Integer>();
		List<Integer> l1 = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(i + " index");
			l1.add(sc.nextInt());
		}
		System.out.println("Duplicate Elements are...");

		for (int i = 0; i < l1.size(); i++) {
			if (!s1.add(l1.get(i))) {
				System.out.print(" " + l1.get(i));
			}
		}
	}

	public static boolean isPalindrome() {
		int temp = 0, y = 0, r = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		int n = sc.nextInt();
		temp = n;
		while (n != 0) {
			r = n % 10;
			y = y * 10 + r;
			n = n / 10;
		}
		if (temp == y) {
			System.out.println(temp + " is palindrome");
			return true;
		} else {
			System.out.println(temp + " is not palindrome");
			return false;
		}
	}

	public static boolean isArmstrong() {
		int temp = 0, y = 0, r = 0, a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		temp = n;
		while (n != 0) {
			r = n % 10;
			a = r * r * r;
			y = y + a;
			n = n / 10;
		}
		if (temp == y) {
			System.out.println(temp + " is armstrong");
			return true;
		} else {
			System.out.println(temp + " is not armstrong");
			return false;
		}
	}

	public static void findFactorial() {
		int f = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = sc.nextInt();
		for (int i = n; i > 0; i--) {
			f = f * i;
		}
		System.out.println(n + "! =" + f);
	}

	public static void findTheBiggestNumber() {
		int biggestNumber = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size");
		int size = sc.nextInt();
		int[] x = new int[size];
		for (int i = 0; i < x.length; i++) {
			System.out.println("index " + i + ":");
			x[i] = sc.nextInt();
		}
		for (int i = 0; i < x.length; i++) {
			if (x[i] > biggestNumber) {
				biggestNumber = x[i];
			}
		}
		System.out.println("The Biggest no is: " + biggestNumber);
	}

	public static void count() {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int size = sc.nextInt();
		int[] x = new int[size];
		for (int i = 0; i < x.length; i++) {
			System.out.println("index " + i + ":");
			x[i] = sc.nextInt();
		}
		for (int i = 0; i < x.length; i++) {
			if (x[i] > 100) {
				count++;
			}
		}
		System.out.println("Total " + count + " nos are greater than 100");
	}

	public static void series(int x) {
		int n = 0;
		for (int i = 1; i <= x; i++) {
			n = i * i;
			System.out.print(" " + n);
		}
	}

	public static void findTheSmallestNumber(int[] x) {
		int temp = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length - 1 - i; j++) {
				if (x[j] > x[j + 1]) {
					temp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = temp;
				}
			}
		}
		System.out.println("The smallest number is: " + x[0]);
	}

	public static void printPrimeNumbers(int n) {
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i - 1; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i + " ");
			}
		}
	}

	public static void triangle1() {
		for (int i = 1; i <= 5; i++) {
			int k = 2;
			for (int j = 5; j >= i; j--) {

				System.out.print(" " + k);
				k = k + 2;
			}
			System.out.println();
		}
	}

	public static void triangle2() {
		for (int i = 1; i <= 5; i++) {
			int k = 1;
			for (int j = 5; j >= i; j--) {
				System.out.print(" " + k);
				k++;
			}
			System.out.println();
		}
	}

	public static void printPattern1() {
		for (int i = 1; i <= 7; i++) {

			for (int j = 7; j >= i; j--) {
				System.out.print(" " + j);
			}
			System.out.println();
		}

		for (int i = 1; i <= 6; i++) {
			int k = 7;
			for (int j = 0; j <= i; j++) {
				System.out.print(" " + k);
				k--;
			}
			System.out.println();
		}
	}

	public static void printPattern2() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" " + j);
			}
			System.out.println();
		}
		for (int i = 1; i <= 4; i++) {
			int k = 1;
			for (int j = 4; j >= i; j--) {
				System.out.print(" " + k);
				k++;
			}
			System.out.println();
		}
	}

	public static void printPattern3() {
		int k = 1;
		for (int i = 1; i <= 5; i++) {
			int m = 1;
			for (int j = 1; j <= k; j++) {
				System.out.print(" " + m);
				m++;
			}
			System.out.println();
			k = k + 2;
		}
	}

	public static void printPattern4() {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" " + j);
			}
			for (int j = i - 1; j >= 1; j--) {
				System.out.print(" " + j);
			}
			System.out.println();
		}
	}

	public static void printPattern5() {
		for (int i = 1; i <= 5; i++) {
			if (i % 2 != 0) {
				for (int j = 1; j <= 7; j++) {
					if (j % 2 == 0) {
						System.out.print("0 ");
					} else {
						System.out.print("1 ");
					}
				}
				System.out.println();
			} else {
				for (int j = 1; j <= 7; j++) {
					if (j % 2 == 0) {
						System.out.print("1 ");
					} else {
						System.out.print("0 ");
					}
				}
				System.out.println();
			}
		}
	}

	public static void printPattern6() {
		int m = 1;
		for (int i = 1; i <= 5; i++) {
			for (int j = 4; j >= i; j--) {
				System.out.print(" 1");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" " + m);
			}
			System.out.println();
			m++;
		}
	}

	public static void printPattern7() {
		int m = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j == i) {
					System.out.print(m + " ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
			m++;
		}
	}

	public static void printPattern8() {
		for (int i = 1; i <= 5; i++) {
			int m = i;
			int k = 4;
			for (int j = 1; j <= i; j++) {
				System.out.print(m + " ");
				m = m + k;
				k--;
			}
			System.out.println();
		}
	}

	public static void printPattern9() {
		int k = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			int m = i;
			for (int j = 1; j <= 5 - k; j++) {
				System.out.print(m + " ");
				m++;
			}
			System.out.println();
			k++;
		}
		int m = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 3; j >= i; j--) {
				System.out.print(" ");
			}
			int n = 4 - m;
			for (int j2 = 0; j2 <= i; j2++) {
				System.out.print(n + " ");
				n++;
			}
			System.out.println();
			m++;
		}
	}

	public static String removeCharacterAt(int index) {
		String s1 = "java";
		String s2 = "";
		char[] ch = s1.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i != index) {
				s2 = s2 + ch[i];
			}
		}
		return s2;
	}

	public static ArrayList<Character> printRecurringCharacters(String str) {
		ArrayList<Character> recurringelements = new ArrayList<Character>();
		HashSet<Character> s = new HashSet<Character>();
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (s.add(ch[i]))
				;
			else {
				recurringelements.add(ch[i]);
			}
		}
		if (recurringelements.isEmpty()) {
			System.out.println(recurringelements.size());
			System.out.println("No Recurring Character");
			return recurringelements;

		} else {
			return recurringelements;
		}
	}

	public static String printDuplicates(String word) {
		String str = "";
		char[] ch = word.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			boolean b = false;
			for (int j = 0; j < i; j++) {
				if (ch[i] == ch[j]) {
					b = true;
					break;
				}
			}
			if (!b) {
				str = str + ch[i];
			}
		}
		return str;
	}

	public static void findTheLongestOccuredCharacter(String str) {
		char[] ch = str.toCharArray();
		int maxCount = 0;
		int count = 0;
		char maxChar = 0;
		char prevChar = 0;
		char currentChar = 0;
		for (int i = 0; i < ch.length; i++) {
			if (prevChar == currentChar) {
				count += 1;
			} else {
				count = 1;
			}
			if (count > maxCount) {
				maxCount = count;
				maxChar = currentChar;
			}
			prevChar = currentChar;
			currentChar = ch[i];
		}
		System.out.println(maxChar + ": " + count);
	}

	public static void findLcmAndHcm(int a, int b) {
		int temp, hcf, lcm;
		int x = a;
		int y = b;
		while (y != 0) {
			temp = y;
			y = x % y;
			x = temp;
		}
		hcf = x;
		lcm = (a * b) / hcf;
		System.out.println("hcf is: " + hcf);
		System.out.println("lcm is: " + lcm);

	}

	public static boolean areCoPrime(int[] x) {
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
		for (int i = 0; i < x.length; i++) {
			for (int j = 1; j <= x[i]; j++) {
				if (i == 0) {
					if (x[i] % j == 0) {
						System.out.print(j + " ");
						l1.add(j);
					}
				} else {
					if (x[i] % j == 0) {
						System.out.print(j + " ");
						l2.add(j);
					}
				}
			}
			System.out.println();
		}
		boolean b = false;
		for (int i = 1; i < l1.size(); i++) {
			int m = Integer.parseInt(l1.get(i).toString());
			for (int j = 1; j < l2.size(); j++) {
				int n = Integer.parseInt(l2.get(j).toString());
				if (m == n) {
					b = true;
					break;

				}

			}
		}
		if (b) {
			return false;
		} else {
			return true;
		}
	}

	public static void findFactors() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		System.out.print("The divisors of " + number + " are: ");
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static void findAllCombinations(String str) {
		char temp;
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {

			for (int j = 1; j <= ch.length - 1; j++) {
				temp = ch[j];
				ch[j] = ch[j - 1];
				ch[j - 1] = temp;
				for (int j2 = 0; j2 < ch.length; j2++) {
					System.out.print(ch[j2]);
				}
				System.out.println();
			}
		}

	}

	public static WebElement explicitWait(By locator, int withtimeout, int pollingfrequency) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(withtimeout, TimeUnit.SECONDS);
		wait.pollingEvery(pollingfrequency, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement e = driver.findElement(locator);
				if (e.isDisplayed()) {
					return e;
				} else {
					return null;
				}

			}
		});
		return element;
	}

	public static void calculateEach() {
		float siri = 0, christ = siri + 20, total = 21;
		siri = total - christ;
		siri = siri / 2;
		christ = siri + 20;
		System.out.println(siri + " " + christ);

	}

	public static void compressString(String str) {
		int count = 0;
		char temp = str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == temp)
				count++;
			else {
				System.out.print(count + "" + temp);
				temp = str.charAt(i);
				count = 1;
			}

		}
		System.out.print(count + "" + temp);
	}

	public static void findSquareroot(int n) {

		int l = 1, u = n, m = 0;
		while (l <= u) {
			m = (l + u) / 2;
			if (m * m == n) {
				System.out.println("square root is: " + m);
				break;
			} else if (n < m * m) {
				u = m - 1;
			} else
				l = m + 1;
		}

	}

	public static void formatAlphbet(String str) {
		char[] ch = str.toLowerCase().toCharArray();
		int[] x = new int[ch.length];
		for (int i = 0; i < ch.length; i++) {

			x[i] = ch[i];

		}

		for (int j = 1; j <= x.length; j++) {
			int temp = 0;
			for (int k = 0; k < x.length - j; k++) {
				if (x[k] > x[k + 1]) {
					temp = x[k];
					x[k] = x[k + 1];
					x[k + 1] = temp;
				}
			}
		}

		for (int i = 0; i < x.length; i++) {

			ch[i] = (char) x[i];
			System.out.print(ch[i]);
		}

	}

	public static void formatString1(String str) {
		char[] ch1 = str.toLowerCase().toCharArray();

		int count = str.length();
		char[] ch2 = new char[count];
		int num = 97;
		for (int i = 0; i < count; i++) {
			ch2[i] = (char) num;

			num++;
		}

		for (int j = 0; j < ch1.length; j++) {
			if (ch1[j] == ch2[j]) {
				System.out.print(ch1[j] + " ");
			}
		}
	}

	public static void arrangeString(String str) {
		String[] str1 = str.split(" ");
		for (int i = 1; i <= str1.length; i++) {
			String temp;
			for (int j = 0; j < str1.length - i; j++) {
				int x = str1[j].toLowerCase().charAt(0);
				int y = str1[j + 1].toLowerCase().charAt(0);
				if (x > y) {
					temp = str1[j + 1];
					str1[j + 1] = str1[j];
					str1[j] = temp;

				}
			}

		}

		for (String str2 : str1) {
			System.out.print(str2 + " ");
		}
	}

	public static char charAtIndex(String str, int index) {
		char[] ch = str.toCharArray();
		return ch[index];
	}

	public static void sortString(String str) {
		// Removing Repeated Words!
		String[] str1 = str.split(" ");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str1.length; i++) {
			boolean b = false;
			for (int j = 0; j < i; j++) {
				if (str1[i].equals(str1[j])) {
					b = true;
					break;
				}
			}
			if (!b) {
				list.add(str1[i]);
			}
		}

		// Sorting The list Based On String Size!
		for (int k = 1; k <= list.size(); k++) {
			for (int l = 0; l < list.size() - k; l++) {
				String temp1;
				int x = list.get(l).length();
				int y = list.get(l + 1).length();
				if (x > y) {
					temp1 = list.get(l + 1);
					list.set(l + 1, list.get(l));
					list.set(l, temp1);
				}
			}

		}

		// Formatting The OutPut!
		String temp2 = list.get(0);

		for (int m = 0; m < list.size(); m++) {
			if (temp2.length() == list.get(m).length()) {
				System.out.print(list.get(m) + " ");
			} else {
				System.out.print(temp2.length() + " ");

				temp2 = list.get(m);
				System.out.print(temp2 + " ");
			}
		}
		System.out.print(temp2.length());

	}

	public static void fibonacciNumber() {
		int a = 1, b = 2, sum = 0;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Set the firstlimit:");
		int x = sc.nextInt();
		System.out.println("set the lastlimit");
		int y = sc.nextInt();
		while (sum < y) {
			sum = a + b;
			a = b;
			b = sum;
			if (sum > x) {
				count++;
				if (count == 3) {
					break;
				}
			}

		}
		System.out.println(sum);
	}

	public static void getIntegerlength(int number) {
		int count = 0, x = number;
		while (x > 0) {
			x = x / 10;
			count++;
		}
		System.out.println("length of " + number + " is: " + count);
	}

	public static void findSecondlargestnumber(int[] x) {
		// Sorting In Descending Order
		for (int i = 1; i <= x.length; i++) {
			int temp = 0;
			for (int j = 0; j < x.length - i; j++) {
				if (x[j] < x[j + 1]) {
					temp = x[j];
					x[j] = x[j + 1];
					x[j + 1] = temp;
				}
			}
		}
		System.out.println("Secondlargestnumber is: " + x[1]);

	}

	public static void findPossiblecombinations(int[] x, int y) {
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] + x[j] == y) {
					System.out.println(x[i] + " " + x[j]);
				}
			}
		}
	}

	public static void test(String str, int k) {

		List<Character> list = new ArrayList<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (map.containsKey(charArray[i]))
				map.put(charArray[i], map.get(charArray[i]) + 1);
			else
				map.put(charArray[i], 1);
		}

		for (int j = 0; j < map.size(); j++) {
			if (map.get(charArray[j]) == k)
				list.add(charArray[j]);
		}

		if (list.size() == 1) {
			System.out.println(list.get(0));
		} else if (list.size() > 1) {
			for (int m = 1; m <= list.size(); m++) {
				char temp = 0;
				for (int n = 0; n < list.size() - 1; n++) {
					int x = list.get(n);
					int y = list.get(n + 1);
					if (x > y) {
						list.set(n + 1, list.get(n));
						list.set(n, temp);
					}
				}
			}
			System.out.println(list.get(0));
		} else
			System.out.println("-1");

	}

	public static void arraySorting() {
		int rightsum = 0, leftsum = 0;
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = scan.nextInt();
		}

		for (int j = 0; j < x.length; j++) {
			for (int k = j + 1; k < x.length; k++) {
				rightsum = rightsum + x[k];
			}
			for (int m = j - 1; m >= 0; m--) {
				leftsum = leftsum + x[m];
			}
			if (rightsum == leftsum) {
				flag = true;
				break;
			}
			rightsum = 0;
			leftsum = 0;
		}
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static void countSubstring(String string, String subString) {
		int count = 0;
		char[] array = string.toCharArray();
		for (int i = 0; i < array.length; i++) {
			int j = array.length - 1;
			while (j >= i) {
				if (j == i) {

					if (string.substring(i).equals(subString))
						count++;
				} else {
					if (string.substring(i, j).equals(subString))
						count++;
				}
				j--;
			}
		}
		System.out.println("'" + subString + "' has been repeated " + count + " times in the string '" + string + "'");
	}

	public static void pushZerosToRightEnd(int[] x) {

		int count = 0;

		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0) {
				x[count] = x[i];
				count++;
			}
		}
		while (count < x.length) {
			x[count] = 0;
			count++;
		}
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	public static void pushZerostoLeftEnd(int[] x) {
		int count = x.length - 1;
		for (int i = x.length - 1; i >= 0; i--) {
			if (x[i] != 0) {
				x[count] = x[i];
				count--;
			}
		}
		while (count >= 0) {
			x[count] = 0;
			count--;
		}
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	public static void main(String[] args) {
		pushZerostoLeftEnd(new int[] { 5, 0, 9, 3, 0, 0, 78, 45, 0, 34 });
		StackTraceElement[] element=Thread.currentThread().getStackTrace();
		System.out.println();
		for(StackTraceElement element1:element)
		{
			System.out.println(element1.getMethodName());
		}
	}
}
