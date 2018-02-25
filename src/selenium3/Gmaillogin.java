package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmaillogin {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.id("identifierId")).sendKeys("nikumarpatri1993");
		driver.findElement(By.className("CwaK9")).click();
	    driver.findElement(By.name("password")).sendKeys("100130406");
	    //driver.findElement(By.name("password")).clear();
	 
		//driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/content/span")).click();
		//driver.findElement(By.xpath("//form/div[2]/div/div/div[2]/div[2]")).click();
		//driver.findElement(By.xpath("//div/a/span")).click();
		//driver.findElement(By.id("gb_71")).click();
		//driver.quit();
		
		
	}

}
