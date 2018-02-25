package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_lang_selection {
WebDriver driver;

public void openbrowser()
{
	 System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.navigate().to("https://www.google.co.in/");
}
public void selectlanuguage(String link)
{
	driver.findElement(By.xpath(link)).click();
}
public static void main(String[] args)
{
	 Google_lang_selection obj=new  Google_lang_selection();
	 obj.openbrowser();
	 String[] value={"//div[@id='_eEe']/a","//div[@id='_eEe']/a[2]","//div[@id='_eEe']/a[3]","//div[@id='_eEe']/a[4]"};
	 for(int i=0;i<=3;i++)
	 {
		 obj.selectlanuguage(value[i]);
	 }
	 
	/* obj.selectlanuguage("//div[@id='_eEe']/a");
	 obj.selectlanuguage("//div[@id='_eEe']/a[2]");
	 obj.selectlanuguage("//div[@id='_eEe']/a[3]");
	 obj.selectlanuguage("//div[@id='_eEe']/a[4]");*/
}
}