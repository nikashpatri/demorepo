package hms;

import java.awt.Button;
import java.awt.Frame;

public class AWTExample {
	
	AWTExample()
	{
		Frame f=new Frame();  
		Button b=new Button("click");  
		b.setBounds(30,50,80,30);  
		f.add(b);  
		f.setSize(300,300);  
		f.setLayout(null);  
		f.setVisible(false);  
	}

	public static void main(String[] args) {
		AWTExample obj=new AWTExample();
	}

}
