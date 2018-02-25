package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Selenium4testing_Screenshot {
	WebDriver driver;
public void navigate(String linkname) throws Exception
	{
		driver.findElement(By.linkText(linkname)).click();
		Thread.sleep(2000);
	}
public void getscreenshot(String imgname) throws Exception
{
	TakesScreenshot shot;
	shot=(TakesScreenshot)driver;
	File srcfile;
	srcfile=shot.getScreenshotAs(OutputType.FILE);
	File destfile=new File("D:\\Workspacefor selenium\\selenium_webdriver\\"+imgname+".png");
	FileUtils.copyFile(srcfile, destfile);
	
}
	
  @Test
  public void test1() throws Exception {
	  navigate("About us");
	  getscreenshot("about");
  }
  @Test
  public void test2() throws Exception {
	  navigate("New Batches");
	  getscreenshot("batches");
  }
  @Test
  public void test3() throws Exception {
	  navigate("Manual FAQs");
	  getscreenshot("manual");
  }
  @Test
  public void test4() throws Exception {
	  navigate("Selenium FAQs");
	  getscreenshot("selnium");
  }
  @Test
  public void test5() throws Exception {
	  navigate("Core Java FAQs");
	  getscreenshot("java");
  }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String str) {
	  if(str.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.navigate().to("http://selenium4testing.com/");
		  driver.findElement(By.id("closediv")).click();
	  }
	  else if(str.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.navigate().to("http://selenium4testing.com/");
		  driver.findElement(By.id("closediv")).click();
	  }
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
