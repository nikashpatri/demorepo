package hms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate_Parameter {
	WebDriver driver;
	
   public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	   }
   public void openurl()
   {
	   driver.get("http://selenium4testing.com/");
	   driver.findElement(By.id("closediv")).click();
   }
   public void navigate(String str)
   {
	   driver.findElement(By.linkText(str)).click();
   }
   public static void main(String[] args)
   {
	   Navigate_Parameter pm=new Navigate_Parameter();
	   pm.openbrowser();
	   pm.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	   pm.openurl();
	   pm.navigate("New Batches");
	   pm.navigate("Manual FAQs");
	   pm.navigate("Selenium FAQs");
	   pm.navigate("Core Java FAQs");
	   pm.navigate("General Testing FAQs");
	   pm.navigate("Downloads");
	   pm.navigate("Resumes");
	   pm.navigate("Videos");
	   pm.navigate("Mobile Automation with Appium on 25th May @7:30AM");
	  }
}
