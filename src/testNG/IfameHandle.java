package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class IfameHandle {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String mainwindow=driver.getWindowHandle();
	  Set<String> windows=driver.getWindowHandles();
	  System.out.println(windows.size());
	  Object[] obj=windows.toArray();
	  for(Object window:obj)
	  {
		  if(!window.toString().equals(mainwindow))
		  {
			  driver.switchTo().window(window.toString());
		  }
	  }
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("html/body/a/img")).click();;
	  Thread.sleep(3000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.navigate().to("https://www.naukri.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
