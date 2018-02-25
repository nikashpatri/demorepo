package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Ajaxcontrol_Googlesearch {
	WebDriver driver;
  @Test
  public void test1() throws Exception {
	  driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("selenium");
	  Thread.sleep(2000);
	  String str;
	  str=driver.findElement(By.xpath("//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul")).getText();
	  String[] str1=str.split("\n");
	  for (int i = 0; i < str1.length; i++) 
	  {
		  System.out.println(str1[i]);
		 if(str1[i].contains("selenium tutorial"))
		 {
			 String str2=str1[i];
			 driver.findElement(By.xpath("//*[@id='lst-ib']")).clear();
			 driver.findElement(By.xpath("//*[@id='sbse1']/div[2]/b")).click();
		 }
		
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("https://www.google.co.in");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
