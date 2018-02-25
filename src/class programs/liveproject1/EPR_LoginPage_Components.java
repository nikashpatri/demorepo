package pom;

public class EPR_LoginPage_Components extends BaseClass{
	ERP_LoginPageLocators loginPageLoc=new ERP_LoginPageLocators();
	
	public void launchApp(){
		openBrowser();
		 openURL("http://demo.inoideas.org/");
	}
	
	public void login() throws Exception{
		click(loginPageLoc.login_Register);
		wait(2000);
		click(loginPageLoc.login);
	}

}
