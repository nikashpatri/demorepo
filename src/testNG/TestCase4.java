package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase4 {
	WebDriver driver;
	List<String> list1 = new ArrayList<String>();
	SoftAssert soft=new SoftAssert();

	@Test
	public void verifyCompareProductPopup() {
		list1 = new ArrayList<String>();
		driver.findElement(By.xpath("//div[@id='header-nav']/nav/ol/li[1]/a")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.titleContains("Mobile"));
		list1.add(driver.findElement(By.cssSelector("a[title='Sony Xperia']")).getText());
		driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[1]/div/div[3]/ul/li[2]/a")).click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.titleContains("Mobile"));
		list1.add(driver.findElement(By.cssSelector("a[title='IPhone']:not([class*='product'])")).getText());
		driver.findElement(By.xpath("//ul[contains(@class,'products-grid')]/li[2]/div/div[3]/ul/li[2]/a")).click();
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.titleContains("Mobile"));
		driver.findElement(By.xpath("//div[contains(@class,'block-compare')]/div[2]/div/button")).click();
		Object[] windows = driver.getWindowHandles().toArray();
		driver.switchTo().window(windows[1].toString());
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		WebElement element =wait4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='page-title'] h1")));
		String popupname = element.getText().toLowerCase();
		
		soft.assertEquals(popupname, "compare products");
			
		List<WebElement> list2 = driver.findElements(By.xpath("//table[@id='product_comparison']/tbody/tr/td/h2/a"));
		Assert.assertEquals(list1.size(), list2.size(), "Number of items doesn't match");
		for (int i = 0; i < list2.size(); i++) {
			String str1 = list2.get(i).getText();
			boolean flag = false;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).equals(str1)) {
					System.out.print(list1.get(j)+"...");
					flag = true;
					break;
				}
			}
			if (!flag)
				Assert.assertTrue(false);
		}
		soft.assertAll();
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
