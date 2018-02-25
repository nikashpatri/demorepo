package hms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inheritance_PR extends Patient_Registration_Alert  {
	//WebDriver driver;
public void search() throws Exception
{
	driver.findElement(By.xpath("//*[@id='navigation']/li[1]/ul/li[3]/a")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("search")).sendKeys("nikash");
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.linkText("Cancel")).click();
	
}
public void handlealert() throws Exception
{
    String alertmessage;
    alertmessage=driver.switchTo().alert().getText();
    System.out.println(alertmessage);
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    Thread.sleep(3000);
}
/*public void logout()
{
	driver.findElement(By.linkText("Logout")).click();
}*/
public static void main(String[]args) throws Exception
{
	Inheritance_PR obj1=new Inheritance_PR();
	obj1.openbrowser();
	obj1.openpage();
	obj1.dropdown("PATIENT_CAT", "Self");
	obj1.dropdown("RELATION", "Father");
	obj1.dropdown("TITLE", "Mr.");
	obj1.dropdown("SEX", "Male");
	obj1.dropdown("MTRL_STATUS", "Single");
	obj1.dropdown("RELIGION", "Hindu");
	obj1.dropdown("PLANGUAGE", "English");
	obj1.dropdown("PAT_IDENTITY", "PAN Card");
	obj1.dropdown("NATIONALITY", "Indian");
	obj1.dropdown("IS_MLC", "Yes");
	obj1.dropdown("EDUCATION", "B.Tech");
	obj1.dropdown("OCCUPATION", "Employee");
	obj1.dropdown("BLOOD_GRP_CODE", "O+");
	obj1.dropdown("CITIZENSHIP", "Indian");
	obj1.dropdown("SC_PROOF", "No");
	obj1.dropdown("COUNTRY_CODE", "India");
	obj1.enterdata();
	obj1.alertmessage();
	obj1.search();
	obj1.handlealert();
	obj1.logout();
}
}