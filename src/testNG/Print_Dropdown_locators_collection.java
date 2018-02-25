package testNG;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Print_Dropdown_locators_collection {
	WebDriver driver;
  @Test(enabled=false)
  public void spicejetdropdown() {
	  
	  List<WebElement> s=driver.findElements(By.tagName("select"));
	  System.out.println(s.size());
	  for (int i = 0; i < s.size(); i++) {
	  System.out.println(s.get(i).getAttribute("name"));
	  	
	}
  }
  @Test
   public void hmsdropdown()
   {
	  List<WebElement> s=driver.findElements(By.tagName("select"));
	  System.out.println(s.size());
	  for (int i = 0; i < s.size(); i++) {
	  System.out.println(s.get(i).getAttribute("name"));
	  }
   }
  @BeforeTest
  public void beforeTest() {
	 /* System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://book2.spicejet.com/");*/
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Permanent Registration")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
