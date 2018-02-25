package page_object_model;

public class HMS_Admissionadvice_Components extends Baseclass {
	
	HMS_Admissionadvice_Locators locator=new HMS_Admissionadvice_Locators();
	public void launchapp()
	{
		openbrowser();
		openurl("http://selenium4testing.com/hms/");
	}
	public void login()
	{
		entertext(locator.username, "admin");
		entertext(locator.password, "admin");
		click(locator.login);	
	}
	public void navigatetoadmissionadvice()
	{
		click(locator.ADT);
		click(locator.admissionadvice);
	}
	public void takeadvice() throws Exception
	{
		entertext(locator.Mrno, "ER3773533105");
		entertext(locator.patientname, "Anonymous");
		select(locator.gender, "Male");
		select(locator.admissiontype, "Emergency");
		select(locator.patientcategory, "Self");
		select(locator.hospitalservices, "Surgery");
		select(locator.lengthofstay, "Weeks");
		select(locator.bedreservationrequired, "Yes");
		click(locator.expecteddate);
		click(locator.date);
		select(locator.admittingdoctor, "Sai");
		select(locator.speciality, "Cordialagist");
		entertext(locator.provisionaldiagnosis, "diagnosis");
		entertext(locator.days, "2");
		wait(2000);
		click(locator.save);
	}
	public void logout()
	{
		click(locator.logout);
	}
	public void alert() throws Exception
	{
		alert_ok();
		wait(3000);
	}

}
