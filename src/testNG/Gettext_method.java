package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Gettext_method {
	WebDriver driver;
	
  @Test(description="testing the getattribute method with an attribute",groups={"attribute"},priority=1)
  public void test1() {
	 /* driver.get("https://www.google.co.in");
	  String str=driver.findElement(By.name("btnK")).getAttribute("type");*/
	  System.out.println("1");
	  }
  @Test(description="testing gettext method")
  public void test2()
  {
	  //String str2=driver.findElement(By.linkText("Gmail")).getText();
	  System.out.println(2);
  }
  @Test(description="testing getattribute method",groups={"attribute"},priority=2)
  public void test3()
  {
	  //String str3=driver.findElement(By.id("hplogo")).getAttribute("title");
	  System.out.println("3");
  }
  @BeforeTest(groups={"attribute"})
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","D:\\selenium\\lib\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterTest(groups={"attribute"})
  public void afterTest() {
	  driver.quit();
  }

}
