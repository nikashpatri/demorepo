package hms_testNG;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class TimeStamp {
  @Test
  public void f() {
SimpleDateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss a");
Date d=new Date();
String time=df.format(d);
System.out.println(time);

  }
}
