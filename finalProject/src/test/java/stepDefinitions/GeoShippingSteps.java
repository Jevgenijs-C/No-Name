package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages_sample.CheckoutPage2;


public class GeoShippingSteps {
    private WebDriver driver;
    private CheckoutPage2 checkoutPage2;

    public GeoShippingSteps() {
        this.driver = Hooks.driver;
        checkoutPage2 = PageFactory.initElements(Hooks.driver, CheckoutPage2.class);
        /*checkoutPage.setDriver(driver);*/
        checkoutPage2.setDriver(driver);
    }

    @Given("^demoshop homepage is opened$")
    public void demoshop_homepage_is_opened() throws Throwable {
        driver.get("http://demoshop24.com/");
    }


    @When("^i have created product order in UK$")
    public void i_have_created_product_order_in_UK() throws Throwable {
        checkoutPage2.addToCart();
        checkoutPage2.createOrder();

    }

    @And("^i collect data about Shipping Rate$")
    public void i_collect_data_about_Shipping_Rate() throws Throwable {
        checkoutPage2.collectShipRateUK();

    }

    @And("^i collect data about Eco Tax$")
    public void i_collect_data_about_Eco_Tax() throws Throwable {
        checkoutPage2.collectEcoTaxUK();
    }

    @And("^i collect data about VAT$")
    public void i_collect_data_about_VAT() throws Throwable {
        checkoutPage2.collectVATUK();
    }

    @And("^i change target adress from UK to Latvia$")
    public void i_change_target_adress_from_UK_to_Latvia() throws Throwable {
        checkoutPage2.changeTargetAdressLatvia();
    }

    @When("^i collect data about Shipping Rate again$")
    public void i_collect_data_about_Shipping_Rate_again() throws Throwable {
        checkoutPage2.collectShipRateLV();
    }

    @When("^i collect data about Eco Tax again$")
    public void i_collect_data_about_Eco_Tax_again() throws Throwable {
        checkoutPage2.collectEcoTaxLV();
    }

    @When("^i collect data about VAT again$")
    public void i_collect_data_about_VAT_again() throws Throwable {
        checkoutPage2.collectVATLV();
    }

    @Then("^i see that Shipping Rate differs between UK and Latvia$")
    public void i_see_that_Shipping_Rate_differs_between_UK_and_Latvia() throws Throwable {

        System.out.println("UK Shipping rate = " + checkoutPage2.collectShipRateUK());
        System.out.println("LV Shipping rate = " + checkoutPage2.collectShipRateLV());
        // System.out.println(checkoutPage2.collectShipRateUK().equals(checkoutPage2.collectShipRateLV())); //true

        Assert.assertFalse(checkoutPage2.collectShipRateUK().equals(checkoutPage2.collectShipRateLV()));
    }

    @And("^Eco Tax differs between UK and Latvia$")
    public void eco_Tax_differs_between_UK_and_Latvia() throws Throwable {
        String a = checkoutPage2.collectEcoTaxLV();
        if (a == null) {
            System.out.println("Eco Tax is not displayed");
        } else {
            Assert.assertFalse(checkoutPage2.collectEcoTaxUK().equals(checkoutPage2.collectEcoTaxLV()));
        }
    }

    @And("^VAT differs between UK and Latvia$")
    public void vat_differs_between_UK_and_Latvia() throws Throwable {
        String a = checkoutPage2.collectVATLV();
        if (a == null) {
            System.out.println("VAT is not displayed");
        } else {
            Assert.assertFalse(checkoutPage2.collectVATUK().equals(checkoutPage2.collectVATLV()));
        }

    }
}
