package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibrarianDashboardPage;
import com.cydeo.library.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CountUserAsLibrarian {

    LoginPage loginPage = new LoginPage();
    LibrarianDashboardPage librarianDashboardPage = new LibrarianDashboardPage();

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
       loginPage.librarianLogin();
    }


    @And("I click on Users link")
    public void iClickOnLink() {
        librarianDashboardPage.usersBtn.click();
    }

    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> expectedLists) {
        List<String> actualColumnNames = new ArrayList<>();
        for (WebElement eachColumn : librarianDashboardPage.columnNames) {
            actualColumnNames.add(eachColumn.getText());
        }
        Assert.assertEquals(expectedLists, actualColumnNames);
    }
}
