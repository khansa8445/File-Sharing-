package tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LogOutPage;
import pages.LoginPage;

public class LogOutTest extends Base {
	  @BeforeMethod
	    public void setuplogin() throws IOException {
	        LoginPage userLog = new LoginPage(driver);
	        userLog.login(prop("email"), prop("password"));
	    }
	  
	  @Test
	  public void loginToLogout() {
		  LogOutPage logout = new LogOutPage(driver);
		  logout.close();		 
		  logout.profileClick();
 	   
		  logout.clickLogout();
	  }
}
