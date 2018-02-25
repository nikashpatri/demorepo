package ioStreams_Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Creat_xlfile {
	@Test
	public void creatfile() throws Exception {
		FileOutputStream f = new FileOutputStream(
				"D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\sample.xls");
		WritableWorkbook wb = Workbook.createWorkbook(f);
		WritableSheet s = wb.createSheet("samplesheet", 0);
		Label username = new Label(0, 0, "Username");
		s.addCell(username);
		Label password = new Label(1, 0, "Password");
		s.addCell(password);
		Label result = new Label(2, 0, "Result");
		s.addCell(result);
		wb.write();
		wb.close();

	}

	@Test
	public void read_xlfile() throws Exception {
		FileInputStream fo = new FileInputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\sample.xls");
		Workbook wb = Workbook.getWorkbook(fo);
		Sheet s = wb.getSheet("samplesheet");
		/*
		 * System.out.println(s.getCell(0, 0).getContents());
		 * System.out.println(s.getCell(1, 0).getContents());
		 * System.out.println(s.getCell(2, 0).getContents());
		 */
		for (int r = 0; r < s.getRows(); r++) {
			for (int c = 0; c < s.getColumns(); c++) {
				System.out.println(s.getCell(c, r).getContents());
			}
		}
	}

}