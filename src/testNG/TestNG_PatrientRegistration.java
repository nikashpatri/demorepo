package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class TestNG_PatrientRegistration {
	WebDriver driver;
	Logger log = Logger.getLogger(TestNG_PatrientRegistration.class);

	@Test
	public void login() throws Exception {
		PropertyConfigurator.configure("log4j.properties"); // enough for configuring log4j
		//Logger.getRootLogger().setLevel(Level.INFO); // changing log level
		
		driver.findElement(By.name("username")).sendKeys("admin");
		log.info("entered username");
		driver.findElement(By.name("password")).sendKeys("admin");
		log.info("entered password");
		driver.findElement(By.name("submit")).click();
		log.info("clicked on submit");
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Permanent Registration")).click();
		Thread.sleep(2000);
		// System.out.println("atest executed");
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
		// System.out.println("btest executed");
		Thread.sleep(2000);
	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String value) {

		
		  if (value.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver",
		  "D:\\selenium\\Lib\\geckodriver.exe"); driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.get("http://selenium4testing.com/hms/"); log.info(
		  "opened firefoxf browser"); } else if
		  (value.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver",
		  "D:\\selenium\\Lib\\chromedriver.exe"); driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://selenium4testing.com/hms/"); log.info(
		  "opened chrome browser");
		  
		  } else if (value.equalsIgnoreCase("ie")) {
		  System.setProperty("webdriver.ie.driver",
	  "D:\\selenium\\Lib\\IEDriverServer.exe"); driver = new
		  InternetExplorerDriver(); driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.get("http://selenium4testing.com/hms/"); log.info(
		  "opened ie browser");
		  }

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
