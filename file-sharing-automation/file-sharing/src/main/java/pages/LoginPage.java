package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='example@gmail.com']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//b[contains(text(), 'Forgot Password')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[@id='toast-1-title' and text()='Login Success!']")
	private WebElement loginSuccess;
	
	@FindBy(xpath = "//div[contains(@class, 'chakra-alert__title') and contains(normalize-space(), 'Invalid Email or Password!')]")
	private WebElement errormessage;
	
	@FindBy(xpath = "//p[@class='chakra-text css-11udi8d']")
	private WebElement errorValidation;
	
	@FindBy(xpath = "//button[@aria-label=\"Close\"]")
	private WebElement closetoggal;

	 public void enterEmail(String email) {
	        txtEmail.clear();
	        txtEmail.sendKeys(email);
	    }
	 public void enterPassword(String password) {
	         txtPassword.clear();
	         txtPassword.sendKeys(password);
	    }

	  public void clickLoginButton() {
		  loginBtn.click();
	    }
	  public String succesmessage() {
		    return loginSuccess.getText();
		}
	  public String  errormessage() {
		    return errormessage.getText();
		}
	  
	  public boolean  errorvalidate() {
		    return errorValidation.isDisplayed();
		}
	  public void  closetoggal() {
		    closetoggal.click();
		}
	  
	  public void login(String email, String password) {
		  txtEmail.sendKeys(email);
		  txtPassword.sendKeys(password);
		  loginBtn.click();
	  }

}
