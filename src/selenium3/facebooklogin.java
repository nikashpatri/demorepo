package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebooklogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		WebDriver driv=new ChromeDriver();
		driv.manage().window().maximize();
		driv.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		//driv.get("https://www.facebook.com/");
		driv.get("http://selenium4testing.com/");
		driv.findElement(By.id("closediv")).click();
		/*driv.findElement(By.className("_s0 _4ooo _1gax img")).click();
		driv.findElement(By.id("email")).sendKeys("9658524262");
		driv.findElement(By.id("pass")).sendKeys("nikash19934065");
		driv.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
		driv.findElement(By.id("userNavigationLabel")).click();*/
		driv.findElement(By.xpath("//li[@id='menu-item-1385']")).click();
		
	
		

	}

}
