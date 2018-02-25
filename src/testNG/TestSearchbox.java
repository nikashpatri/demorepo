package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestSearchbox {

	WebDriver driver;
  public WebElement explicitWait(String str,int time) throws InterruptedException
  {
	  boolean b=false;
	  for(int i=1;i<=time;i++)
	  {
		  try
		  {
			  driver.findElement(By.xpath(str)).isDisplayed();
			  b=true;
			  break;
		  }
		  catch(NoSuchElementException e){
			  Thread.sleep(1000);
			  
		  }
	  }
	  if(true)
	  return driver.findElement(By.xpath(str));
	  else
		  return null;
	  
  }
	@Test(priority = 1)
	public void test1() throws InterruptedException {
		//explicitWait("//div[@class='subscribe_popup']/div/div", 10).click();
		driver.findElement(By.xpath(".//*[@id='awok_instant_search']")).sendKeys("Samsung phones");
		driver.findElement(By.xpath(".//*[@id='submit_isearch']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//*[@class='productslist clearFix']/li/a/div[2]/p"));
		Iterator<WebElement> itr = elements.iterator();
		while (itr.hasNext()) {
			if (itr.next().getText().contains("Samsung")) {
				System.out.println(itr.next().getText());
			} else
				Assert.assertTrue(false, "not as expected");
		}
	}

	@Test(enabled=false)
	public void test2() throws InterruptedException {
		SoftAssert sof=new SoftAssert();
		Actions action=new Actions(driver);
		driver.findElement(By.xpath("//*[@class='accordion_body clearFix']/div[2]/label[1]/input")).clear();
		driver.findElement(By.xpath("//*[@class='accordion_body clearFix']/div[2]/label[1]/input")).sendKeys("7000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='accordion_body clearFix']/div[2]/label[2]/input")).clear();
		driver.findElement(By.xpath("//*[@class='accordion_body clearFix']/div[2]/label[2]/input")).sendKeys("9000");
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		List<WebElement> values = driver.findElements(By.xpath("//*[@class='js_productslist']/ul/li/a/div[3]/div[1]"));
		Iterator<WebElement> itr = values.iterator();
		while (itr.hasNext()) {
			String price1 = itr.next().getText().substring(1);
			StringBuffer sb = new StringBuffer(price1);
			int index = sb.indexOf(",");
			String price2 = sb.deleteCharAt(index).toString();
			int costofitem = Integer.parseInt(price2);
			if (costofitem>=7000 && costofitem <= 9000) 
			{
				System.out.println(costofitem);
			} 
			else
				sof.assertTrue(false);
			
		}
	}
	@Test(priority=2)
	public void test3() throws InterruptedException
	{
		Actions action=new Actions(driver);
		/*WebElement finallow=driver.findElement(By.xpath("//div[@class='priceslider']/div/div[1]/div[2]"));
		WebElement finalhigh=driver.findElement(By.xpath("//div[@class='priceslider']/div/div[1]/div[4]"));
		WebElement initiallow=driver.findElement(By.xpath(""));*/
		
		Dimension d=driver.findElement(By.cssSelector("div[class='back-bar']")).getSize();
		int width=d.width;
		Point p=driver.findElement(By.xpath("//div[@class='priceslider']/div/div[1]")).getLocation();
		int x=p.x;
		WebElement e1=driver.findElement(By.xpath("//div[@class='priceslider']/div/div[1]/div[2]"));
		int xOffset=x+(width/4);
		action.dragAndDropBy(e1, xOffset, 0).build().perform();;
		Thread.sleep(3000);
		
		
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		// log.info("Browser was launched");
		driver.manage().window().maximize();
		// log.info("Browser was maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://global.awok.com");
		// log.info("Opened url");
	}

	/*
	 * @AfterTest public void afterTest() { driver.quit(); }
	 */

}
