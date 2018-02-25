package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Ajaxcontrol_HMS {
	WebDriver driver;
  @Test
  public void test1() throws Exception {
	  driver.findElement(By.id("MR_NO")).sendKeys("PR");
	  Thread.sleep(2000);
	  String str;
	  str=driver.findElement(By.xpath("//*[@id='results']")).getText();
	  String[] str1=str.split("\n");
	  for (int i = 0; i < str1.length; i++) {
		  System.out.println(str1[i]);
		  if(str1[i].contains("PR1341680337"))
		  {
			  String str2=str1[i];
			  driver.findElement(By.id("MR_NO")).clear();
			  driver.findElement(By.id("MR_NO")).sendKeys(str2);
			  Thread.sleep(2000);
		  }
		
	}
	  
		
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://selenium4testing.com/hms/");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin");
	  driver.findElement(By.name("submit")).click();
	  driver.findElement(By.linkText("ADT")).click();
	  driver.findElement(By.linkText("Admission Advice")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
