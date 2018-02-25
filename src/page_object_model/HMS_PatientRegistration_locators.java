package page_object_model;

import org.openqa.selenium.By;

public class HMS_PatientRegistration_locators extends HMS_Admissionadvice_Locators {
	
	 public By registration=By.linkText("Registration");
	 public By emergencyregistration =By.linkText("Emergency Registration");
	 public By mothername= By.name("MOTHER_NAME");
     public By patientname=By.name("PNT_NAME");
	 public By lastname=By.name("LAST_NAME");
	 public By dob=By.name("DOB");
	 public By date=By.xpath("//*[@id='tcalGrid']/tbody/tr[3]/td[2]");
	 public By age=By.name("AGE");
	 public By idproof=By.name("PAT_IDENTITY_PROOF");
	 public By address=By.name("ADDRESS1");
     public By mobno=By.name("MOBILE_NO");
	 public By email=By.name("EMAIL_ID");
	 public By zip=By.name("ZIP");
	 public By image=By.name("image");
     public By submit= By.name("submit");
     public By gender=By.name("SEX");
}
