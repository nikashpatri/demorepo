package ioStreams_Files;

import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Xl_testdata_hms {
  @Test
  public void f() throws Exception {
	  FileOutputStream fo=new FileOutputStream("D:\\Workspacefor selenium\\selenium_webdriver\\Xl_files\\hmslogin.xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("testdarta", 0);
	  Label un=new Label(0, 0, "username");
	  ws.addCell(un);
	  Label un1=new Label(0, 1, "user1");
	  ws.addCell(un1);
	  Label un2=new Label(0, 2,"user1");
	  ws.addCell(un2);
	  Label un3=new Label(0, 3, "admin");
	  ws.addCell(un3);
	  Label un4=new Label(0, 4, "user3");
	  ws.addCell(un4);
	  
	  Label pw=new Label(1, 0, "password");
	  ws.addCell(pw);
	  Label pw1=new Label(1, 1, "user2");
	  ws.addCell(pw1);
	  Label pw2=new Label(1, 2,"user1");
	  ws.addCell(pw2);
	  Label pw3=new Label(1, 3, "admin");
	  ws.addCell(pw3);
	  Label pw4=new Label(1, 4, "user3");
	  ws.addCell(pw4);
	  wb.write();
	  wb.close();
  }
}
