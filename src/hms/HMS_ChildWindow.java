package hms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HMS_ChildWindow {
	WebDriver driver;
	public void openpage()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
	}
	public void login(String a,String b)
	{
		driver.findElement(By.name(a)).sendKeys(b);
	}
	public void popup() throws Exception
	{
		String mainwindow=driver.getWindowHandle();
		driver.findElement(By.linkText("Feedback")).click();
		driver.switchTo().window("mywindow");
		driver.findElement(By.id("name")).sendKeys("nikash patri");
		driver.findElement(By.id("email")).sendKeys("nikumarpatri1993@gmail.com");
		new Select(driver.findElement(By.id("car"))).selectByVisibleText("Volvo");
		driver.findElement(By.id("message")).sendKeys("Had a great experience with your organization");
		Thread.sleep(3000);
		driver.close();
	    driver.switchTo().window(mainwindow);
	    driver.findElement(By.linkText("ADT")).click();
	}
	public static void main(String[] args) throws Exception
	{
		HMS_ChildWindow child=new HMS_ChildWindow();
		child.openpage();
		child.login("username", "admin");
		child.login("password", "admin");
		child.driver.findElement(By.name("submit")).click();
	    child.popup();
	}
	
	
}
