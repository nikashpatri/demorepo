package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class PR_Bloodgroupdropdown_HMS {
	WebDriver driver;

	@Test
	public void f() throws Exception {

		List<WebElement> s = new Select(
				driver.findElement(By.xpath("//*[@id='form1']/div[1]/table/tbody/tr[10]/td[4]/select"))).getOptions();
		System.out.println("the size of collection is:" + s.size());
		for (int i = 0; i < s.size(); i++) {
			// System.out.println(s.get(i).getText());
			if (s.get(i).getText().equalsIgnoreCase("o+")) {
				new Select(driver.findElement(By.xpath("//*[@id='form1']/div[1]/table/tbody/tr[10]/td[4]/select")))
						.selectByVisibleText(s.get(i).getText());
			}
		}
		Thread.sleep(2000);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Permanent Registration")).click();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
