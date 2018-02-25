package page_object_model;

public class Gmail_Components extends Baseclass {
	Gmaillogin_locators locator=new Gmaillogin_locators();
	public void launchapp() throws Exception
	{
		openbrowser();
		openurl("https://accounts.google.com");
		takescreenshot("loginpage");
		get_windowname();
	}
	public void chooseaccount()
	{
		click(locator.chooseaccount);
	}
	public void login() throws Exception
	{
		entertext(locator.emailid, "testingse2");
		click(locator.next);
		wait(2000);
		entertext(locator.password, "selenium3");
		wait(2000);
		click(locator.signin);
		wait(2000);
		click(locator.profile);
		wait(2000);
		
	}
	public void logout() throws Exception
	{
		click(locator.logout);
		takescreenshot("logout");
	}


}
