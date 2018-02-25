package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Printvalue_Adultdropdown_collection {
	WebDriver driver;
  @Test
  public void test1() {
	  List<WebElement> s=new Select(driver.findElement(By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']"))).getOptions();
	  System.out.println(s.size());
	  for (int i = 0; i < s.size(); i++) {
		 // System.out.println(s.get(i).getText());
		  if(!s.get(i).getText().equalsIgnoreCase("6"))
		  {
			//new Select(driver.findElement(By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']"))).selectByVisibleText(s.get(i).getText());
			  System.out.println(s.get(i).getText());
		  }
		
	}
  }
  @BeforeTest
  public void beforeTest() {
	    System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://book2.spicejet.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
