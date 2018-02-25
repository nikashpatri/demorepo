package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser_test {
	WebDriver driver;

	public void openpage() throws Exception 
{
	for(int i=0; i<3; i++)
	{
	driver.get("http://selenium4testing.com/hms/");
	String[] name={"admin","rashmi","user2","admin"};
	String[] password={"admin","user1","uwer3","admin"};
	driver.findElement(By.name("username")).sendKeys(name[i]);
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys(password[i]);
	Thread.sleep(3000);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(3000);
	}
 }
	
	public void ie()
	{
		System.setProperty("webdriver.ie.driver", "D:\\selenium\\lib\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void fox()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void chrome()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void safari()
	{
		driver=new SafariDriver();
	}
public static void main(String[] args) throws Exception
{
	 Browser_test obj=new  Browser_test();
	// obj.fox();
	 //obj.ie();
	 //obj.chrome();
	 //obj.openpage();
	 //obj.safari();
	 obj.openpage();
}

}
