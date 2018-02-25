package ioStreams_Files;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.WriteAbortedException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HMS_login_Testdata {
		WebDriver driver;
  @Test
  public void f() throws Exception {
	  String str;
	  //reading
	  FileInputStream fi=new FileInputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmslogin.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet("testdarta");
	  //writing
	  FileOutputStream fo=new FileOutputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmsloginresult.xls");
	  WritableWorkbook w=Workbook.createWorkbook(fo);
	  WritableSheet ws=w.createSheet("result", 0);
	  for(int i=0;i<s.getRows();i++)
	  {
		  for(int j=0;j<s.getColumns();j++)
		  {
			  System.out.println(s.getCell(j, i).getContents());//reading cell
			  Label lb=new Label(j, i, s.getCell(j, i).getContents());
			  ws.addCell(lb);
		  }
	  }
	  Label lb1=new Label(2, 0, "result");
	  ws.addCell(lb1);
	  
	  for(int i=1;i<s.getRows();i++)
	  {
	  driver.findElement(By.name("username")).sendKeys(s.getCell(0, i).getContents());
	  driver.findElement(By.name("password")).sendKeys(s.getCell(1, i).getContents());
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(2000);
	  try{
	  driver.findElement(By.linkText("Logout")).click();
	  System.out.println("pass");
	  str="pass";
	  Label lb2=new Label(2, i, str);
	  ws.addCell(lb2);
	  }
	  catch(Exception e)
	  {
		  driver.switchTo().alert().accept();
		  System.out.println("fail");
		  str="fail";
		  Label lb2=new Label(2, i, str);
		  ws.addCell(lb2);
		  
	  }
	  }
	  
	  w.write();
	  w.close();
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
