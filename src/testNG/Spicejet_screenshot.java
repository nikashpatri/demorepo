package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Spicejet_screenshot {
	WebDriver driver;

	public void search(String a, String c, String i) throws Exception {
		driver.get("https://book2.spicejet.com/");
		driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay")).click();
		driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("26")).click();
		Thread.sleep(2000);
		new Select(driver.findElement(
				By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT")))
						.selectByVisibleText(a);
		new Select(driver.findElement(
				By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_INFANT")))
						.selectByVisibleText(i);
		new Select(driver.findElement(
				By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD")))
						.selectByVisibleText(c);
		driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit")).click();
		Thread.sleep(6000);
	}

	public void getscreenshot(String str) throws Exception {
		TakesScreenshot shot;
		shot = ((TakesScreenshot) driver);
		File srcfile;
		srcfile = shot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("D:\\Workspacefor selenium\\selenium_webdriver\\" + str + ".png");
		FileUtils.copyFile(srcfile, destfile);

	}

	@Test(description = "verify oneway search with 2 adult")
	public void test1() throws Exception {

		search("2", "0", "0");
		getscreenshot("img1");

	}

	@Test(description = "verify with 2 adults,2children,1infant")
	public void test2() throws Exception {
		search("2", "2", "1");
		getscreenshot("img2");

	}

	@Test(description = "verify with 5 adults,4children,1infant")
	public void test3() throws Exception {
		search("5", "4", "1");
		getscreenshot("img3");

	}

	@BeforeTest
	public void beforeTest() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
