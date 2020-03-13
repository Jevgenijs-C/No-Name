package stepDefinitions;

import com.gargoylesoftware.htmlunit.html.DomNode;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import javafx.scene.layout.Background;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReviewSteps {
    private static WebDriverWait wait;
    static long startTime;
    private WebDriver driver;
    static pages_sample.AppleCinemaProduct AppleCinemaProduct;
    static pages_sample.IPhoneProduct IPhoneProduct;
    static pages_sample.HomePage HomePage;
    static pages_sample.Checkout Checkout;
    static Review Review;
    static LoginPage12 logInPage;


    public ReviewSteps() {
        this.driver = Hooks.driver;
        logInPage = PageFactory.initElements(Hooks.driver, LoginPage12.class);
        AppleCinemaProduct = PageFactory.initElements(Hooks.driver, AppleCinemaProduct.class);
        IPhoneProduct = PageFactory.initElements(Hooks.driver, IPhoneProduct.class);
        HomePage = PageFactory.initElements(Hooks.driver, HomePage.class);
        Checkout = PageFactory.initElements(Hooks.driver, Checkout.class);
        Review = PageFactory.initElements(Hooks.driver, Review.class);
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        //driver = new ChromeDriver();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }

    // background
    @And("^I click \"([^\"]*)\"$")
    public void i_click_something(String strArg1) throws Throwable {
        Review.clickWriteReview();
    }

    @And("^Review tab is opened$")
    public void reviewTabIsOpened() {
        assertTrue(Review.TabReviewIsOpened.isDisplayed());
    }

// scenario outline for valid text and valid name inserted, and rating selected

    @When("^I input \"([^\"]*)\" in Your Name field$")
    public void i_enter_valid_name_in_field(String name) throws Throwable {
        Review.enterNameInReview(name);
    }
    @And("^I enter \"([^\"]*)\" in Your Review field$")
    public void i_enter_valid_text_in_field(String text) throws Throwable {
        Review.enterTextInReview(text);
    }

    @And("^I select rating$")
    public void iSelectRating() {
        Review.selectRatingOne();
    }
    @And("^I click Continue$")
    public void iClickContinue() {
        Review.clickContinueReview();
    }

    @Then("^Success message is shown$")
    public void successMessageIsShown() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success")));
        assertEquals("Thank you for your review. It has been submitted to the webmaster for approval.", Review.successMessageText());
    }


    @And("^I input \"([^\"]*)\" in Your Review field$")
    public void iEnterInvalidTextInYourReviewField(String invalidText) {
        Review.enterInvalidText(invalidText);
    }


    @Then("^Error message \"([^\"]*)\" is shown$")
    public void errorMessageIsShown(String arg0) throws Throwable {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-danger")));
        assertEquals(" Warning: Review Text must be between 25 and 1000 characters!", Review.errorTextMessageText());
    }



    @And("^I do not select rating$")
    public void iDoNotSelectRating() {
    }

    @Then("^Error \"([^\"]*)\" is shown$")
    public void error_message_something_is_shown(String strArg1) throws Throwable {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-danger")));
        assertEquals(" Warning: Please select a review rating!", Review.errorRatingMessageText());
    }


}