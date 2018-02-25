package testNG;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CookieHandle {
	WebDriver driver;
  @Test(enabled=true)
  public void f() throws IOException {
	  File file=new File(System.getProperty("user.dir")+"/text file/cookie.text");
	  FileWriter fw=new FileWriter(file);
	  BufferedWriter bw=new BufferedWriter(fw);		  
	 Set<Cookie> cookies= driver.manage().getCookies();
	 System.out.println("Total cookies: "+cookies.size());
	 for(Cookie ck:cookies)
	 {
		 System.out.println(ck.getName()+":"+ck.getValue());
		 bw.write(ck.getName()+":"+ck.getValue());
		 bw.newLine();
	 }
	 bw.close();
  }
  @Test(enabled=false)
  public void f1() throws IOException
  {
	  
	  File file=new File("D:\\Workspacefor selenium _Appium\\selenium_webdriver\\cookies.text");
	  FileReader reader=new FileReader(file);
	  BufferedReader br=new BufferedReader(reader);
	  while(br.readLine()!=null)
	  {
		  System.out.println(br.readLine());
		  String[] str= br.readLine().split(":");
		  String name=str[0];
		  String value=str[1];
		  Cookie ck=new Cookie(name,value);
		  driver.manage().addCookie(ck);
	  }
	  driver.get("https://www.flipkart.com");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","D:\\selenium\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
	 driver.get("https://www.flipkart.com");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
