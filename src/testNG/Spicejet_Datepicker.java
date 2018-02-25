package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Spicejet_Datepicker {
	WebDriver driver;

	@Test
	public void f() {
		driver.findElement(By.xpath(".//*[@id='custom_date_picker_id_1']")).click();
		int j=0;
		for (int i = 0; i <= 6; i++) {

			String str = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
			if (str.equalsIgnoreCase("December")) {
				
				break;
			} else {
				driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
				j++;
			}

		}
		System.out.println("December found in the datepicker at:"+j);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://book2.spicejet.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
