package hms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Admissionadvice {
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	WebDriver ad=new ChromeDriver();
	ad.manage().window().maximize();
	ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	ad.get("http://selenium4testing.com/hms");
	ad.findElement(By.name("username")).sendKeys("admin");
	ad.findElement(By.name("password")).sendKeys("admin");
	ad.findElement(By.name("submit")).click();
	ad.findElement(By.linkText("ADT")).click();
	ad.findElement(By.linkText("Admission Advice")).click();
	ad.findElement(By.name("MR_NO")).sendKeys("ER3773533105");
	ad.findElement(By.name("PNT_NAME")).sendKeys("nikash patri");
	new Select(ad.findElement(By.name("GENDER"))).selectByVisibleText("Male");
	new Select(ad.findElement(By.name("DOC_NAME"))).selectByVisibleText("Sai");
	new Select(ad.findElement(By.name("DOC_SPL"))).selectByVisibleText("Cordialagist");
	new Select(ad.findElement(By.name("ADMISSION_TYPE"))).selectByVisibleText("Emergency");
	new Select(ad.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Self");
	new Select(ad.findElement(By.name("HOSPITAL_SERVICES"))).selectByVisibleText("Surgery");
	new Select(ad.findElement(By.name("BED_REQ"))).selectByVisibleText("Yes");
	ad.findElement(By.name("PROVI_DIOGNOS")).sendKeys("Diagnosis");
	ad.findElement(By.name("REMARKS")).sendKeys("admission advice");
	ad.findElement(By.name("EXP_DATE")).click();
	ad.findElement(By.xpath("//table[@id='tcalGrid']/tbody/tr[5]/td[4]")).click();
	ad.findElement(By.name("EXP_LENGTH")).sendKeys("2");
	new Select(ad.findElement(By.name("EXP_FORMAT"))).selectByVisibleText("Weeks");
	ad.findElement(By.name("submit")).click();
	
	
}
}
