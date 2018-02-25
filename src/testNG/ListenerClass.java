package testNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerClass extends XLSheetDataProvider implements ITestListener {
	

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		if(result.isSuccess())
		{
			SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			Date d=new Date();
			String timestamp=formater.format(d);
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destpath="D:\\Workspacefor selenium _Appium\\selenium_webdriver\\Screenshot\\"+timestamp+".png";
			File destfile=new File(destpath);
			try {
				org.apache.commons.io.FileUtils.copyFile(srcfile, destfile);
				
				Reporter.log("<a href='"+destfile.getAbsolutePath()+"'><img src='"+destfile.getAbsolutePath()+ "'height='100' width='100'/></a>");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		if(!result.isSuccess())
		{
			SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			Date d=new Date();
			String timestamp=formater.format(d);
			TakesScreenshot shot=(TakesScreenshot)driver;
			File srcfile=shot.getScreenshotAs(OutputType.FILE);
			String destpath="D:\\Workspacefor selenium _Appium\\selenium_webdriver\\Screenshot\\"+timestamp+".png";
			File destfile=new File(destpath);
			try {
				org.apache.commons.io.FileUtils.copyFile(srcfile, destfile);
				
				Reporter.log("<a href='"+destfile.getAbsolutePath()+"'><img src='"+destfile.getAbsolutePath()+ "'height='100' width='100'/></a>");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
  
}
