package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage {

    WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-haspopup='menu']")
    WebElement profile;

    @FindBy(xpath = "//button[@role='menuitem' and contains(text(), 'Upload File')]")
    WebElement uploadFileMenu;

    @FindBy(xpath = "//span[normalize-space()='Set Password']")
    WebElement setPasswordCheckbox;

    @FindBy(xpath = "//input[@placeholder='Set Password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@class='chakra-button css-rxecov' and normalize-space()='Upload File']")
    WebElement uploadButton;

    @FindBy(xpath = "//div[contains(text(), 'File Uploading Failed!')]")
    WebElement uploadError;

    @FindBy(xpath = "//b[contains(text(),'Max file size is 10MB.')]")
    WebElement overSize;

    @FindBy(xpath = "//input[@type='file']")
    WebElement file;

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closetoggal;
    
    @FindBy(xpath = "//b[normalize-space() ='All Files']")
    private WebElement allFiles;

    
    @FindBy(xpath = "//b[normalize-space() ='All Files']")
    private WebElement fileTable ;
    
    
    
    
    
    public void goToFileUpload() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(closetoggal))
                    .click();
        } catch (Exception ignored) {}

        profile.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(uploadFileMenu))
                .click();
    }

    public void uploadFile(String filePath) {
        file.sendKeys(filePath);
    }

    public void checkSetPassword() {
        setPasswordCheckbox.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickUploadButton() {
        try {
            waitUntilUploadButtonIsClickable();
            uploadButton.click();
        } catch (ElementClickInterceptedException e) {
            forceClickUploadButton();  
        }
    }

    public void waitUntilUploadButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton);
    }

    public void forceClickUploadButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadButton);
    }

    public String getErrorWithoutUpload() {
        return uploadError.getText();
    }

    public String getMaxFileSizeText() {
        return overSize.getText();
    }
}
