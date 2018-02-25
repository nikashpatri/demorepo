package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase3 {

	WebDriver driver;
	String exceptedcartmessage="SHOPPING CART IS EMPTY";
	String exceptederrormessage="* The maximum quantity allowed for purchase is 500.";
	String url="http://live.guru99.com/index.php/";

	@Test
	public void verifyMoreProductCannotBeAddedThanAvailable() {
		driver.findElement(By.xpath("//div[@id='header-nav']/nav/ol/li[1]/a")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.titleContains("Mobile"));
		driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[1]/div/div[3]/button")).click();
		driver.findElement(By.cssSelector("input[class='input-text qty']")).clear();
		driver.findElement(By.cssSelector("input[class='input-text qty']")).sendKeys("1000");
		driver.findElement(By.cssSelector("button[class='button btn-update']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement element=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='item-msg error']")));
		String errormessage = element.getText().trim();
		try {
			Assert.assertEquals(exceptederrormessage, errormessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#empty_cart_button")).click();
		String cartmessage = driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText().trim();
		System.out.println(cartmessage);
		try {
			Assert.assertEquals(exceptedcartmessage, cartmessage);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\Lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
