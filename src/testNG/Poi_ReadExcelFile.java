package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFChildAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Poi_ReadExcelFile {
	WebDriver driver;
	List<String> l = new ArrayList<String>();
	org.apache.poi.ss.usermodel.Sheet s;
	Workbook wb;
	FileWriter fw;
	File f;
	BufferedWriter bw;
	int u = 0, p = 1;

	public void readData() throws Exception {
		FileInputStream fi = new FileInputStream(
				"D:\\Workspacefor selenium _Appium\\selenium_webdriver\\Xl_files\\practice.xls");
		wb = new HSSFWorkbook(fi);
		s = wb.getSheet("practice1");
		for (int i = 1; i <= s.getLastRowNum(); i++) {
			Row r1 = s.getRow(i);
			for (int j = 0; j < r1.getLastCellNum(); j++) {
				Cell c1 = r1.getCell(j);
				l.add(c1.toString());
			}
		}

	}

	@Test
	public void f() throws Exception {
		readData();
		f = new File("D:\\Workspacefor selenium _Appium\\selenium_webdriver\\html file\\sample2.html");
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		bw.write("<html>");
		bw.write("<body style=\"background-color:powderblue;\">");
		bw.write("<center>");
		bw.write("<img src='C:\\Users\\NIKASH\\Pictures\\banner2-950x274-890x274.jpg' width='500' height='100'>");
		bw.write("</center>");
		bw.write("<h1 align='center'>HMSLogin Report</h1>");
		bw.write("<table  cellspacing='2' cellpadding='2' border='2' align='center'>");
		bw.write("<tbody>");
		bw.write("<tr>");
		bw.write("<th>UserName</th>");
		bw.write("<th>Password</th>");
		bw.write("<th>Result</th>");
		bw.write("</tr>");
		for (int k = 1; k <= s.getLastRowNum(); k++) {
			bw.write("<tr>");
			bw.write("<td>");
			bw.write("<font face='bold' size='4' color='blue'>" + l.get(u) + "</font>");
			bw.write("</td>");
			bw.write("<td>");
			bw.write("<font face='bold' size='4' color='blue'>" + l.get(p) + "</font>");
			bw.write("</td>");
			//bw.write("</tr>");

			driver.findElement(By.name("username")).sendKeys(l.get(u));
			driver.findElement(By.name("password")).sendKeys(l.get(p));
			driver.findElement(By.name("submit")).click();
			
			try {
				driver.findElement(By.linkText("Logout")).click();
				bw.write("<td>");
				bw.write("<font face='bold' size='4' color='green'>Pass</font>");
				bw.write("</td>");

			} catch (Exception e) {
				String str = driver.switchTo().alert().getText();
				System.out.println(str);
				driver.switchTo().alert().accept();
				bw.write("<td>");
				bw.write("<font face='bold' size='4' color='red'>Fail</font>");
				bw.write("</td>");
			}
			u = u + 2;
			p = p + 2;
		}
		bw.write("</tr>");
		bw.write("</tbody>");
		bw.write("</table>");
		bw.write("</body>");
		bw.write("</html>");
		bw.close();

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
