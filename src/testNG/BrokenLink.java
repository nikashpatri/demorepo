package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BrokenLink {
	WebDriver driver;

	public void verifyURL(String link) throws IOException{
		URL url=new URL(link);
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		connection.connect();
		if(connection.getResponseCode()==200)
		
			System.out.println(link+"  "+connection.getResponseMessage());
		else
			System.out.println(link+"  "+connection.getResponseMessage());
	}

	@Test
	public void testLink() throws IOException {
		List<WebElement> links = driver.findElements(By.tagName("img"));
		for (WebElement element : links) {
			String link = element.getAttribute("src");
			verifyURL(link);
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
