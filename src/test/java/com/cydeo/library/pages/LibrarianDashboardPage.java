package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibrarianDashboardPage {

    public LibrarianDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement userCount;

    @FindBy(xpath = "(//span[@class='title'])[2]")
    public WebElement usersBtn;

    @FindBy(xpath = "//table[@id='tbl_users']//tr//th")
    public List<WebElement> columnNames;

    @FindBy(id = "navbarDropdown")
    public WebElement accountHolderName;


}
