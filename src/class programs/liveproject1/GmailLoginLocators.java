package pom;

import org.openqa.selenium.By;

public class GmailLoginLocators {

	public By username=By.id("identifierId");
	public By next=By.xpath("//div[@id='identifierNext']/content/span");
	public By password=By.name("password");
	public By signIn=By.xpath("//div[@id='passwordNext']/content/span");
}
