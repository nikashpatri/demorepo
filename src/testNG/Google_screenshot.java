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
import org.testng.annotations.AfterTest;

public class Google_screenshot {
	WebDriver driver;

	public void select(String language) throws Exception {
		driver.navigate().to("https://www.google.co.in/");
		driver.findElement(By.xpath(language)).click();
		Thread.sleep(3000);
	}

	public void screenshot(String str) throws Exception {
		TakesScreenshot shot;
		shot = (TakesScreenshot) driver;
		File srcfile;
		srcfile = shot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("D:\\Workspacefor selenium\\selenium_webdriver\\" + str + ".png");
		FileUtils.copyFile(srcfile, destfile);
	}

	@Test
	public void lang1() throws Exception {
		select("//div[@id='_eEe']/a");
		screenshot("lang1");
	}

	@Test
	public void lang2() throws Exception {
		select("//div[@id='_eEe']/a[2]");
		screenshot("lang2");
	}

	@Test
	public void lang3() throws Exception {
		select("//div[@id='_eEe']/a[3]");
		screenshot("lang3");
	}

	@Test
	public void lang4() throws Exception {
		select("//div[@id='_eEe']/a[4]");
		screenshot("lang4");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
