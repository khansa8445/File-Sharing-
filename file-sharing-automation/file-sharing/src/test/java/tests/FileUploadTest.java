package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.FileUploadPage;
import pages.LoginPage;

public class FileUploadTest extends Base {

    @BeforeMethod
    public void setuplogin() throws IOException {
        LoginPage userLog = new LoginPage(driver);
        userLog.login(prop("email"), prop("password"));
    }

    @Test
    public void testUploadFileWithoutPassword() {
        FileUploadPage uploadFilePage = new FileUploadPage(driver);
        uploadFilePage.uploadFile("C:\\Users\\MASAI^\\OneDrive\\Pictures\\Screenshots 1");
        uploadFilePage.clickUploadButton();
        

        
    }

    @Test
    public void testUploadFileWithPassword() {
        FileUploadPage uploadFilePage = new FileUploadPage(driver);
    
        uploadFilePage.uploadFile("C:\\Users\\MASAI^\\OneDrive\\Pictures\\Screenshots 1");
        uploadFilePage.checkSetPassword();
        uploadFilePage.enterPassword("123456");
        uploadFilePage.clickUploadButton();

    }

    @Test
    public void testMaxFileSizeText() {
        FileUploadPage uploadFilePage = new FileUploadPage(driver);
        uploadFilePage.uploadFile("C:\\Users\\MASAI^\\OneDrive\\Pictures\\Screenshots 1");
        String maxSizeText = uploadFilePage.getMaxFileSizeText();

        Assert.assertEquals(maxSizeText, "Max file size is 10MB.");
    }
}
