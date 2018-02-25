package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Windowtable_HMS {
	WebDriver driver;
  @Test(enabled=false)
  public void test1() {
	  String str;
	 str= driver.findElement(By.xpath("html/body/div[2]/div/div[2]")).getText();
	// System.out.println(str);
	 String[] str1=str.split("\n");
	 for(int i=0;i<str1.length;i++)
	 {
		 if(str1[i].contains("*"))
		 {
			// System.out.println(str1[i]);
			 if(str1[i].contains("Last Name"))
			 {
				 System.out.println("lastname");
			 }
			 else if(str1[i].contains("Gender*"))
			 {
				 System.out.println("gender");
			 }
		 }
	 }
	  
  }
  @Test(enabled=false)
  public void test2()
  {    String str;
	 str=driver.findElement(By.xpath("html/body/div[2]/div/div[2]")).getText();
	 String[] str1=str.split("\n");
	 for(int i=0;i<str1.length;i++)
	 {
		 if(str1[i].contains("*"))
		 {
			 System.out.println(str1[i]);
			 if(str1[i].contains("Patient Name"))
			 {
				 System.out.println("patient name is in the list");
			 }
			 else if(str1[i].contains("Expected Date"))
			 {
				 System.out.println("expected date is in the list");
			 }
		 }
	 }
  }
  @Test(enabled=false)
  public void test3()
  {
	  String str;
	  str=driver.findElement(By.xpath("//*[@id='menu-gm']")).getText();
	 // System.out.println(str);
	  String[] str1=str.split("\n");
	  for(int i=0;i<str1.length;i++)
	  {
		  if(str1[i].contains("Core Java"));
		  {
			  System.out.println("core java field is present in the list");
			  driver.findElement(By.xpath("//*[@id='menu-item-34']/a")).click();
		  }
		  
	  }
  }
  @Test
  public void test4()
  {
	  driver.get("http://selenium4testing.com");
	  driver.findElement(By.xpath("//*[@id='closediv']")).click();
	  driver.findElement(By.linkText("Downloads")).click();
	  String str;
	  str=driver.findElement(By.xpath("//*[@id='post-14']/div")).getText();
	  String[] str1=str.split("\n");
	  System.out.println(str1.length);
	  for(int i=0;i<str1.length;i++)
	  {
		  if(str1[i].equals("TilldatePrograms_src_26July_730AM"));
		  {
			  System.out.println("field is available");
		  }
	  }
			  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 // driver.get("http://selenium4testing.com");
	 // driver.findElement(By.xpath("//*[@id='closediv']")).click();
	  /*driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.name("submit")).click();
	  driver.findElement(By.linkText("ADT")).click();
	  driver.findElement(By.linkText("Admission Advice")).click();*/
	  Thread.sleep(2000);
     }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
