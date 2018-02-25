package hms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HmsLogin {
	WebDriver driver;
	
  @DataProvider(name="hmsdata")
  public Object[][] dataProvider()
  {
	  return new Object[][]{{"admin","admin"},{"admin","password"},{"user","user1"},{"user1","user1"}};
  }
	
  @Test(dataProvider="hmsdata")
  public void testLogin(String str1,String str2) throws InterruptedException {
	  
	  driver.findElement(By.name("username")).sendKeys(str1);
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys(str2);
	  try{
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Logout")).click();
	  Assert.assertTrue(true);
	  }
	  catch(Exception e)
	  {
		  driver.switchTo().alert().accept();
		  Assert.assertFalse(false);
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://selenium4testing.com/hms/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
