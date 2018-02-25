package hms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class ExamClass {
	WebDriver driver;
	
   @DataProvider(name="test")
	public static Object[][] dataProvider()
	{
	   return new Object[][]{{"pratik_123","prakumar@234"},{"pratik_123","prkumar"},{"pratik1","pkumar3"},{"23pratik","pratikumar"},{"pratik-123","pratikumar"}};
	}
	
  @Test(dataProvider="test")
  public void test1(String username,String password) throws InterruptedException {
	  driver.findElement(By.id("id-username")).sendKeys(username);
	  driver.findElement(By.id("id-password1")).sendKeys(password);
	  driver.findElement(By.id("submit")).click();
	  Thread.sleep(2000);
	  try {
		  String username1=driver.findElement(By.xpath("//div[@id='signup-success']/span")).getText();
		  if(username.equals(username1))
		  {
			  System.out.println("successfull registration message is displayed with the user entered name");
		  }else
		  {
			  System.out.println("successfull registration message is not displayed with the user entered name" );
		  }
		
	} catch (NoSuchElementException e) {
		
		String errormessage=driver.findElement(By.xpath("//div[@id='signup-error']")).getText();
		if(username.equals("pratik_123") && password.equals("prkumar"))
			Assert.assertEquals(errormessage, "Error: password too short");
		else if(username.equals("pratik1") && password.equals("pkumar3"))
			Assert.assertEquals(errormessage, "Error: username too short");
		else if(username.equals("23pratik") && password.equals("pratikumar"))
			Assert.assertEquals(errormessage, "Error: username must start with an alphabet");
		else if(username.equals("pratik-123")&& password.equals("pratikumar"))
			Assert.assertEquals(errormessage, "Error: password must contains a number or special character");
	}
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://example.com/reg.html");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  driver.navigate().to("http://example.com/reg.html");
  }

}
