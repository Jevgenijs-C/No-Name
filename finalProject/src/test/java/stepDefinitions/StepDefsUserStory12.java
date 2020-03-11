package stepDefinitions;

import org.openqa.selenium.*;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByAll;
import pages_sample.AppleCinemaProduct;
import pages_sample.IPhoneProduct;
import pages_sample.HomePage;
import pages_sample.Checkout;
import pages_sample.Review;

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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;


public class StepDefsUserStory12 {
    private static WebDriverWait wait;
    static long startTime;
    private WebDriver driver;
    static AppleCinemaProduct AppleCinemaProduct;
    static IPhoneProduct IPhoneProduct;
    static HomePage HomePage;
    static Checkout Checkout;
    static Review Review;

    public StepDefsUserStory12() {
        this.driver = Hooks.driver;
        AppleCinemaProduct = PageFactory.initElements(Hooks.driver, AppleCinemaProduct.class);
        IPhoneProduct = PageFactory.initElements(Hooks.driver, IPhoneProduct.class);
        HomePage = PageFactory.initElements(Hooks.driver, HomePage.class);
        Checkout = PageFactory.initElements(Hooks.driver, Checkout.class);
        Review = PageFactory.initElements(Hooks.driver, Review.class);
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
        driver = new ChromeDriver();
    }

    @Given("^I am one the HomePage$")
    public void i_am_on_the_home_page() throws Throwable {
        driver.get(HomePage.GetHomePage());
    }


    @When("^I click on Apple Cinema name$")
    public void i_click_on_apple_cinema_name() throws Throwable {
        AppleCinemaProduct.clickAppleCinemaName();
    }

    @Then("^I am redirected to Apple Cinema page$")
    public void i_am_redirected_to_apple_cinema_page() throws Throwable {
        AppleCinemaProduct.GetAppleCinemaPage();
    }

    @When("^I click on Apple Cinema image$")
    public void i_click_on_apple_cinema_image() throws Throwable {
        AppleCinemaProduct.clickAppleCinemaImage();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Then("^Product (.+) is visible$")
    public void product_is_visible(String info) throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(info));
    }
}