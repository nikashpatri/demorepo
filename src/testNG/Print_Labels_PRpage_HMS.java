package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Print_Labels_PRpage_HMS {
	WebDriver driver;
  @Test
  public void f() {
	  List<WebElement> s=driver.findElements(By.xpath("//*[@id='form1']/div[1]/table/tbody/tr/td"));
	  System.out.println(s.size());
	  for (int i = 0; i < s.size(); i++) {
		System.out.println(s.get(i).getText());
	}
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	     driver.get("http://selenium4testing.com/hms/");
		 driver.findElement(By.name("username")).sendKeys("admin");
		 driver.findElement(By.name("password")).sendKeys("admin");
		 driver.findElement(By.name("submit")).click();
		 driver.findElement(By.linkText("Registration")).click();
		 driver.findElement(By.linkText("Permanent Registration")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
