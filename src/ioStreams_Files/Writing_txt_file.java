package ioStreams_Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;
import java.io.FileReader;

public class Writing_txt_file {
  @Test
  public void Write() throws Exception {
	  File f=new File("D:\\Workspacefor selenium\\selenium_webdriver\\text file\\sample.txt");
	  FileWriter fw=new FileWriter(f);
	  BufferedWriter bw=new BufferedWriter(fw);
	  bw.newLine();
	  bw.write("nikash");
	  bw.newLine();
	  bw.write("gopal");
	  bw.newLine();
	  bw.write("anjali");
	  bw.newLine();
	  bw.write("rashmi");
	  bw.newLine();
	  bw.close();
  }
  @Test
  public void readtxtfile() throws Exception
  {
	  File f=new File("D:\\Workspacefor selenium\\selenium_webdriver\\text file\\sample.txt");
	  FileReader fr=new FileReader(f);
	  BufferedReader br=new BufferedReader(fr);
	  String str;
	  str= br.readLine();
	 // System.out.println(str);
	  while( (str= br.readLine())!=null)
	  {
		  System.out.println(str);
		 /* if(str.equalsIgnoreCase("gopal"))
		  {
		  System.out.println(str);
		  }*/
	  }
	 
	 
  }
}
