package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibrarianDashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.StudentDashboardPage;
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
    StudentDashboardPage studentDashboardPage = new StudentDashboardPage();

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
        BrowserUtil.waitFor(2);
    }

    @Then("user should see the Books")
    public void userShouldSeeTheBooks() {
        Assert.assertTrue(studentDashboardPage.books.isDisplayed());
    }

    //***********************************************************************

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        String url = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(url);
    }

    @When("I enter username {string}")
    public void iEnterUsername(String arg0) {
        loginPage.emailAddress.sendKeys(arg0);
    }

    @And("I enter password {string}")
    public void iEnterPasswordIFFPPf(String arg0) {
        loginPage.password.sendKeys(arg0);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.signInBtn.click();
    }

    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        Assert.assertTrue(librarianDashboardPage.dashboard.isDisplayed());
    }

    @And("there should be {string} users")
    public void thereShouldBeUsers(String arg0) {
        Assert.assertEquals(arg0, librarianDashboardPage.userCount.getText());
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String arg0, String arg1) {
        loginPage.emailAddress.sendKeys(arg0);
        loginPage.password.sendKeys(arg1);
        loginPage.signInBtn.click();
        BrowserUtil.waitFor(2);
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String arg0) {
        Assert.assertEquals(arg0, librarianDashboardPage.accountHolderName.getText());
    }
}
