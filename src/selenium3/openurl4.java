package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openurl4 {
	public static void main(String[] args)
	{
		
		for(int i=0;i<=0;i++)
		{
			System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://en.wikipedia.org/wiki/Performing_arts");
			driver.findElement(By.className("toctext")).click();
		    /*String username[]={"user1","usser"}; 
			String password[]={"user1","usser"};
		driver.findElement(By.name("username")).sendKeys(username[i]);
		driver.findElement(By.name("password")).sendKeys(password[i]);
		driver.findElement(By.className("log")).click();*/
		//driver.findElement(By.xpath("//ul[@id='navigation']/li/ul/li[2]/a")).click();
		System.out.println("executed");
		}
				}
}
