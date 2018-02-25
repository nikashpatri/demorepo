package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDependency {
	WebDriver driver;

	@Test(priority = 1)
	public void lunchApp() {
		driver.get("http://selenium4testing.com/hms/");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='username']")).isDisplayed());
	}

	@Test(dependsOnMethods = "lunchApp", priority = 2)
	public void login() {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[name='password']")).clear();
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[name='submit']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//*[@id='navigation']/li[1]/a")).isDisplayed());
	}

	@Test(dependsOnMethods = "login", priority = 3)
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name='username']")).isDisplayed());
	}

	@BeforeClass
	public void lunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
