package FinaltryMaven.TechfiosMavenPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public  LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	@FindBy(how=How.ID, using = "username")
	WebElement username;
	@FindBy(how=How.ID, using = "password")
	WebElement password;
	@FindBy(how=How.NAME, using = "login")
	WebElement LoginButton;
	
	public void loginTechfios(String Email, String Password)
	{
		username.sendKeys(Email);
		password.sendKeys(Password);
		LoginButton.click();
		
	}
	
}
