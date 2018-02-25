package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4Links_Junit {
WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
		/*driver.get("http://selenium4testing.com/");
		driver.findElement(By.id("closediv")).click();*/
	}

	@After
	public void teardown() throws Exception {
		
			driver.quit();
	}

	@Test
	public void login() throws Exception {
		//driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Permanent Registration")).click();
		Thread.sleep(2000);
		
	}
	@Test
	public void registration() throws Exception
	{
		driver.findElement(By.name("MOTHER_NAME")).sendKeys("anjali patri");
		driver.findElement(By.name("PNT_NAME")).sendKeys("nikash");
		driver.findElement(By.name("LAST_NAME")).sendKeys("patri");
		driver.findElement(By.name("DOB")).click();
		driver.findElement(By.xpath("//table[@id='tcalGrid']/tbody/tr[4]/td[4]")).click();
		driver.findElement(By.name("AGE")).sendKeys("24");
		driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("123976");
		driver.findElement(By.name("ADDRESS1")).sendKeys("rourkela");
		driver.findElement(By.name("MOBILE_NO")).sendKeys("9658524262");
		driver.findElement(By.name("EMAIL_ID")).sendKeys("nikumarpatri1993@gmail.com");
		driver.findElement(By.name("ZIP")).sendKeys("769042");
		driver.findElement(By.name("image")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
		driver.findElement(By.name("submit")).click();
	}
	@BeforeClass
	public static void print()
	{
		System.out.println("execution started");
	
	}

	@AfterClass
	public static void printout()
	{
		System.out.println("execution completed");
	}
}
