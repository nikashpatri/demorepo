package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Admissionadvice_collection {
	WebDriver driver;
	Logger l=Logger.getLogger(Admissionadvice_collection.class);

	@Test
	public void f() {
       // PropertyConfigurator.configure("log4j.properties");
		List<WebElement> s = driver.findElements(By.tagName("input"));
		l.info("collected webelements");
		System.out.println(s.size());
		for (int i = 0; i < s.size(); i++) {

			if (s.get(i).getAttribute("type").equalsIgnoreCase("text")) {
				System.out.println("Textbox_locator:" + s.get(i).getAttribute("name"));
			} else if (s.get(i).getAttribute("class").equalsIgnoreCase("log")) {
				System.out.println("Button_locator:" + s.get(i).getAttribute("type"));
			}
		}
	}
	@Test(groups={"attribute"},priority=1)
	public void test1()
	{
		System.out.println("attribute 1 of admission class");
	}
	@Test(groups={"attribute"},priority=2)
	public void test2()
	{
		System.out.println("attribute 2 of admission class");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		l.info("launched browser");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
		l.info("opened url");
		driver.findElement(By.name("username")).sendKeys("admin");
		l.info("entered username");
		driver.findElement(By.name("password")).sendKeys("admin");
		l.info("entered password");
		driver.findElement(By.name("submit")).click();
		l.info("clicked on asubmit ");
		driver.findElement(By.linkText("ADT")).click();
		l.info("clicked on adt advice");
		driver.findElement(By.linkText("Admission Advice")).click();
		l.info("clicked on admission advice");
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
