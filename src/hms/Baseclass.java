package hms;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	WebDriver driver;
     public void openbrowser()
     {
    	 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
    	 driver=new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }
     public void openurl(String url)
     {
    	 driver.get(url);
     }
     public void entertext(By loc,String data)
     {
    	 driver.findElement(loc).sendKeys(data);
     }
     public void click(By loc)
     {
    	 driver.findElement(loc).click();
     }
     public void select(By loc,String value)
     {
    	 new Select(driver.findElement(loc)).selectByVisibleText(value);
     }
     public void alert_ok()
     {
    	 String message=driver.switchTo().alert().getText();
    	 System.out.println(message);
    	 driver.switchTo().alert().accept();
     }
     public void alert_cancel()
     {

    	 String message=driver.switchTo().alert().getText();
    	 System.out.println(message);
    	 driver.switchTo().alert().dismiss();
     }
     public void childwindow(String windowname)
     {
    	 driver.switchTo().window(windowname);
     }
     public void screenshot(String image_name) throws Exception
     {
    	 TakesScreenshot shot=(TakesScreenshot)driver;
    	 File srcfile=shot.getScreenshotAs(OutputType.FILE);
    	 File destfile=new File("D:\\Workspacefor selenium\\selenium_webdriver\\"+ image_name+".png");
    	 FileUtils.copyFile(srcfile, destfile);
    	 
     }
     
     
     
     
     
     
     
     
     
     
}