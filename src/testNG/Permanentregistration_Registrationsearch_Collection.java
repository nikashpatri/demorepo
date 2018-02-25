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

public class Permanentregistration_Registrationsearch_Collection {
	WebDriver driver;
	public void dropdown(String a,String b)
	{
		new Select(driver.findElement(By.name(a))).selectByVisibleText(b);
	}
	
	public void alert() throws Exception 
	{
		String prno="";
		String message;
		message=driver.switchTo().alert().getText();
		System.out.println(message);
		//driver.switchTo().alert().accept();
		String [] str=message.split(" ");
		for (int i = 0; i < str.length; i++) {
			if(str[i].contains("PR"))
			{
				prno=str[i];
			}
		}
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Search Registration")).click();
		driver.findElement(By.name("search")).sendKeys(prno);
		driver.findElement(By.name("submit")).click();
		String s=driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/form/div/table[3]")).getText();
		String[] s1=s.split("\n");
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]);
			}
		Thread.sleep(2000);
	}
	
	
  @Test
  public void f() throws Exception {
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
		dropdown("PATIENT_CAT", "Self");
		dropdown("RELATION", "Father");
		dropdown("TITLE", "Mr.");
		dropdown("SEX", "Male");
		dropdown("MTRL_STATUS", "Single");
		dropdown("RELIGION", "Hindu");
		dropdown("PLANGUAGE", "English");
		dropdown("PAT_IDENTITY", "PAN Card");
		dropdown("NATIONALITY", "Indian");
		dropdown("IS_MLC", "Yes");
		dropdown("EDUCATION", "B.Tech");
		dropdown("OCCUPATION", "Employee");
		dropdown("BLOOD_GRP_CODE", "O+");
		dropdown("CITIZENSHIP", "Indian");
		dropdown("SC_PROOF", "No");
		dropdown("COUNTRY_CODE", "India");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		alert();
  }
  @BeforeTest
  public void beforeTest() {
	     System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
