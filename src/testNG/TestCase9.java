package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase9 {
	WebDriver driver;
	String emailid = "nikumarpatri1993@gmail.com";
	String password = "nikashpatri";

	@Test
	public void verifyDiscountIsApplied() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id='header-account']/div/ul/li[1]/a")).click();
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.cssSelector("#email")).sendKeys(emailid);
		driver.findElement(By.cssSelector("#pass")).clear();
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		wait.until(ExpectedConditions.titleContains("My Account"));
		driver.findElement(By.cssSelector("#nav ol li[class*='first'] a")).click();
		wait.until(ExpectedConditions.titleContains("Mobile"));
		driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[2]/div/div[3]/button")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		driver.findElement(By.cssSelector("input[title='Qty']")).clear();
		driver.findElement(By.cssSelector("input[title='Qty']")).sendKeys("1");
		driver.findElement(By.cssSelector(".button.btn-update")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		String total1=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText().substring(1);
		double grandtotal1=Double.parseDouble(total1);
		driver.findElement(By.cssSelector("#coupon_code")).clear();
		driver.findElement(By.cssSelector("#coupon_code")).sendKeys("GURU50");
		driver.findElement(By.cssSelector("button[title='Apply']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[1]")));
		String discount=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText().substring(2);
		double discountprice=Double.parseDouble(discount);
		double calculatedgrandtotal=grandtotal1-discountprice;
		String displayedtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText().substring(1);
		double displayedgrandtotal=Double.parseDouble(displayedtotal);
		if(displayedgrandtotal==calculatedgrandtotal){
			System.out.println("displayvalue: "+displayedgrandtotal+" claculatedvalue: "+calculatedgrandtotal);
			Assert.assertTrue(true);
		}
		else
			System.out.println("displayvalue: "+displayedgrandtotal+" claculatedvalue: "+calculatedgrandtotal);
			System.out.println("discount has not been applied to the total price");
			Assert.assertTrue(false);
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
