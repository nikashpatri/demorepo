package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HighlightElement {
	WebDriver driver;

	public void trackElement(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor script = (JavascriptExecutor) driver;
		script.executeScript("arguments[0].setAttribute('style','background:yellow;');", element);
		Thread.sleep(1000);
	}

	@Test
	public void test1() throws InterruptedException {
		Actions action=new Actions(driver);
		WebElement e=driver.findElement(By.cssSelector("input[id='gs_htif0']"));
		trackElement(e, driver);
		e.sendKeys("Selenium");
		action.sendKeys(Keys.ENTER);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
