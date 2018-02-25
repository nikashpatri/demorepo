package hms;

public class TestClass {
	static MyThread t1;
	public static void consume()
	{
	System.out.println("Products are ready to be consumed.....");
	for (int i = 0; i <t1.stringArray.length; i++) {
		System.out.println(t1.stringArray[i]+" ");
	}
	}

	public static void main(String[] args) throws InterruptedException {
		t1=new MyThread();
		t1.start();
		synchronized (t1) {
			t1.wait();
			consume();
		}
		
		

	}

}
