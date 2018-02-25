package ioStreams_Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.testng.annotations.Test;

public class Creat_htmlfile {
  @Test
  public void createfile() throws Exception {
	  
	  File f=new File("D:\\Workspacefor selenium _Appium\\selenium_webdriver\\html file\\sample.html");
	  FileWriter fw=new FileWriter(f);
	  BufferedWriter bw=new BufferedWriter(fw);
	 bw.write("<table cellspacing='2' border='2' cellpading='3'>");
	 bw.write("<tbody>");
	 bw.write("<tr>");
	 bw.write("<td> <font face='bold' size='6'>nik</font></td>");
	 bw.write("<td> <font face='bold' size='6'> rashmi</font></td>");
	 bw.write("<td> <font face='bold' size='6'>anjali</font></td>");
	 bw.write("</tr>");
	 
	 bw.write("<tr>");
	 bw.write("<td><font face='bold' size='4' color='yellow'>rajesh</font></td>");
	 bw.write("<td><font face='bold' size='4' color='red'>maami</font></td>");
	 bw.write("<td><font face='bold' size='4'  color='green'>rounak</font></td>");
	 bw.write("</tr>");
	 
	 bw.write("<tr>");
	 bw.write("<td>");
	 bw.write("<a href='http://selenium4testing.com/downloads/' target='_blank'>link</a>");
	 bw.write("</td>");
	 bw.write("</tr>");
	 bw.write("</tbody>");
	 bw.write("</table>");
	 bw.close();
	 
  }
  @Test(enabled=false)
 
	  public void creatfile2() throws Exception {
		  File f=new File("D:\\Workspacefor selenium\\selenium_webdriver\\html file\\sample.html");
		  FileWriter fw=new FileWriter(f);
		  BufferedWriter bw=new BufferedWriter(fw);
		bw.write("<table cellspacing='2' cellpading='3' border='2'>");
		  bw.write("<tbody>");
		  bw.write("<tr>");
			  bw.write("<td>");
			  bw.write("<font face='bold' size='6' color='red'>");
			  bw.write("Nagesh");
			  bw.write("</font>");
			  bw.write("</td>");
	bw.write("<td><font face='bold' size='6' color='yellow'>Suresh</font></td>");
			  bw.write("<td>Mahesh</td>");
		  bw.write("</tr>");
		  
		  bw.write("<tr>");
	bw.write("<td><font face='bold' size='6' color='green'>Ram</font></td>");
		  	bw.write("<td>Raj</td>");
		  	bw.write("<td>Sham</td>");
		  bw.write("</tr>");
		  
		  bw.write("<tr>");
		  bw.write("<td>");
	bw.write("<a href='D:/WorkSpace_730AM/SeleniumAutomation/ScreenShots/FailedmFAQs.png' target='_blank'>Nagesh</a>");
		  bw.write("</td>");
		  bw.write("</tr>");
		  
		  bw.write("</tbody>");
		  bw.write("</table>");
		  bw.close();
		  
	  }
	

  }

