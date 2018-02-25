package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethod {
	WebDriver driver;
public  void openbrowser()
{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
public void openurl(String url)
{
    driver.navigate().to(url);
	
}
public  static void main(String[] args) throws Exception
{
	NavigationMethod obj=new NavigationMethod();
	obj.openbrowser();
	obj.openurl("http://selenium4testing.com/");
	Thread.sleep(2000);
	obj.openurl("http://selenium4testing.com/about-us/");
	Thread.sleep(2000);
	obj.openurl("http://selenium4testing.com/manual-faqs/");
	Thread.sleep(2000);
	obj.openurl("http://selenium4testing.com/core-java-faqs/");
	
	
}
}
