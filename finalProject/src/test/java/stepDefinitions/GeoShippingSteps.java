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
import pages_sample.CheckoutPage;
import pages_sample.LogInPage;
import sun.rmi.runtime.Log;

public class GeoShippingSteps {
    private WebDriver driver;
    private CheckoutPage checkoutPage;



    public GeoShippingSteps() {

        this.driver = Hooks.driver;
        checkoutPage = PageFactory.initElements(Hooks.driver, CheckoutPage.class);
        checkoutPage.setDriver(driver);
    }
    @Given("^demoshop homepage is opened$")
    public void demoshop_homepage_is_opened() throws Throwable {
        driver.get("http://demoshop24.com/");
    }


    @And("^i have created product order in UK$")
    public void i_have_created_product_order_in_UK() throws Throwable {

    }

    @And("^i collect data about Shipping Rate$")
    public void i_collect_data_about_Shipping_Rate() throws Throwable {

    }

    @And("^i collect data about Eco Tax$")
    public void i_collect_data_about_Eco_Tax() throws Throwable {

    }

    @And("^i collect data about VAT$")
    public void i_collect_data_about_VAT() throws Throwable {

    }

    @And("^i change target adress from UK to Latvia$")
    public void i_change_target_adress_from_UK_to_Latvia() throws Throwable {

    }

    @Then("^i see that Shipping Rate differs between UK and Latvia$")
    public void i_see_that_Shipping_Rate_differs_between_UK_and_Latvia() throws Throwable {

    }

    @And("^Eco Tax differs between UK and Latvia$")
    public void eco_Tax_differs_between_UK_and_Latvia() throws Throwable {

    }

    @And("^VAT differs between UK and Latvia$")
    public void vat_differs_between_UK_and_Latvia() throws Throwable {

    }
}
