package page_object_model;

public class HMS_PatientRegistration_component extends Baseclass {
	HMS_PatientRegistration_locators loc=new HMS_PatientRegistration_locators();
	public void launchapp()
	{
		openbrowser();
		openurl("http://selenium4testing.com/hms/");
	}
	public void navigate() throws Exception
	{
		click(loc.registration);
		wait(2000);
		click(loc.emergencyregistration);
	}
	public void login()
	{
		entertext(loc.username, "admin");
		entertext(loc.password, "admin");
		click(loc.login);
	}
	public void createpatient()
	{
		entertext(loc.mothername, "anonymous");
		entertext(loc.patientname, "ram");
		entertext(loc.lastname, "charan");
		click(loc.dob);
		click(loc.date);
		entertext(loc.age, "24");
		select(loc.gender, "Male");
		entertext(loc.idproof, "122345");
		entertext(loc.address, "rourkela");
		entertext(loc.mobno, "9876453245");
		entertext(loc.zip, "769042");
		entertext(loc.image, "C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
		click(loc.submit);
	}
	

}
