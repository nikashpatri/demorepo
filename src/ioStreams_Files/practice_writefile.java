package ioStreams_Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class practice_writefile {
  @Test
  public void f() throws Exception {
	  
	  FileInputStream fi=new FileInputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmslogin.xls");
	  Workbook wb=Workbook.getWorkbook(fi);
	  Sheet s=wb.getSheet("testdarta");
	  
	  FileOutputStream fo=new FileOutputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\practice.xls");
	  WritableWorkbook w=Workbook.createWorkbook(fo);
	  WritableSheet ws=w.createSheet("practice1", 0);
	  for(int i=0;i<s.getRows();i++)
	  {
		  for(int j=0;j<s.getColumns();j++){
			  System.out.println(s.getCell(j, i).getContents());
			  Label l1=new Label(j, i,s.getCell(j, i).getContents() );
			  ws.addCell(l1);
		  }
	  }
	  Label l2=new Label(2, 0, "Status");
	  ws.addCell(l2);
	  w.write();
	  w.close();
  }
  
}
