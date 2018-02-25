package page_object_model;

import org.testng.annotations.Test;

public class HMS_PatientRegistration_Testscript2 {
	
	HMS_PatientRegistration_component component=new HMS_PatientRegistration_component ();
	
  @Test
  public void test01() throws Exception {
	  component.launchapp();
	  component.login();
	  component.navigate();
	  component.createpatient();
	  component.closebrowser();
  }
}
