package FinaltryMaven.TechfiosMavenTest;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import FinaltryMaven.TechfiosMavenPage.LoginPage;
import util.BrowserFactory;
import util.xls_reader;

public class LoginTest
{
	xls_reader reader = new xls_reader("C:\\Users\\Gaurav\\eclipse-workspace\\TechfiosMaven\\Data\\testdata.xlsx");
	String email=reader.getcellData("Sheet1", "Email", 2);
	String password=reader.getcellData("Sheet1", "Password", 2);;
	@Test
	public void logintest() 
	{
		/*
		 * System.out.println(email); 
		 * System.out.println(password);
		 */
		
			  WebDriver driver = BrowserFactory.startBrowser("chrome","http://techfios.com/test/billing/?ng=login/"); LoginPage login =
		  PageFactory.initElements(driver, LoginPage.class);
		  login.loginTechfios(email,password); 
		  driver.close(); 
		  driver.quit();
		 
		
	}
}