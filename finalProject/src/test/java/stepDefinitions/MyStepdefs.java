package stepDefinitions;

import cucumber.api.PendingException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.AccountPage;
import pages_sample.AddressPage;
import pages_sample.EditAccPage;
import pages_sample.LogInPage;
import sun.rmi.runtime.Log;

import java.util.Iterator;
import java.util.List;

public class MyStepdefs {

    private WebDriver driver;
    static LogInPage logInPage;
    static EditAccPage editAccPage;
    static AddressPage addressPage;
    static AccountPage accountPage;


    public MyStepdefs() {
        this.driver = Hooks.driver;
        logInPage = PageFactory.initElements(Hooks.driver, LogInPage.class);
        editAccPage = PageFactory.initElements(Hooks.driver, EditAccPage.class);
        addressPage = PageFactory.initElements(Hooks.driver, AddressPage.class);
        accountPage =  PageFactory.initElements(Hooks.driver, AccountPage.class);

    }

    @Given("^I am on the Log In Page$")
    public void i_am_on_the_log_in_page() throws Throwable {
        driver.get("http://www.demoshop24.com/index.php?route=account/login");
    }

    //Loging in
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

    //Edit Account Info
    @When("^I click on Edit Account submenu$")
    public void iClickOnEditAccountSubmenu() {
        editAccPage.editAcc();
    }

    @And("^I edit \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEdit(String name, String lastName, String email, String phone) throws Throwable {
        editAccPage.editName(name);
        editAccPage.editLastName(lastName);
        editAccPage.editEmail(email);
        editAccPage.editPhone(phone);
    }

    @And("^I click Continue$")
    public void iClickContinue() {
        editAccPage.submitEditing();
    }

    @Then("^Success message appears$")
    public void successMessageAppears() {
        WebDriverWait wait = (WebDriverWait)
                new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert-success")));
        editAccPage.successfulEdit().isDisplayed();
    }

    //Adding Address
    @When("^I click on Address book$")
    public void iClickOnAddressBook() {
        addressPage.addressSubmenu();
    }

    @And("^I click on New Address button$")
    public void iClickOnNewAddressButton() {
        addressPage.addNewAddress();
    }

    @And("^I enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEnter(String name, String lastName, String address, String city, String postCode) throws Throwable {
        addressPage.addName(name);
        addressPage.addLastName(lastName);
        addressPage.addAddress(address);
        addressPage.addCity(city);
        addressPage.addPostCode(postCode);
    }

    @And("^I choose \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iChooseAnd(String country, String region) throws Throwable {
        addressPage.chooseCountry(country);
        addressPage.chooseRegion(region);
    }

    @And("^I choose Yes option$")
    public void iChooseYesOption() {
        addressPage.checkDefault();
        addressPage.chooseYes();
    }

// Adding Second address
    @Then("^I check new address is default$")
    public void iCheckNewAddressIsDefault() {
        addressPage.checkNonDefault();
        Assert.assertTrue(addressPage.isYesChosen());
    }

    @And("^I check old address is not default$")
    public void iCheckOldAddressIsNotDefault() {
        Assert.assertFalse(addressPage.isYesChosen());
    }

// Elements presence

    @When("^I check \"([^\"]*)\" are present$")
    public void iCheckArePresent(List<String> listNames) throws Throwable {

    }

    @And("^I edit following info$")
    public void iEditFollowingInfo() {

    }

    @When("^I check elements are present$")
    public void iCheckElementsArePresent(List<String> listNames) {
        for (int i=0; i<listNames.size(); i++){
            Assert.assertEquals(listNames.get(i), accountPage.listOfItems().get(i).getText());
        }
    }
}
