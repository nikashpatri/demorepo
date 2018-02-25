package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Dynamic_Window {
	WebDriver driver;
	Logger log=Logger.getLogger(Dynamic_Window.class);

	public void childwindow() throws Exception {
		driver.findElement(By.linkText("Feedback")).click();
		Thread.sleep(3000);
		log.info("feedback clicked");
		Set<String> col = driver.getWindowHandles();
		log.info("collected");
		System.out.println(col);
		Object[] obj = col.toArray();
		log.info("converted into array");
		driver.switchTo().window(obj[1].toString());
		log.info("switched to child window");
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("nikash patri");
		Thread.sleep(3000);
		log.info("entered value in popup");
		driver.findElement(By.id("email")).sendKeys("nikumarpatri1993@gmail.com");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("car"))).selectByVisibleText("Volvo");
		Thread.sleep(3000);
		driver.switchTo().window(obj[0].toString());
		log.info("swithced to main window");
		Thread.sleep(3000);

	}

	@Test
	public void f() throws Exception {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		childwindow();
		
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
