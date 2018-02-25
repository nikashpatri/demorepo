package page_object_model;

import org.testng.annotations.Test;

public class Gmail_Testscript1 {
	
	Gmail_Components loginpagecomponent=new Gmail_Components();
  @Test
  public void test1() throws Exception {
	  
	  loginpagecomponent.launchapp();
	  loginpagecomponent.login();
	  loginpagecomponent.logout();
	  
  }
}
