package pom;



import org.testng.annotations.Test;



public class ERP_TestScripts1 {
	

EPR_LoginPage_Components loginPageComp=new EPR_LoginPage_Components();
 
@Test

public void f() throws Exception {


loginPageComp.launchApp();
	
  
loginPageComp.login();
  

}


}
