package hms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {

	public static void main(String[] args) throws Exception 
	{
		String message;
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		WebDriver reg=new ChromeDriver();
		reg.manage().window().maximize();
		reg.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		reg.get("http://selenium4testing.com/hms/");
		reg.findElement(By.name("username")).sendKeys("admin");
		reg.findElement(By.name("password")).sendKeys("admin");
		reg.findElement(By.name("submit")).click();
		reg.findElement(By.linkText("Registration")).click();
		reg.findElement(By.linkText("Permanent Registration")).click();
		new Select(reg.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Self");
		new Select(reg.findElement(By.name("RELATION"))).selectByVisibleText("Father");
		new Select(reg.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
		reg.findElement(By.name("MOTHER_NAME")).sendKeys("anjali patri");
		reg.findElement(By.name("PNT_NAME")).sendKeys("nikash");
		reg.findElement(By.name("LAST_NAME")).sendKeys("patri");
		reg.findElement(By.name("DOB")).click();
		reg.findElement(By.xpath("//table[@id='tcalGrid']/tbody/tr[4]/td[4]")).click();
		reg.findElement(By.name("AGE")).sendKeys("24");
		new Select(reg.findElement(By.name("SEX"))).selectByVisibleText("Male");
		new Select(reg.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Single");
		new Select(reg.findElement(By.name("RELIGION"))).selectByVisibleText("Hindu");
		new Select(reg.findElement(By.name("PLANGUAGE"))).selectByVisibleText("English");
		new Select(reg.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("PAN Card");
		reg.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("123976");
		new Select(reg.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
		new Select(reg.findElement(By.name("IS_MLC"))).selectByVisibleText("Yes");
		new Select(reg.findElement(By.name("EDUCATION"))).selectByVisibleText("B.Tech");
		new Select(reg.findElement(By.name("OCCUPATION"))).selectByVisibleText("Employee");
		new Select(reg.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("O+");
		new Select(reg.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
		new Select(reg.findElement(By.name("SC_PROOF"))).selectByVisibleText("No");
		reg.findElement(By.name("ADDRESS1")).sendKeys("rourkela");
		reg.findElement(By.name("MOBILE_NO")).sendKeys("9658524262");
		reg.findElement(By.name("EMAIL_ID")).sendKeys("nikumarpatri1993@gmail.com");
		reg.findElement(By.name("ZIP")).sendKeys("769042");
		new Select(reg.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");
		reg.findElement(By.name("ADDRESS2")).sendKeys("rs colony");
		
		reg.findElement(By.name("image")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
		reg.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		message=reg.switchTo().alert().getText();
		System.out.println(message);
		Thread.sleep(3000);
		reg.switchTo().alert().accept();
	}

}
