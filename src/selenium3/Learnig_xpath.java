package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learnig_xpath {
WebDriver driver;	
public void openbrowser()
{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
}
public void openpage()
{
	driver.get("https://www.snapdeal.com");
}
public void navigate(String path)
{
	driver.findElement(By.xpath(path)).click();
}
public static void main(String[]args)
{
	Child_Window obj1=new Child_Window();
	obj1.openbrowser();
	obj1.openpage();
	Learnig_xpath obj=new Learnig_xpath();
	obj.openbrowser();
	obj.openpage();
	obj.navigate("//*[@id='content_wrapper']/section/section/div[1]/div[4]/div[3]");
	
}
}
