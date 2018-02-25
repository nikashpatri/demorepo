package page_object_model;

public class ERP_Login_Components extends Baseclass {
	ERP_login_locators locate=new ERP_login_locators();
	
	public void launchapp() throws Exception
	{
		openbrowser();
		openurl("http://demo.inoideas.org");
		takescreenshot("homepage");
	}
	public void login() throws Exception
	{
		click(locate.register);
		wait(2000);
		click(locate.login);
		takescreenshot("loginpage");
    }
	public void logout() throws Exception
	{
		click(locate.menu);
		wait(2000);
		click(locate.menu);
		click(locate.logout);
		wait(2000);
		closebrowser();
	}
	
	
}
