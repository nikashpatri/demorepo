package pom;

import org.testng.annotations.Test;



public class GmailTestScript1 {
	

GmailLoginPageComponents login=new GmailLoginPageComponents();
 

@Test

 
 public void f() throws Exception {

	
 login.launchApp();
	
 
 login.login();
 
 
}


}
