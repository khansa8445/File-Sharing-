package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	WebDriver driver;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[normalize-space()='Signup']")
	private WebElement signupbtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter Your Full Name']")
	private WebElement txtName;

	@FindBy(xpath = "//input[@placeholder='example@gmail.com']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Signup']")
	private WebElement signupBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'File Uploading Failed!')]")
	private WebElement alreadyExist;
	
	@FindBy(xpath = "//div[@id='toast-1-title' and text()='User SignUp Success!']")
	private WebElement successSignUp;
	
	
	@FindBy(xpath = "//p[@class='chakra-text css-11udi8d']")
	private WebElement errorValidation;
	
	@FindBy(xpath = "//button[@aria-label=\"Close\"]")
	private WebElement closwtoggal;
	
	 public void clickOnSignup(String email) {
		 signupbtn.click();
	    }
	 
	 public void enterName(String name) {
		 txtName.clear();
		 txtName.sendKeys(name);
	    }

	 public void enterEmail(String email) {
	        txtEmail.clear();
	        txtEmail.sendKeys(email);
	    }
	 public void enterPassword(String password) {
	         txtPassword.clear();
	         txtPassword.sendKeys(password);
	    }

	  public void clickSignUpButton() {
		  signupBtn.click();
	    }
	  public String succesmessage() {
		    return successSignUp.getText();
		}
	  public String  errormessage() {
		    return alreadyExist.getText();
		}
	  
	  public boolean  errorvalidate() {
		    return errorValidation.isDisplayed();
		}
	  public void  closetoggal() {
		    closwtoggal.click();
		}
	 
}
