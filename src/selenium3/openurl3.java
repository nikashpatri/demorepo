package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openurl3 {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\lib\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/watch?v=3gQdOltJ89k");
		
	}

}
