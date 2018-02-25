package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		
		driver.findElement(By.id("identifierId")).sendKeys("testingse2@gmail.com");
	//	driver.findElement(By.className("RveJvd.snByac")).click();
		driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
		//driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("selenium3");
		//driver.findElement(By.className("RveJvd.snByac")).click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
	}

}
