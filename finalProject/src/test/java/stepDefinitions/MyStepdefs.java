package stepDefinitions;

import cucumber.api.PendingException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.LogInPage;
import sun.rmi.runtime.Log;

public class MyStepdefs {

    private WebDriver driver;
    static LogInPage logInPage;

    public MyStepdefs() {

        this.driver = Hooks.driver;
        logInPage = PageFactory.initElements(Hooks.driver, LogInPage.class);

    }

    @Given("^I am on the Log In Page$")
    public void i_am_on_the_log_in_page() throws Throwable {
        driver.get("http://www.demoshop24.com/index.php?route=account/login");
    }

    @When("^I enter email address$")
    public void iEnterEmailAddress() {
        logInPage.enterMail();
    }


    @And("^I enter password$")
    public void i_enter_password() throws Throwable {
    logInPage.enterPassword();
    }

    @And("^I press Log In$")
    public void i_press_log_in() throws Throwable {
        logInPage.logIn();
    }

    @Then("^Account page is opened$")
    public void account_page_is_opened() throws Throwable {
        Assert.assertEquals("http://www.demoshop24.com/index.php?route=account/account",
                driver.getCurrentUrl());
    }


}
