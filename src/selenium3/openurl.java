package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
//import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openurl {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http:\\google.co.in");
		//driver.findElement(By.className("gsfi")).sendKeys("gmail");
		//driver.findElement(By.className("sbico-c")).click();
		//driver.findElement(By.xpath("//div[3]/div/a")).click();
		driver.findElement(By.className("//div/div/a")).click();
	}
	
	
	
}
