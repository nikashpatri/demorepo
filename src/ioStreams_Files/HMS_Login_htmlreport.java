package ioStreams_Files;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HMS_Login_htmlreport {
	WebDriver driver;
	String str;
	String img;
  @Test
  public void f() throws Exception {
	  File f=new File("D:\\Workspacefor selenium\\selenium_webdriver\\html file\\result.html");
	  FileWriter fw=new FileWriter(f);
	  BufferedWriter bw=new BufferedWriter(fw);
	  
	  bw.write("<table cellspacing='2' border='2'>");
	  bw.write("<tbody>");
	  bw.write("<tr>");
	  bw.write("<td><font face='bold' size='5' color='blue'>Username</font></td>");
	  bw.write("<td><font face='bold' size='5'color='blue'>Password</font></td>");
	  bw.write("<td><font face='bold' size='5'color='red'>Result</font></td>");
	  bw.write("</tr>");
	  
	  FileInputStream fi=new FileInputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmslogin.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet("testdarta");
	  for(int i=1;i<s.getRows();i++)
	  {
		  driver.findElement(By.name("username")).sendKeys(s.getCell(0,i).getContents());
		  driver.findElement(By.name("password")).sendKeys(s.getCell(1, i).getContents());
		  driver.findElement(By.name("submit")).click();
		  try{
			  TakesScreenshot shot;
			  shot=(TakesScreenshot)driver;
			  File src=shot.getScreenshotAs(OutputType.FILE);
			  File dest=new File("D:\\Workspacefor selenium\\selenium_webdriver\\Screenshot\\img.png");
			  FileUtils.copyFile(src, dest);
		  driver.findElement(By.linkText("Logout")).click();
		  System.out.println("passed");
		  str="Passed";
		
		  
		  bw.write("<tr>");
		  bw.write("<td><font face='bold' size='3'>"+s.getCell(0,i).getContents()+"</font></td>");
		  bw.write("<td><font face='bold' size='3'>"+s.getCell(1, i).getContents()+"</font></td>");
		  bw.write("<td><a href='D:\\Workspacefor selenium\\selenium_webdriver\\Screenshot\\img.png' target='_blank' style='color:green'>"+str+"</a></td>");
		  bw.write("</tr>");
		  } 
		  catch(Exception e){
			 
		  driver.switchTo().alert().accept();
		  System.out.println("failed");
		  str="Failed";
		  
		  TakesScreenshot shot;
		  shot=(TakesScreenshot)driver;
		  File src=shot.getScreenshotAs(OutputType.FILE);
		  File dest=new File("D:\\Workspacefor selenium\\selenium_webdriver\\Screenshot\\img1.png");
		  FileUtils.copyFile(src, dest);
		  
		  bw.write("<tr>");
		  bw.write("<td><font face='bold' size='3'>"+s.getCell(0,i).getContents()+"</font></td>");
		  bw.write("<td><font face='bold' size='3'>"+s.getCell(1, i).getContents()+"</font></td>");
		  bw.write("<td><a href='D:\\Workspacefor selenium\\selenium_webdriver\\Screenshot\\img1.png' target='_blank' style='color:red'>"+str+"</a></td>");
		  bw.write("</tr>");
		  }
	  }
	  bw.write("</tbody>");
	  bw.write("</table>");
	  bw.close();
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
     }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
