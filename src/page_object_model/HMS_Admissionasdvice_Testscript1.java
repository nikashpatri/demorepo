package page_object_model;

import org.testng.annotations.Test;

public class HMS_Admissionasdvice_Testscript1 {
	
	HMS_Admissionadvice_Components admissioncomponents=new HMS_Admissionadvice_Components();
  @Test
  public void test1() throws Exception {
	  
	  admissioncomponents.launchapp();
	  admissioncomponents.login();
	  admissioncomponents.navigatetoadmissionadvice();
	  admissioncomponents.takeadvice();
	  admissioncomponents.alert();
	  admissioncomponents.logout();
	  
  }
}
