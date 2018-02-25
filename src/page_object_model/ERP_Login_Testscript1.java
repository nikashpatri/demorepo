package page_object_model;

import org.testng.annotations.Test;

public class ERP_Login_Testscript1 {
	ERP_Login_Components logincomponents=new ERP_Login_Components();
	
  @Test(description="check the login functionality of ERP")
  public void test1() throws Exception {
	  logincomponents.launchapp();
	  logincomponents.login();
	  logincomponents.logout();
	  
  }
}
