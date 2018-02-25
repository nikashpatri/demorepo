package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parametergmail {
	WebDriver driver;
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
	public void openurl()
	{
		driver.get("https://accounts.google.com/signin/v2/sl/pwd?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default&service=mail&scc=1&passive=1209600&sacu=1&ignoreShadow=0&acui=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin#Email=nikumarpatri1993%40gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
		driver.findElement(By.name("password")).sendKeys("1001304065");
		driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/content/span")).click();
    }
	public void navigate(String a)
	{
		driver.findElement(By.linkText(a)).click();
	}
	public void logout()
	{
		driver.findElement(By.xpath("//div[@id='gb']/div/div/div[2]/div[4]/div/a/span")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
	}
	public static void main(String[] args)
	{
		Parametergmail pm=new Parametergmail();
		pm.openbrowser();
		pm.openurl();
		pm.navigate("Starred");
		pm.navigate("Important");
		pm.navigate("Sent Mail");
		pm.navigate("Drafts");
		pm.logout();
		
	}
	
	
}
	
	
		
		
		
	


