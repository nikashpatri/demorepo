package page_object_model;

public class Spicejet_2waysearch_Components extends Baseclass {
	
	Spicejet_2waysearch_Locators locators=new Spicejet_2waysearch_Locators();

	public void launchapp()
	{
		openbrowser();
		openurl("https://book2.spicejet.com");
	}
	public void roundtrip() throws Exception
	{
		click(locators.departurecity);
		click(locators.city);
		wait(2000);
		click(locators.arrivalcity);
		wait(2000);
		click(locators.departdate);
		wait(2000);
		click(locators.returndate);
		wait(2000);
		select(locators.adult, "2");
		select(locators.child,"1");
		select(locators.infant,"1");
		select(locators.currency, "INR");
		takescreenshot("roundtrip");
		click(locators.search);
		wait(2000);
	}
	public void selectflight() throws Exception
	{
		click(locators.go);
		wait(3000);
		takescreenshot("continue");
		closebrowser();
	}
}
