package hms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Admission {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("ADT")).click();
		driver.findElement(By.linkText("Admission")).click();
		driver.findElement(By.name("PNT_ID")).sendKeys("1234567");
		driver.findElement(By.name("BOOKING_ID")).sendKeys("nikash patri");
		driver.findElement(By.name("REQ_ID")).sendKeys("76895435");
		driver.findElement(By.name("MR_NO")).sendKeys("PR3942636577");
		new Select(driver.findElement(By.name("ADM_TPYE"))).selectByVisibleText("Accident");
		new Select(driver.findElement(By.name("PNT_CLASS"))).selectByVisibleText("ICU");
		new Select(driver.findElement(By.name("INSU_PLAN"))).selectByVisibleText("Yes");
		new Select(driver.findElement(By.name("ADM_SOURSE"))).selectByVisibleText("General");
		new Select(driver.findElement(By.name("HOSPITAL_SERVICES"))).selectByVisibleText("Scanning");
		new Select(driver.findElement(By.name("HOSPITAL_SUB_SERVICES"))).selectByVisibleText("X-Ray");
		driver.findElement(By.name("PROVI_DIAGNOS")).sendKeys("Diagnosis");
		driver.findElement(By.name("CHIEF_COMPLAINT")).sendKeys("complaints");
		driver.findElement(By.name("NOTES")).sendKeys("NOTES");
		new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("Yes");
		driver.findElement(By.name("EXP_DATE")).click();
		driver.findElement(By.xpath("//table[@id='tcalGrid']/tbody/tr[4]/td[5]")).click();
		driver.findElement(By.name("EXP_STAY_DATE")).sendKeys("3");
		new Select(driver.findElement(By.name("EXP_STAY_FORMAT"))).selectByVisibleText("Months");
		driver.findElement(By.name("EXP_DISCHARGE_DATE")).click();
		driver.findElement(By.xpath("//table[@id='tcalGrid']/tbody/tr[5]/td[6]")).click();
		new Select(driver.findElement(By.name("DOC_NAME"))).selectByVisibleText("Sai");
		new Select(driver.findElement(By.name("DOC_SPL"))).selectByVisibleText("Cordialagist");
		driver.findElement(By.name("PRMRY_CONSULT")).sendKeys("consultant doctor");
		new Select(driver.findElement(By.name("ADD_DOC_SPL"))).selectByVisibleText("Cordialagist");
		new Select(driver.findElement(By.name("ADD_DOC_NAME"))).selectByVisibleText("Sai");
		driver.findElement(By.name("EPISODE_NO")).sendKeys("456679");
		driver.findElement(By.name("EPISODE_DEC")).sendKeys("Great episode");
		driver.findElement(By.name("ENCOUNTER_NO")).sendKeys("786904");
		new Select(driver.findElement(By.name("BED_CLASS"))).selectByVisibleText("A/C");
		new Select(driver.findElement(By.name("ADM_BED_CLASS"))).selectByVisibleText("A/C");
		new Select(driver.findElement(By.name("BED_NUM"))).selectByVisibleText("BED-2");
		new Select(driver.findElement(By.name("NURSING_STATION"))).selectByVisibleText("Rani");
		new Select(driver.findElement(By.name("WARD_NUM"))).selectByVisibleText("9");
		new Select(driver.findElement(By.name("AMBULATORY_STATUS"))).selectByVisibleText("Ambulance");
		new Select(driver.findElement(By.name("MODE_ARRIVAL"))).selectByVisibleText("Walking");
		driver.findElement(By.name("PNT_VALUBLES")).sendKeys("Highly satisfied");
		new Select(driver.findElement(By.name("CAPTURED_BY"))).selectByVisibleText("Admin");
		driver.findElement(By.name("CAPTURED_DATE")).click();
		driver.findElement(By.xpath("//table[@id='tcalGrid']/tbody/tr[5]/td[6]")).click();
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
