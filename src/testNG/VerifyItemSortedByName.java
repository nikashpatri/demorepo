package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyItemSortedByName {
	
	WebDriver driver;
  @Test(priority=1)
  public void verifyTitleOfHomePage() {
	 String homepagetitle= driver.getTitle();
	 Assert.assertEquals(homepagetitle, "Home page");
  }
  
  @Test(priority=2,dependsOnMethods="verifyTitleOfHomePage")
  public void verifyTitleOfMobileListPage()
  {
	  driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element1=driver.findElement(By.xpath("//div[@class='page-title category-title']/h1"));
	  wait.until(ExpectedConditions.visibilityOf(element1));
	  String mobilepagetitle=driver.getTitle();
	  Assert.assertEquals(mobilepagetitle, "Mobile");
  }
  
  @Test(priority=3,dependsOnMethods="verifyTitleOfMobileListPage")
  public void verifyProductsSortedByName()
  {
	  new Select(driver.findElement(By.xpath("//div[@class='category-products']/div[1]/div[1]/div/select"))).selectByVisibleText("Name");
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element1=driver.findElement(By.xpath("//div[@class='page-title category-title']/h1"));
	  wait.until(ExpectedConditions.visibilityOf(element1));
	  List<WebElement> collectedlist=driver.findElements(By.xpath("//ul[contains(@class,'products-grid')]/li/div/h2/a"));
	  List<WebElement> sortedlist= new ArrayList<WebElement>();
	  boolean b=false;
	  for(int k=1;k<=collectedlist.size();k++)
	  {
		  for(int i=0;i<collectedlist.size()-k;i++)
		  {
		  int x=collectedlist.get(i).getText().charAt(0);
		  int y=collectedlist.get(i+1).getText().charAt(0);
		  if(x>y)
		  {
			  b=true;
			  sortedlist.add(collectedlist.get(i+1));
			  sortedlist.add(collectedlist.get(i));
		  }
		  }
	  }
	  if(b)
		  Assert.assertTrue(false);
	  else
		  Assert.assertTrue(true);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\selenium\\Lib\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://live.guru99.com/index.php/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
