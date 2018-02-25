package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TestAutoit {
	WebDriver driver;
	
  @Test
  public void f() throws IOException {
	  
	  driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
	  driver.findElement(By.cssSelector("input[name='password']")).clear();
	  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
	  driver.findElement(By.cssSelector("input.log")).click();
	  driver.findElement(By.).click();
	  //driver.findElement(By.name("image")).click();
	  //Runtime.getRuntime().exec("E:\\fileupload.exe");
	  System.out.println("done");
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://selenium4testing.com/hms/");
  }

  /*@AfterTest
  public void afterTest() {
	  driver.quit();
  }*/

}
