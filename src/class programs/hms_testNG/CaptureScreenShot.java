package hms_testNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CaptureScreenShot {
	WebDriver driver;
	
public void takeScreenShot(String str) throws Exception{
	SimpleDateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss a");
	Date d=new Date();
	String time=df.format(d);
	System.out.println(time);
File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(f, new File("D:\\WorkSpace_730AM\\"+str+time+".png"));
	}
  @Test
  public void f() throws Exception {
	  driver.findElement(By.linkText("Manual FAQs")).click();
	  takeScreenShot("mFAQs");

driver.findElement(By.linkText("Selenium FAQs")).click();
takeScreenShot("sFAQs");

driver.findElement(By.linkText("Core Java FAQs")).click();
takeScreenShot("cFAQs");

  }
  @BeforeTest
  public void beforeTest() {
		 System.setProperty("webdriver.chrome.driver", "D:\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://selenium4testing.com");	
			driver.findElement(By.id("closediv")).click();
  }

  @AfterTest
  public void afterTest() {
  }

}
