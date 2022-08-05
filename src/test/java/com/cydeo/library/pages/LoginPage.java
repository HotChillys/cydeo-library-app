package com.cydeo.library.pages;

import com.cydeo.library.utilities.BrowserUtil;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailAddress;

    @FindBy(id = "inputPassword")
    public WebElement password;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signInBtn;


    public void librarianLogin() {
        emailAddress.sendKeys(ConfigurationReader.getProperty("librarian_username"));
        password.sendKeys(ConfigurationReader.getProperty("librarian_password"));
        signInBtn.click();
        BrowserUtil.waitFor(2);
    }

}
