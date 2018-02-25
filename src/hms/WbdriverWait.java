package hms;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WbdriverWait {
	static WebDriver driver;
	
	public static WebElement explicitWait(int time,By loc)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(time, TimeUnit.SECONDS);
		wait.pollingEvery(time, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement e=wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver)
			{
				WebElement e=driver.findElement(loc);
				if(e.isDisplayed())
				{
					return e;
				}
				else
				{
					return null;
				}
				
			}
			
		});
		
		return e;
	}

	public static WebElement checkVisibility(By loc,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		return e1;
	}
	
	public static WebElement clickWhenEnabled(By loc,int time)
	{
		WebElement e1=checkVisibility(loc, time);
		WebDriverWait wait=new WebDriverWait(driver, time);
		WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(e1));
		return e2;
	}
	public static void main(String[] args) {
		
    clickWhenEnabled(By.xpath(""), 20);
	}

}
