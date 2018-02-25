package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Default_Dropdownvalue {
	WebDriver driver;
	public void defaultvalue(String str , String str1)
	{
		 
		 WebElement e= new Select(driver.findElement(By.id(str))).getFirstSelectedOption();
		 if(e.getText().equalsIgnoreCase(str1))
		 {
			 System.out.println("default value is:"+str1 );
		 }
		 else{
			 System.out.println("default value is not:"+str1);
		 }
	}
  @Test
  public void checkdefaultvalue() {
	 defaultvalue("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT", "1");
	 defaultvalue("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD", "0");
	 defaultvalue("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_INFANT", "0");
	 defaultvalue("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency", "SELECT");
	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.get("https://book2.spicejet.com");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
