package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Explicitwait {
	WebDriver driver;

	public void waitforelement(By loc) throws Exception {
		for (int i = 0; i < 20; i++) {
			int sec=0;
			try {
				driver.findElement(loc).isDisplayed();
				System.out.println("waited for:"+sec+"seconds");
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				sec++;
			}
		}
	}

	@Test(enabled=false)
	public void f() throws Exception {
		driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Search Registration")).click();
		waitforelement(By.name("search"));
		driver.findElement(By.name("search")).sendKeys("nikash");

	}
	@Test
	public void spicejet() throws Exception
	{
		driver.get("https://book2.spicejet.com/");
		driver.findElement(By.xpath(".//*[@id='custom_date_picker_id_1']")).click();
		waitforelement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[2]/a"));
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[2]/a")).click();
		waitforelement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[5]/a"));
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[5]/a")).click();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
