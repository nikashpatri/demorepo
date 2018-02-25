package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Windowtable_Spicejetdatepicker {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  String str;
	  driver.findElement(By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Hyderabad (HYD)")).click();
	  Thread.sleep(2000);
	  str=driver.findElement(By.xpath("html/body/div[8]/form/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]")).getText();
	  String[] str1=str.split("\n");
	  String str3="";
	  for(int i=0;i<str1.length;i++)
	  {
		 System.out.println(str1[i]);
		  if(str1[i].contains("Bengaluru"))
		  {
			  str3=str1[i];
			  System.out.println("bengaluru is available in the table");
			  driver.findElement(By.linkText(str3)).click();
			  Thread.sleep(2000);
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
