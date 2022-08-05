package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibrarianDashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtil;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinition {

    LoginPage loginPage = new LoginPage();
    LibrarianDashboardPage librarianDashboardPage = new LibrarianDashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(url);
    }

    @When("user enters librarian username")
    public void userEntersLibrarianUsername() {
        String username = ConfigurationReader.getProperty("librarian_username");
        loginPage.emailAddress.sendKeys(username);
    }

    @And("user enters librarian password")
    public void userEntersLibrarianPassword() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("librarian_password"));
        loginPage.signInBtn.click();
    }

    @Then("user should see the dashboard")
    public void userShouldSeeTheDashboard() {
        Assert.assertTrue(librarianDashboardPage.dashboard.isDisplayed());
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        String username = ConfigurationReader.getProperty("student_username");
        loginPage.emailAddress.sendKeys(username);
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        String password = ConfigurationReader.getProperty("student_password");
        loginPage.password.sendKeys(password);
        loginPage.signInBtn.click();
    }
}
