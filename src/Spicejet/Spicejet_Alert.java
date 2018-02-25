package Spicejet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Spicejet_Alert {
	WebDriver driver;

	public void openpage()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://spicejet.com/");
	}
	public void givedetails() throws Exception
	{
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr[2]/td[2]/div[3]/div/div/ul/li[6]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[4]/td[5]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[5]/td[7]/a")).click();
		//driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
	}
	public void passengerlist(String a,String b)
	{
		new Select(driver.findElement(By.id(a))).selectByVisibleText(b);
	}
	public void alertmessage() throws Exception
	{
		String message;
		message=driver.switchTo().alert().getText();
		System.out.println(message);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	public static void main(String[] args) throws Exception
	{
		Spicejet_Alert alert=new Spicejet_Alert();
		alert.openpage();
		alert.givedetails();
		alert.passengerlist("ctl00_mainContent_ddl_Adult", "6 Adults");
		alert.passengerlist("ctl00_mainContent_ddl_Child", "4 Children");
		alert.passengerlist("ctl00_mainContent_ddl_Infant", "1 Infant");
		alert.driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		alert.alertmessage();
		alert.passengerlist("ctl00_mainContent_ddl_Adult", "2 Adults");
		alert.passengerlist("ctl00_mainContent_ddl_Child", "1 Child");
		alert.driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		
	}
	
}
