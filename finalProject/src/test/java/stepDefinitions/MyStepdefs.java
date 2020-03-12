package stepDefinitions;

import cucumber.api.DataTable;
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
import pages_sample.AccountPage;
import pages_sample.AddressPage;
import pages_sample.EditAccPage;
import pages_sample.LogInPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        accountPage = PageFactory.initElements(Hooks.driver, AccountPage.class);

    }

    @Given("^I am on the Log In Page$")
    public void i_am_on_the_log_in_page() throws Throwable {
        driver.get("http://www.demoshop24.com/index.php?route=account/login");
    }

    //Loging in
    @When("^I enter email address$")
    public void iEnterEmailAddress(DataTable dataTable) {
        List<Map<String, String>> editInfo = dataTable.asMaps(String.class, String.class);
        String email = editInfo.get(0).get("email");
        logInPage.enterMail(email);
    }

    @And("^I enter password$")
    public void i_enter_password(DataTable dataTable) throws Throwable {
        List<Map<String, String>> editInfo = dataTable.asMaps(String.class, String.class);
        String password = editInfo.get(0).get("password");
        logInPage.enterPassword(password);
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

    @And("^I edit following info$")
    public void iEditFollowingInfo(DataTable dataTable) {
        List<Map<String, String>> editInfo = dataTable.asMaps(String.class, String.class);
        String name = editInfo.get(0).get("name");
        String lastName = editInfo.get(0).get("lastName");
        String email = editInfo.get(0).get("email");
        String phone = editInfo.get(0).get("phone");
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

    @And("^I enter name, lastName, address, city, postCode$")
    public void iEnterNameLastNameAddressCityPostCode(DataTable dataTable) {
        List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
        String name = addressInfo.get(0).get("name");
        String lastName = addressInfo.get(0).get("lastName");
        String address = addressInfo.get(0).get("address");
        ;
        String city = addressInfo.get(0).get("city");
        ;
        String postCode = addressInfo.get(0).get("postCode");
        ;
        addressPage.addName(name);
        addressPage.addLastName(lastName);
        addressPage.addAddress(address);
        addressPage.addCity(city);
        addressPage.addPostCode(postCode);
    }

    @And("^I choose country$")
    public void iChooseCountry(DataTable dataTable) {
        List<Map<String, String>> countryInfo = dataTable.asMaps(String.class, String.class);
        String country = countryInfo.get(0).get("country");
        addressPage.chooseCountry(country);
    }

    @And("^I choose region$")
    public void iChooseRegion(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> regionInfo = dataTable.asMaps(String.class, String.class);
        /*WebDriverWait wait = (WebDriverWait)
                new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-zone")));*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String region = regionInfo.get(0).get("region");
        addressPage.chooseRegion(region);
    }

    @And("^I choose Yes option$")
    public void iChooseYesOption() throws InterruptedException {
        WebDriverWait wait = (WebDriverWait)
                new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#column-right [href$='address']")));
        addressPage.chooseYes();
    }

    // Adding Second address
    @Then("^I check new address is default$")
    public void iCheckNewAddressIsDefault() {
        addressPage.checkDefault();
        Assert.assertTrue(addressPage.isYesChosen());
    }

    @And("^I check old address is not default$")
    public void iCheckOldAddressIsNotDefault() {
        addressPage.checkNonDefault();
        Assert.assertFalse(addressPage.isYesChosen());
    }
    // This step is for making test able to run more then once
    @And("^I delete old address$")
    public void iDeleteOldAddress() {
        addressPage.deleteNotDefault();

    }
// Elements presence

    @When("^I check elements are present$")
    public void iCheckElementsArePresent(List<String> listNames) {
        for (int i = 0; i < listNames.size(); i++) {
            Assert.assertEquals(listNames.get(i), accountPage.listOfItems().get(i).getText());
        }
    }


}
