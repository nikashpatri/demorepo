package selenium3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Timestamp {
	WebDriver driver;
	public static void main(String[] args)
	{
		SimpleDateFormat df=new SimpleDateFormat("YYYY_MM_dd");
		Date d=new Date();
		String date;
		date=df.format(d);
		System.out.println(date);
	}
	//Screenshot method
	public void screenprint(String name) throws Exception
	{
		TakesScreenshot shot;
		shot=(TakesScreenshot)driver;
		File source;
		source=shot.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\Workspacefor selenium\\selenium_webdriver\\"+name+".png");
		FileUtils.copyFile(source, destination);
	}
    public void screenshot(String name) throws Exception
    {
    	TakesScreenshot shot;
    	shot=(TakesScreenshot)driver;
    	File src;
    	src=shot.getScreenshotAs(OutputType.FILE);
    	File dest=new File("D:\\Workspacefor selenium\\selenium_webdriver\\"+name+".png");
    	FileUtils.copyFile(src, dest);
    	
    }
}