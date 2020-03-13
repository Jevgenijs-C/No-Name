package stepDefinitions;

import com.gargoylesoftware.htmlunit.html.DomNode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
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


public class StepDefsUserStory12 {
    private static WebDriverWait wait;
    static long startTime;
    private WebDriver driver;
    static pages_sample.AppleCinemaProduct AppleCinemaProduct;
    static pages_sample.IPhoneProduct IPhoneProduct;
    static pages_sample.HomePage HomePage;
    static pages_sample.Checkout Checkout;
    static Review Review;
    static LoginPage12 logInPage;

    public StepDefsUserStory12() {
        this.driver = Hooks.driver;
        logInPage = PageFactory.initElements(Hooks.driver, LoginPage12.class);
        AppleCinemaProduct = PageFactory.initElements(Hooks.driver, AppleCinemaProduct.class);
        IPhoneProduct = PageFactory.initElements(Hooks.driver, IPhoneProduct.class);
        HomePage = PageFactory.initElements(Hooks.driver, HomePage.class);
        Checkout = PageFactory.initElements(Hooks.driver, Checkout.class);
        Review = PageFactory.initElements(Hooks.driver, Review.class);
//        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    //scenario: open product page

    @Given("^I am on the HomePage$")
    public void i_am_on_the_home_page() throws Throwable {
        driver.get(HomePage.GetHomePage());
    }

    @When("^I click on Components tab$")
    public void i_click_on_components() throws Throwable {
        AppleCinemaProduct.clickComponents();
    }

    @And("^I select Monitors$")
    public void iSelectMonitors() throws Throwable {
        AppleCinemaProduct.clickMonitors();
    }

    @And("^I click on Apple Cinema name$")
    public void i_click_on_apple_cinema_name() throws Throwable {
        AppleCinemaProduct.clickAppleCinemaName();
    }

    @Then("^I am redirected to Apple Cinema page$")
    public void i_am_redirected_to_apple_cinema_page() throws Throwable {
        AppleCinemaProduct.GetAppleCinemaPage();
    }


    @And("^I click on Apple Cinema image$")
    public void i_click_on_apple_cinema_image() throws Throwable {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".image a[href*=\"id=42\"]")));
        AppleCinemaProduct.clickAppleCinemaImage();
    }

    //repeated:then i am redirected..



    //next scenario: presence of information about product


    @And("^I am able to see product name$")
    public void iAmAbleToSeeProductName() throws Throwable {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"col-sm-4\"]:nth-child(2)>h1")));
        assertTrue(AppleCinemaProduct.nameAppleCinema.isDisplayed());
    }
    @And("^I am able to see product image$")
    public void seeProductImage() throws Throwable {

        assertTrue(AppleCinemaProduct.imageAppleCinema.isDisplayed());
    }
    @And("^I am able to see product price$")
    public void seeProductPrice() throws Throwable {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".list-unstyled h2")));
        assertTrue(AppleCinemaProduct.Price.isDisplayed());
    }
    @And("^I am able to see available options$")
    public void seeAvailableOptions() throws Throwable {
        assertTrue(AppleCinemaProduct.AvailableOptions.isDisplayed());
    }
    @And("^I am able to see description$")
    public void seeDescription() throws Throwable {
        assertTrue(AppleCinemaProduct.Description.isDisplayed());
    }
    @And("^I am able to see specification$")
    public void seeSpecification() throws Throwable {
        assertTrue(AppleCinemaProduct.Specification.isDisplayed());
    }
    @And("^I am able to see review$")
    public void seeReview() throws Throwable {
        assertTrue(AppleCinemaProduct.Review.isDisplayed());
    }
    @And("^I am able to see Compare button$")
    public void seeCompareButton() throws Throwable {
        assertTrue(AppleCinemaProduct.CompareButton.isDisplayed());
    }
    @And("^I am able to see Add to Wish list button$")
    public void seeWishListButton() throws Throwable {
        assertTrue(AppleCinemaProduct.AddToWishListButton.isDisplayed());
    }
    @And("^I am able to see Add to Cart button$")
    public void seeAddToCartButton() throws Throwable {
        assertTrue(AppleCinemaProduct.AddToCartButton.isDisplayed());
    }



    //next scenario: add to cart


    @Given("^I am on the IPhonePage$")
    public void iAmOnTheIPhonePage() {
        driver.get(IPhoneProduct.GeIPhonePage());

    }

    @When("^I click on Add to Cart Button$")
    public void iClickOnAddToCartButton() {
        IPhoneProduct.clickAddToCart();

    }

    @Then("^IPhone is added to Cart$")
    public void iphoneIsAddedToCart() throws Throwable {
        IPhoneProduct.clickToSeeCart();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-left [href*=\"id=40\"]")));
        assertTrue(IPhoneProduct.IPhoneIsAddedToCart.isDisplayed());
    }

    //next scenario: checkout

    @When("^I click on Checkout Button$")
    public void iClickOnCheckoutButton() throws InterruptedException {
        Checkout.clickCheckout();
    }

    @Then("^I am redirected to checkout page$")
    public void iAmRedirectedToCheckoutPage() {
        driver.get(Checkout.CheckoutPage());
    }

    @When("^I select Billing Details$")
    public void iSelectBillingDetails() throws InterruptedException {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input [@value=\"existing\"]")));
        //Thread.sleep(5000);
        Checkout.clickExistingAddress();
    }

    @And("^I click Continue to Delivery Details$")
    public void iClickContinueToDeliveryDetails () throws InterruptedException {
        //Thread.sleep(5000);
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"button-payment-address\"]")));
        Checkout.clickContinueOne();
    }

    @And("^I select Delivery Details$")
    public void iSelectDeliveryDetails() throws InterruptedException {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".radio:nth-child(1) [name=\"shipping_address\"]")));
        Checkout.clickExistingDeliveryAddress();
    }

    @And("^I click Continue to Delivery Method$")
    public void iClickContinueToDeliveryMethod() throws InterruptedException {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"button-shipping-address\"]")));
        Checkout.clickContinueTwo();
    }

    @And("^I select Delivery Method$")
    public void iSelectDeliveryMethod() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"shipping_method\"]")));
        Checkout.clickFlatRate();
    }

    @And("^click Continue to Payment Method$")
    public void clickContinueToPaymentMethod() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"button-shipping-method\"]")));
        Checkout.clickContinueThree();
    }

    @And("^I select Cash On Delivery$")
    public void iSelectPaymentMethod() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"payment_method\"]")));
        Checkout.clickCash();
    }

    @And("^I click Agree$")
    public void iClickAgree() {
        Checkout.clickAgree();
    }

    @And("^I click Continue to Confirm Order$")
    public void iClickContinueToConfirmOrder() {
        Checkout.clickContinueFour();
    }

    @And("^I click Confirm Order$")
    public void iClickConfirmOrder() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"button-confirm\"]")));
        Checkout.clickConfirm();
    }

    @Then("^I see that My Order is placed$")
    public void iSeeThatMyOrderIsPlaced() {
        assertTrue(Checkout.ConfirmationMessage.isDisplayed());
    }



}