package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HMS_LoginPage_Components extends BaseClass{
	HMS_LoginPage_Locators loginPage=new HMS_LoginPage_Locators();
	
	public void launchApp(){
		openBrowser();
		openURL("http://selenium4testing.com/hms");
	}
	public void login(){
		enterText(loginPage.username,"admin");
		enterText(loginPage.password,"admin");
		click(loginPage.login);
	}
	public void navigateToPR(){
		click(loginPage.registration);
		click(loginPage.permanentRegistration);
	}
	public void createPatient(){
		select(loginPage.patientCategory,"Self");
		select(By.name("RELATION"),"Father");
		select(By.name("TITLE"),"Mr.");
		enterText(By.name("PNT_NAME"),"john");
		click(By.name("DOB"));
	click(By.xpath("//table[@id='tcalGrid']/tbody/tr[3]/td[4]"));
	enterText(By.name("image"),"E:\\Photos\\Indian.png");
	click(By.xpath("//input[@value='Clear']"));
	}

	}







