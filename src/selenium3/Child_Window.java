package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Child_Window {
    WebDriver driver;
    public void openbrowser()
    {
    	System.setProperty("webdriver.chrome.driver","D:\\selenium\\lib\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    public void openpage()
    {
    	driver.get("http://selenium4testing.com/hms");
    	driver.findElement(By.name("username")).sendKeys("admin");
    	driver.findElement(By.name("password")).sendKeys("admin");
    	driver.findElement(By.name("submit")).click();
    	driver.findElement(By.linkText("Feedback")).click();
    }
    public void popup() throws Exception
    {
     String windowname;
     windowname=driver.getWindowHandle();
     driver.switchTo().window("mywindow");
     driver.findElement(By.id("name")).sendKeys("nikash");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@type='checkbox']")).click();
     Thread.sleep(2000);
     driver.switchTo().window(windowname);
    }
    public static void main(String[] args) throws Exception
    {
    	 Child_Window obj=new  Child_Window();
    	 obj.openbrowser();;
    	 obj.openpage();
    	 obj.popup();
    	 obj.driver.quit();
    	 
    }
	
    

}
