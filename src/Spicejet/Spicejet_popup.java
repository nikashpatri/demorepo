package Spicejet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Spicejet_popup {
	WebDriver driver;

	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void openurl() {
		driver.get("http://spicejet.com/");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	}

	public void select() throws InterruptedException {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[5]/td[6]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr[2]/td[3]/a")).click();

	}

	public void dropdown(String a, String b) {
		new Select(driver.findElement(By.id(a))).selectByVisibleText(b);
	}

	public void findflight() {
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

	public void popup() throws InterruptedException {
		String mainwindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Currency Converter")).click();
		driver.switchTo().window("converter");
		Thread.sleep(4000);
		new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency")))
				.selectByVisibleText("Indian Rupee(INR)");
		new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency")))
				.selectByVisibleText("Bangladesh Taka(BDT)");
		driver.findElement(By.id("CurrencyConverterCurrencyConverterView_TextBoxAmount")).sendKeys("23");
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(mainwindow);
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("AvailabilitySearchInputSelectViewdestinationStation1")))
				.selectByVisibleText("Jammu (IXJ)");
	}

	public static void main(String[] args) throws InterruptedException {
		Spicejet_popup childwindow = new Spicejet_popup();
		childwindow.openbrowser();
		childwindow.openurl();
		childwindow.select();
		childwindow.dropdown("ctl00_mainContent_ddl_Adult", "2 Adults");
		childwindow.dropdown("ctl00_mainContent_ddl_Child", "1 Child");
		childwindow.dropdown("ctl00_mainContent_ddl_Infant", "1 Infant");
		childwindow.dropdown("ctl00_mainContent_DropDownListCurrency", "Indian Rupee(INR)");
		childwindow.findflight();
		childwindow.popup();
	}
}
