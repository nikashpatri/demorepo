package hms;

import java.lang.reflect.Method;

public class Student {

	String name;
	int rollno;

	public Student(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}

	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (name.equals(s.name) && rollno == s.rollno)
				return true;
			else
				return false;
		}
		return false;
	}

	public static void main(String[] args) {
		Student s1 = new Student("Nikash", 101);
		Student s2 = new Student("Rashmi", 102);
		Student s3 = s1;
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
		Class c=s1.getClass();
		System.out.println(c.getName());
		Method[] m=c.getDeclaredMethods();
		for(Method m1:m)
		{
			System.out.println(m1.getName());
		}
	}
}
