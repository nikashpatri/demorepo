package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.Keys;

public class MouseHover_Spicejat {
	WebDriver driver;
	Logger log=Logger.getLogger(MouseHover_Spicejat.class);

	@Test
	public void movetoelement() throws Exception {
		Actions a = new Actions(driver);
		WebElement e = driver.findElement(By.linkText("Add-ons"));
		log.info("link stored");
		a.moveToElement(e).build().perform();
		log.info("mouse hovered on the element");
		Thread.sleep(2000);
		driver.findElement(By.linkText("HotMeals")).click();
		log.info("clicked on hotmeals");
		a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		log.info("scrolled to the end of the page");
		Thread.sleep(3000);
		
		
	}

	@BeforeTest
	public void beforeTest() {
		//log.setLevel(Level.INFO);
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://book2.spicejet.com");
		log.info("opened url");
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		log.info("closed browser");
	}

}
