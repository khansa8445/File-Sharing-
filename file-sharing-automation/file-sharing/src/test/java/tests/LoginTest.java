package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

 

import base.Base;
import pages.LoginPage;

public class LoginTest extends Base{

	@Test(priority = 1)   
	public void LoginWithValidDetails() throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
 
		login.enterEmail(prop("email"));
		login.enterPassword(prop("password"));
		login.clickLoginButton();
		Assert.assertEquals(login.succesmessage(), "Login Success!");
		login.closetoggal();
		 	
	}
	
	@Test(priority = 2)   
	public void LoginWithInValidDetails() throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
 
		login.enterEmail("ashi@gmail.com");
		login.enterPassword("124566");
		login.clickLoginButton();
		Assert.assertEquals(login.errormessage(), "Invalid Email or Password!");
		 	
	}
	
	@Test(priority = 3)   
	public void LoginWithWithoutInput() throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
 
		login.enterEmail(" ");
		login.enterPassword(" ");
		login.clickLoginButton();
		Assert.assertTrue(login.errorvalidate());;
		 	
	}
	
}
