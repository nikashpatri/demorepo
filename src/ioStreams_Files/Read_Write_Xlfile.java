package ioStreams_Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Read_Write_Xlfile {
  @Test
  public void f() throws Exception {
	  
	  //read xl file
	  FileInputStream fi=new FileInputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmslogin.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet("testdarta");
	  
	  //creat xl file
	  FileOutputStream fo=new FileOutputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmslogin1.xls");
	  WritableWorkbook w=Workbook.createWorkbook(fo);
	  WritableSheet ws=w.createSheet("testdata1", 0);
	  
	  for(int r=0;r<s.getRows();r++)
	  {
		  for(int c=0;c<s.getColumns();c++)
		  {
			  System.out.println(s.getCell(c, r).getContents());
			  Label l=new Label(c, r, s.getCell(c, r).getContents());
			  ws.addCell(l);
		  }
	  }
	  Label r=new Label(2, 0, "Result");
	  ws.addCell(r);
	  
	 /* Label un=new Label(0, 0, s.getCell(0, 0).getContents());
	  ws.addCell(un);
	  Label un1=new Label(0, 1, s.getCell(0, 1).getContents());
	  ws.addCell(un1);
	  Label un2=new Label(0, 2, s.getCell(0, 2).getContents());
	  ws.addCell(un2);*/
	  
	  w.write();
	  w.close();
  }
}