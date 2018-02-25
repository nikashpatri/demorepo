package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ValidationCommand_HMS {
	WebDriver driver;
	public void validate(String name)
	{
		  try{
			  driver.findElement(By.name(name)).isDisplayed();
			  System.out.println("field is available");
		  }
		  catch(Exception e){
			  System.out.println("field is not available:"+e.getMessage());
		  }
	}
  @Test
  public void f() {
	  validate("username");
	  validate("password");
	  validate("submit");
	  validate("reset");
	// Assert.assertEquals(driver.findElement(By.name("username")).isDisplayed(), false); 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://selenium4testing.com/hms/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
