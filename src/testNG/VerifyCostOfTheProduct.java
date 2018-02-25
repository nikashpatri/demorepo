package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyCostOfTheProduct {
	WebDriver driver;

	@Test
	public void verifyCostOfTheProductIsEqualInListAndDetailsPage() {
		driver.findElement(By.xpath("//div[@id='header-nav']/nav/ol/li[1]/a")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.titleContains("Mobile"));
		String price1 = driver.findElement(By.xpath("//*[@id='product-price-1']/span")).getText();
		double listprice = Double.parseDouble(price1.substring(1));
		driver.findElement(By.cssSelector("a[title='Sony Xperia']")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.titleContains("Sony Xperia - Mobile"));
		String price2 = driver.findElement(By.cssSelector("span[class='price']")).getText();
		double detailprice = Double.parseDouble(price2.substring(1));
		try {
			Assert.assertEquals(listprice, detailprice);
		} catch (Exception e) {
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
