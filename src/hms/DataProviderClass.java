package hms;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProviderClass {
	private  String name;
	private  int rollno;
	private static Map<String, Integer> map;
	
	@Factory(dataProvider = "dataForConstructor")
	public DataProviderClass(String name, int rollno, Map<String, Integer> map) {
		this.name = name;
		this.rollno = rollno;
		this.map = map;
	}

	@DataProvider(name = "dataForConstructor")
	public static Object[][] dataProvider1() {
		return new Object[][] { { "Nikash", 101, mapValue(45, 67, 87) }, { "Rashmi", 102,mapValue(67, 45, 20) },
				{ "ramesh", 103,mapValue(23, 78, 45) } };
	}

	public  static Map<String, Integer> mapValue(int s, int e, int m) {
		map=new HashMap<String,Integer>();
		map.put("Science", s);
		map.put("English", e);
		map.put("Maths", m);
		return map;
	}

	@DataProvider(name = "dataForTest")
	public Object[][] dataProvider2() {
		Object[][] objarray = new Object[3][2];
		int i = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			objarray[i][0] = entry.getKey();
			objarray[i][1] = entry.getValue();
			i++;
		}

		return objarray;
	}

	@Test(dataProvider = "dataForTest")
	public void checkEligibility(String subject, int marks) {
		if (subject.equals("Science"))
			Assert.assertEquals(marks >= 40, true, this.name + " could not pass the " + subject + " test");
		else if (subject.equals("English"))
			Assert.assertEquals(marks >= 50, true, this.name + " could not pass the " + subject + " test");
		else if (subject.equals("Maths"))
			Assert.assertEquals(marks >= 40, true, this.name + " could not pass the " + subject + " test");

	}

}
