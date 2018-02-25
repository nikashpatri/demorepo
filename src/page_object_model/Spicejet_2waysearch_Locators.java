package page_object_model;

import org.openqa.selenium.By;

public class Spicejet_2waysearch_Locators {

	public By departurecity=By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']");
	public By city=By.xpath("//*[@id='dropdownGroup1']/div/ul[2]/li[6]/a");
	public By arrivalcity =By.xpath("html/body/div[8]/form/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]/div/ul[1]/li[6]/a");
	public By departdate=By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[2]/a");
	public By returndate=By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[7]/a");
	public By adult=By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']");
    public By child= By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD']");
    public By infant=By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_INFANT']");
    public By currency=By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency']");
    public By search=By.xpath("//*[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit']");
    public By go =By.xpath(".//*[@id='continue-to-contact-page']/span[1]");
}


