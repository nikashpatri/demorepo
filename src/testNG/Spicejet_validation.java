package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Spicejet_validation {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath(".//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay']")).click();
	  try{
	  driver.findElement(By.xpath(".//*[@id='custom_date_picker_id_2']")).isDisplayed();
	  System.out.println("field is available");
	  }
	  catch(Exception e){
		  System.out.println("field not available");
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://book2.spicejet.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
