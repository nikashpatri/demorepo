package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestCase8 {
	WebDriver driver;
	String emailid = "nikumarpatri1993@gmail.com";
	String password = "nikashpatri";
	SoftAssert softassert = new SoftAssert();

	@Test
	public void f() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id='header-account']/div/ul/li[1]/a")).click();
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.cssSelector("#email")).sendKeys(emailid);
		driver.findElement(By.cssSelector("#pass")).clear();
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		wait.until(ExpectedConditions.titleContains("My Account"));
		driver.findElement(By.xpath("//table[contains(@id,'my')]/tbody/tr[1]/td[6]/span/a[2]")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		String grandtotal=driver.findElement(By.cssSelector("table[id*='totals-table'] tfoot tr td:last-child strong span")).getText().substring(1);
		int index=grandtotal.indexOf(',');
		String oldgrandtotal=new StringBuffer(grandtotal).deleteCharAt(index).toString();
		driver.findElement(By.cssSelector("input[title='Qty']")).clear();
		driver.findElement(By.cssSelector("input[title='Qty']")).sendKeys("10");
		driver.findElement(By.cssSelector(".button.btn-update")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		String grandtotal1=driver.findElement(By.cssSelector("table[id*='totals-table'] tfoot tr td:last-child strong span")).getText().substring(1);
		int index1=grandtotal1.indexOf(',');
		String newgrandtotal=new StringBuffer(grandtotal1).deleteCharAt(index1).toString();
		try{
		softassert.assertNotEquals(oldgrandtotal, newgrandtotal);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".cart-totals ul button")).click();
		wait.until(ExpectedConditions.titleContains("Checkout"));
		driver.findElement(By.cssSelector("div[id^='billing-buttons'] button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sp-methods dt")));
		driver.findElement(By.cssSelector("div[id^='shipping-method'] button")).click();
		WebElement moneyorder=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#p_method_checkmo")));
		moneyorder.click();
		driver.findElement(By.cssSelector("div[id^='payment-buttons'] button")).click();
		WebElement placeorder=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.btn-checkout")));
		placeorder.click();
		wait.until(ExpectedConditions.titleContains("Magento Commerce"));
		try{
		String ordernumber=driver.findElement(By.cssSelector("div[class='col-main'] p:nth-of-type(1) a")).getText();
		System.out.println("order number is "+ordernumber);
		}
		catch(NoSuchElementException e){
			System.out.println("order not placed");
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
