package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Hms_screenshot {
	WebDriver driver;
	public void openpage()
	{
		 driver.get("http://selenium4testing.com/hms/");
	}
	public void takescreenshot(String name) throws Exception
	{
		SimpleDateFormat df=new SimpleDateFormat("YYYY_MM_DD");
		Date d=new Date();
		String time=df.format(d);
		System.out.println(time);
	    TakesScreenshot shot;
		shot=(TakesScreenshot)driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Workspacefor selenium\\selenium_webdriver\\"+name+time+".png");
		FileUtils.copyFile(src,dest);
		}
	
  @Test
  public void atest1() throws Exception {
	  openpage();
	  takescreenshot("hms_login");
	    driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Permanent Registration")).click();
		Thread.sleep(2000);
		System.out.println("atest executed");
  }
  @Test
  public void btest2() throws Exception
  {
	        takescreenshot("hms_regd");
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
			takescreenshot("hms_regd");
			System.out.println("btest executed");
			Thread.sleep(2000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //driver.get("http://selenium4testing.com/hms/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
