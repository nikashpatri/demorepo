package testNG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MysqlDatabase {
  @Test
  public void test1() throws ClassNotFoundException, SQLException {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Rootpassword");
	  Statement smt=con.createStatement();
	  ResultSet rs=smt.executeQuery("select * from enrollmentDetails");
	  while(rs.next())
	  {
		 System.out.println(rs.getString("Name")+"..."+rs.getInt("RollNo"));
		 if(rs.getString("Name").equals("GopalPatri")&& rs.getInt("RollNo")==104)
		 Assert.assertTrue(true);
		 
	  }
  }
}
