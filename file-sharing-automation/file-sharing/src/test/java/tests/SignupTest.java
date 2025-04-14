package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.SignupPage;

public class SignupTest extends Base {
	
	@Test(priority = 1)
	public void signUpWithValidDetails() throws InterruptedException {
	    SignupPage signup = new SignupPage(driver);
	    
	    signup.clickOnSignup("");
	    signup.enterName("Test User");
	    signup.enterEmail(generateUniqueEmail());  
	    signup.enterPassword("ValidPass123");
	    signup.clickSignUpButton();

	    Thread.sleep(2000);  
	    Assert.assertEquals(signup.succesmessage(), "User SignUp Success!");
	}

	@Test(priority = 2)
	public void signUpWithExistingEmail() throws InterruptedException {
	    SignupPage signup = new SignupPage(driver);
	    
	    signup.clickOnSignup("");
	    signup.enterName("Sahil");
	    signup.enterEmail("sahil123@gmail.com"); // use an already registered email
	    signup.enterPassword("12345678");
	    signup.clickSignUpButton();

	    Thread.sleep(2000);
	    Assert.assertEquals(signup.errormessage(), "User Already Exist!");
	}
	@Test(priority = 3)
	public void signUpWithEmptyFields() {
	    SignupPage signup = new SignupPage(driver);

	    signup.clickOnSignup("");
	    signup.enterName("");
	    signup.enterEmail("");
	    signup.enterPassword("");
	    signup.clickSignUpButton();

	    Assert.assertTrue(signup.errorvalidate(), "Validation error not displayed for empty fields");
	}


	public String generateUniqueEmail() {
	    return "testuser" + System.currentTimeMillis() + "@example.com";
	}

}
