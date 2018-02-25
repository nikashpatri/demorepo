package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Google_lang_selection {
	WebDriver driver;
  @Test
  public void a() throws Exception {
	  driver.findElement(By.xpath("//div[@id='_eEe']/a")).click();
		Thread.sleep(2000);
	   }
  @Test
  public void b() throws Exception
  {
	  driver.findElement(By.xpath("//div[@id='_eEe']/a[2]")).click();
		Thread.sleep(2000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.navigate().to("https://www.google.co.in/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
	  
  }


