package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase6 {
	WebDriver driver;
	String emailid = "nikumarpatri1993@gmail.com";
	String password = "nikashpatri";
	String country = "India";
	String state = "karnataka";
	String pin = "560068";
	SoftAssert softassert = new SoftAssert();

	@Test
	public void verifyUserIsAbleToPurchaseUsingRegisteredAccount() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id='header-account']/div/ul/li[1]/a")).click();
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.cssSelector("#email")).sendKeys(emailid);
		driver.findElement(By.cssSelector("#pass")).clear();
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		wait.until(ExpectedConditions.titleContains("My Account"));
		driver.findElement(By.xpath("//*[@id='nav']/ol/li[2]/a")).click();
		wait.until(ExpectedConditions.titleContains("TV"));
		driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[2]/div/div[3]/button")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
		driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		new Select(driver.findElement(By.cssSelector("#country"))).selectByVisibleText(country);
		driver.findElement(By.cssSelector("input[id='region']")).sendKeys(state);
		driver.findElement(By.cssSelector("#postcode")).sendKeys(pin);
		driver.findElement(By.cssSelector("button[title='Estimate']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("input[id='s_method_flatrate_flatrate']")));
		WebElement flatRate = driver.findElement(By.cssSelector(".sp-methods dd ul li label span"));
		softassert.assertEquals(true, flatRate.isDisplayed());
		double shippingcharge = Double.parseDouble(flatRate.getText().substring(1));
		WebElement totalcost1 = driver
				.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"));
		double totalcost2 = Double.parseDouble(totalcost1.getText().substring(1));
		driver.findElement(By.cssSelector("input[id='s_method_flatrate_flatrate']")).click();
		driver.findElement(By.cssSelector("button[title='Update Total']")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		double grandtotal1 = totalcost2 + shippingcharge;
		WebElement totalcost3 = driver
				.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"));
		double grandtotal3 = Double.parseDouble(totalcost3.getText().substring(1));
		softassert.assertEquals(grandtotal1, grandtotal3);
		driver.findElement(By.cssSelector(".cart-totals ul button")).click();
		wait.until(ExpectedConditions.titleContains("Checkout"));
		driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='checkout-shipping-method-load']/dl/dt")));
		driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/button")).click();
		WebElement paymentcheckbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[title*='Check / Money ']")));
		paymentcheckbox.click();
		driver.findElement(By.xpath("//*[@id='payment-buttons-container']/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout-review-table']")));
		driver.findElement(By.xpath("//*[@id='review-buttons-container']/button")).click();
		wait.until(ExpectedConditions.titleContains("Magento Commerce"));
		/*
		 * String ordermessage=driver.findElement(By.cssSelector(
		 * ".page-title h1")).getText(); Assert.assertEquals(ordermessage,
		 * "Your order has been received.");
		 */
		WebElement ordernumber = driver.findElement(By.xpath("//div[@class='col-main']/p[1]/a"));
		try {
			Assert.assertEquals(true, ordernumber.isDisplayed());
			System.out.println("The order Number is: " + ordernumber.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		softassert.assertAll();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
