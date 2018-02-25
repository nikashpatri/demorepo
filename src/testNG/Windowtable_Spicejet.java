package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Windowtable_Spicejet {
	WebDriver driver;
  @Test
  public void splitstring() throws Exception {
	  driver.findElement(By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")).click();
	  String str;
	  String str2="";
	  str=driver.findElement(By.xpath("//*[@id='citydropdown']/tbody/tr[2]/td[2]")).getText();
	  System.out.println(str);
	  String[] str1=str.split("\n");
	  for(int i=0;i<str1.length;i++)
	  {
		  if(str1[i].equalsIgnoreCase("Hyderabad (HYD)"))
		  {
			  str2=str1[i];
			  System.out.println(str2);
			  driver.findElement(By.linkText(str1[i])).click();
			  Thread.sleep(3000);
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
	 // driver.quit();
	 
  }

}
