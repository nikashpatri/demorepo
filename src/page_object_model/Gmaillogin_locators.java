package page_object_model;

import org.openqa.selenium.By;

public class Gmaillogin_locators {
	
	public By chooseaccount=By.xpath("//*[@id='view_container']/form/div[2]/div/div/div/ul[1]/li[2]/div/div[2]/p[2]");
	public By password=By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	public By signin=By.xpath("//*[@id='passwordNext']/content/span");
    public By profile=By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a");
    public By logout=By.xpath("//*[@id='gb_71']");
    public By emailid=By.id("identifierId");
    public By next=By.xpath("//*[@id='identifierNext']/content/span");
}
