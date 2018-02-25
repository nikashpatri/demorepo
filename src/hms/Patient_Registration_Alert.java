package hms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Patient_Registration_Alert {
	WebDriver driver;
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	public void openpage()
	{
		driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Permanent Registration")).click();
	}
	public void dropdown(String a,String b)
	{
		new Select(driver.findElement(By.name(a))).selectByVisibleText(b);
	}
	public void enterdata()
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
	public void alertmessage() throws Exception
	{
		String message;
		message=driver.switchTo().alert().getText();
		System.out.println(message);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}
	public void logout()
	{
		driver.findElement(By.linkText("Logout")).click();
	}
	public static void main(String[] args) throws Exception
	{
		Patient_Registration_Alert  alert=new Patient_Registration_Alert();
		alert.openbrowser();
		alert.openpage();
		alert.dropdown("PATIENT_CAT", "Self");
		alert.dropdown("RELATION", "Father");
		alert.dropdown("TITLE", "Mr.");
		alert.dropdown("SEX", "Male");
		alert.dropdown("MTRL_STATUS", "Single");
		alert.dropdown("RELIGION", "Hindu");
		alert.dropdown("PLANGUAGE", "English");
		alert.dropdown("PAT_IDENTITY", "PAN Card");
		alert.dropdown("NATIONALITY", "Indian");
		alert.dropdown("IS_MLC", "Yes");
		alert.dropdown("EDUCATION", "B.Tech");
		alert.dropdown("OCCUPATION", "Employee");
		alert.dropdown("BLOOD_GRP_CODE", "O+");
		alert.dropdown("CITIZENSHIP", "Indian");
		alert.dropdown("SC_PROOF", "No");
		alert.dropdown("COUNTRY_CODE", "India");
		alert.enterdata();
		alert.alertmessage();
		
		
	}


}
