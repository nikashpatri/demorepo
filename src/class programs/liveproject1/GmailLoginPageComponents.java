package pom;

public class GmailLoginPageComponents extends BaseClass{
	GmailLoginLocators loginloc=new GmailLoginLocators();
	public void launchApp(){
		openBrowser();
		openURL("http://gmail.com");
	}

	public void login() throws Exception{
		enterText(loginloc.username,"testingse2");
		click(loginloc.next);
		wait(2000);
		enterText(loginloc.password,"selenium3");
		click(loginloc.signIn);
	}
}
