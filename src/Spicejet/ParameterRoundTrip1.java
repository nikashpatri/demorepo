package Spicejet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class ParameterRoundTrip1 {
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

	public static void main(String[] args) throws InterruptedException {
		ParameterRoundTrip1 oneway = new ParameterRoundTrip1();
		oneway.openbrowser();
		oneway.openurl();
		oneway.select();
		oneway.dropdown("ctl00_mainContent_ddl_Adult", "2 Adults");
		oneway.dropdown("ctl00_mainContent_ddl_Child", "1 Child");
		oneway.dropdown("ctl00_mainContent_ddl_Infant", "1 Infant");
		oneway.dropdown("ctl00_mainContent_DropDownListCurrency", "Indian Rupee(INR)");
		oneway.findflight();

	}
}
