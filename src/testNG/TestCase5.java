package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase5 {
	WebDriver driver;

	@Test
	public void verifyWishListFunctionality() {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id='header-account']/div/ul/li[1]/a")).click();
		wait1.until(ExpectedConditions.titleContains("Customer Login"));
		driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
		wait1.until(ExpectedConditions.titleContains("Create New Customer Account"));
		driver.findElement(By.cssSelector("input[id='firstname']")).clear();
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("gopal");
		driver.findElement(By.cssSelector("input[id='lastname']")).clear();
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("patri");
		driver.findElement(By.cssSelector("#email_address")).clear();
		driver.findElement(By.cssSelector("#email_address")).sendKeys("gopalpatri43@gmail.com");
		driver.findElement(By.cssSelector("#password")).clear();
		driver.findElement(By.cssSelector("#password")).sendKeys("gopalpatri");
		driver.findElement(By.cssSelector("#confirmation")).clear();
		driver.findElement(By.cssSelector("#confirmation")).sendKeys("gopalpatri");
		driver.findElement(By.cssSelector("button[title='Register']")).click();
		wait1.until(ExpectedConditions.titleContains("My Account"));
		String message = driver.findElement(By.cssSelector("p[class='welcome-msg']")).getText().trim().toLowerCase();
		if (!message.contains("gopal"))
			Assert.assertTrue(false);
		driver.findElement(By.cssSelector("nav[id='nav'] ol li[class='level0 nav-2 last'] a")).click();
		wait1.until(ExpectedConditions.titleContains("TV"));
		driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[1]/div/div[3]/ul/li[1]/a")).click();
		wait1.until(ExpectedConditions.titleContains("My Wishlist"));
		driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();
		wait1.until(ExpectedConditions.titleContains("Wishlist Sharing"));
		driver.findElement(By.cssSelector("#email_address")).sendKeys("nikumarpatri1993@gmail.com");
		driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();
		wait1.until(ExpectedConditions.titleContains("My Wishlist"));
		String wishlistSharingmessage = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"))
			.getText().trim();
		try{
		Assert.assertEquals(wishlistSharingmessage, "Your Wishlist has been shared.");}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\Lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
