package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class XLSheetDataProvider {
	static WebDriver driver;
	static Workbook wb;
	static Row row;
	static FileInputStream fis;
	static Sheet sheet;
	Logger log=Logger.getLogger(XLSheetDataProvider.class);

	public static String[][] readExcelsheet(String name, String path) throws IOException {
		String[][] str1 = new String[5][2];
		FileInputStream fis = new FileInputStream(path);
		wb = new HSSFWorkbook(fis);
		sheet = wb.getSheet(name);
		System.out.println(sheet.getLastRowNum());
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			System.out.println(row.getLastCellNum());
			for (int j = 0; j < row.getLastCellNum(); j++) {
				str1[i][j] = row.getCell(j).toString();
				System.out.println(row.getCell(j).toString());
			}
		}

		return str1;
	}

	@DataProvider(name = "dataProviderforhmslogin")
	public static Object[][] dataProvider() throws IOException {
		String[][] str2 = readExcelsheet("practice1",
				"D:\\Workspacefor selenium _Appium\\selenium_webdriver\\Xl_files\\practice.xls");
		Object[][] obj = (Object[][]) str2;
		return obj;
	}

	@Test(dataProvider = "dataProviderforhmslogin",enabled=false)
	public void testLogin(String username, String password) {
		PropertyConfigurator.configure("log4j.properties");
		driver.findElement(By.name("username")).sendKeys(username);
		log.info("Entered username");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		log.info("Entered pasword");
		driver.findElement(By.name("submit")).click();
		log.info("Clicked on submit button");
		try {
			driver.findElement(By.linkText("Logout")).click();
			log.info("Clicked on logout");
			Assert.assertTrue(true);
		} catch (NoSuchElementException e) {
			driver.switchTo().alert().accept();
			log.info("javascript alert was handaled and clicked on ok");
			Assert.assertFalse(false);
		}

	}
	@Test
	public void testDropdown()
	{
		SoftAssert sa=new SoftAssert();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		List<WebElement> l1=new Select(driver.findElement(By.xpath(".//*[@id='form1']/div[1]/table/tbody/tr[3]/td[4]/select"))).getOptions();
		sa.assertEquals(l1.size(), 6); 
		String pagetitle=driver.getTitle();
		sa.assertEquals(pagetitle, "Permanent Registration");
	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		log.info("Browser was launched");
		driver.manage().window().maximize();
		log.info("Browser was maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://selenium4testing.com/hms/");
		log.info("Opened url");

	}

}
