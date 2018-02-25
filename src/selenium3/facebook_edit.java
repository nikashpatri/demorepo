package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class facebook_edit {
WebDriver driver;

public void openpage()
{
	System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com");
}
public void find(String username,String password) throws Exception
{
	driver.findElement(By.xpath(username)).sendKeys(password);
	Thread.sleep(2000);
}
public void click(String path) throws Exception
{
	
	driver.findElement(By.xpath(path)).click();
	Thread.sleep(2000);
}
public void quit()
{
	driver.quit();
}
public void alert() throws Exception
{
	String alert=driver.switchTo().alert().getText();
	System.out.println(alert);
	driver.switchTo().alert().dismiss();
	Thread.sleep(2000);
}
public static void main(String[] args) throws Exception
{
	facebook_edit obj=new facebook_edit();
	obj.openpage();
	obj.find("//div[@class='menu_login_container rfloat _ohf']/form/table/tbody/tr[2]/td/input","9658524262");
	obj.find("//div[@class='menu_login_container rfloat _ohf']/form/table/tbody/tr[2]/td[2]/input", "nikash19934065");
	obj.click("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/label/input");
	//obj.alert();
	//obj.driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/label/input")).click();
	obj.click("//*[@id='u_0_4']/div[1]/div[1]/div/a/span");
	obj.click("html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div[3]/div/div[2]/div[2]/ul/li[2]/a");
	obj.click("//*[text()='Contact and Basic Info']");
	obj.click("//a[contains(@href, '/profile/edit/infotab/forms/?field_type=address')]");
	obj.find("//*[@name='current_address']", "odisha");
	obj.click("//*[@name='__submit__']");
	obj.click("//*[@id='userNavigationLabel']");
	//obj.click("//form[@id='show_me_how_logout_1']");
	obj.click("//*[text()='Log Out']");
	obj.quit();
	
	
}
}

