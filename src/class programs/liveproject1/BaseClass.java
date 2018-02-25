package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public WebDriver driver;
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void openURL(String url){
		driver.get(url);		
	}
	public void enterText(By loc, String data){
		driver.findElement(loc).sendKeys(data);	
	}
	public void click(By loc){
		driver.findElement(loc).click();		
	}

	public void select(By loc,String data){
		new Select(driver.findElement(loc)).selectByVisibleText(data);	
	}
	public void alert_OK(){
		driver.switchTo().alert().accept();
	}
	public void alert_Cancel(){
		driver.switchTo().alert().dismiss();
	}
	public void childWindow(String windowName){
		driver.switchTo().window(windowName);
	}
	public void wait(int time) throws Exception{
		Thread.sleep(time);
	}

}












