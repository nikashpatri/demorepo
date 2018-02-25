package hms;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.TextField;

public class AppletExample extends Applet {
	
	TextField text1,text2;
	
	public void init()
	{
		text1=new TextField(9);
		text2=new TextField(9);
		add(text1);
		add(text2);
		text1.setText("0");
		text2.setText("0");
	}
	
	public void paint(Graphics g)
	{
		int x=0,y=0,z=0;
		String s1,s2,s3;
		g.drawString("Enter a number in each textbox", 10, 50);
		s1=text1.getText();
		x=Integer.parseInt(s1);
		s2=text2.getText();
		y=Integer.parseInt(s2);
		z=x+y;
		s3=String.valueOf(z);
		g.drawString(s3, 100, 75);
	}

}
