package testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class practice_collection {
	WebDriver driver;
  @Test
  public void f() {
	  
	  List<WebElement> str= driver.findElements(By.tagName("a"));
	  System.out.println(str.size());
	  for (int i = 0; i < str.size(); i++) {
		  if(str.get(i).getText().equals("Downloads"));
		  {
			  driver.findElement(By.id(str.get(i).getText())).click();
		  }
		
	}
  }
  

@BeforeTest
public void beforetest()
{
	 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://selenium4testing.com/");
	  driver.findElement(By.id("closediv")).click();
}
@AfterTest
public void aftertest()
{
	driver.quit();
}
}
