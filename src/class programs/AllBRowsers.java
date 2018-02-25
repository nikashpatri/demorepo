package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AllBRowsers {
	WebDriver driver;
	public void ie(){
		System.setProperty("webdriver.ie.driver", "D:\\Lib\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get("http://selenium4testing.com/hms");
	}
	public void firefox(){
		System.setProperty("webdriver.gecko.driver", "D:\\Lib\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://selenium4testing.com/hms");
	}
	public void safari(){
		driver=new SafariDriver();
		driver.get("http://selenium4testing.com/hms");
	}
	public void opera(){
		driver=new OperaDriver();
		driver.get("http://selenium4testing.com/hms");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllBRowsers a=new AllBRowsers();
		//a.ie();
		a.firefox();
	}

}
