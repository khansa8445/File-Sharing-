package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//button[@aria-haspopup='menu']")
	    WebElement profile;
	 
	 @FindBy(xpath = "//button[normalize-space()='LOGOUT']")
	    WebElement logout;
	 
	 @FindBy(xpath = "(//b[@id='menu-list-:r5:-menuitem-:r6:'])[1]")
	    private WebElement allFiles;
	 
	 @FindBy(xpath = "//button[@aria-label=\"Close\"]")
		private WebElement closetoggal;
	 
	 public void close() {
		 closetoggal.click();
	 }
	 
	 public void profileClick() {
		 profile.click();
	 }
	 public void allFileClick() {
		 
		 allFiles.click();
	 
		 
	 }
	 public void clickLogout() {
		 
		 logout.click();
		 
	 }
	 
}
