package pom;

import org.testng.annotations.Test;



public class HMS_TestScript1 {
HMS_LoginPage_Components loginPageComponents=new HMS_LoginPage_Components();
 

 @Test
  public void f() {

	
 loginPageComponents.launchApp();

	
 loginPageComponents.login();
	 

 loginPageComponents.navigateToPR();
	
 
 loginPageComponents.createPatient();
  

}


}

