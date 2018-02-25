package testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

public class SeleniumGrid {
  @Test
  public void test1() throws MalformedURLException {
	  
	  DesiredCapabilities cap=new DesiredCapabilities();
	  cap.setCapability("browserName", "chrome");
	  cap.setPlatform(Platform.WINDOWS);
	 // cap.setCapability("chromedriverExecutable", "D:\\selenium\\lib\\chromedriver.exe");
	  URL url=new URL("http://localhost:4445/wd/hub");
	  WebDriver driver=new RemoteWebDriver(url,cap);
	  driver.get("https://www.google.co.in/");
	  String title=driver.getTitle();
	  System.out.println("Title is: "+title);
	  driver.quit();
  }
}