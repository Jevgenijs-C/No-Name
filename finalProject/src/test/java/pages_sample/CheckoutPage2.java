package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage2 {
    @FindBy(how = How.XPATH, using = "//a[.='Desktops']")
    private WebElement desktops;
    @FindBy(how = How.XPATH, using = "//a[.='Mac (1)']")
    private WebElement iMac;
    @FindBy(how = How.XPATH, using = "//button[@onclick=\"cart.add('41', '1');\"]")
    private WebElement iMacAddtoCart;
    @FindBy(how = How.CSS, using = "a[href$=\"checkout\"]")
    private WebElement checkout;
    @FindBy(how = How.XPATH, using = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
    private WebElement GuestCheckout;
    @FindBy(how = How.XPATH, using = "//input[@value='Continue']" ) /*"div[class='col-sm-6'] input[value='Continue']"*/
    private WebElement Step1Continue;
    @FindBy(how = How.CSS, using = "#input-payment-firstname")
    private WebElement Firstname;
    @FindBy(how = How.CSS, using = "#input-payment-lastname")
    private WebElement Lastname;
    @FindBy(how = How.CSS, using = "#input-payment-email")
    private WebElement EMail;
    @FindBy(how = How.CSS, using = "#input-payment-telephone")
    private WebElement Telephone;
    @FindBy(how = How.CSS, using = "#input-payment-address-1")
    private WebElement Address;
    @FindBy(how = How.CSS, using = "#input-payment-city")
    private WebElement City;
    @FindBy(how = How.CSS, using = "#input-payment-postcode")
    private WebElement PostCode;
    @FindBy(how = How.CSS, using = "#input-payment-zone")
    private WebElement zoneDropdown;
    @FindBy(how = How.ID, using = "input-payment-country")
    private WebElement countryDropdown;
    @FindBy(how = How.CSS, using = "div[id='collapse-payment-address'] input[value='Continue']")
    private WebElement Step2Continue;
    @FindBy(how = How.CSS, using = "div[id='collapse-shipping-method'] input[value='Continue']")
    private WebElement Step3Continue;
    @FindBy(how = How.CSS, using = "input[name='agree']")
    private WebElement TermsAndConditions;
    @FindBy(how = How.CSS, using = "input[name='agree']+*")
    private WebElement Step5Continue;
    @FindBy(how = How.XPATH, using = "//strong[contains(.,'Shipping')]")
    private WebElement ShippingRate;

    public void addToCart(){
        desktops.click();
        iMac.click();
        iMacAddtoCart.click();
    }

    public void createOrder() throws InterruptedException {

        checkout.click();
        Thread.sleep(10000);
        GuestCheckout.click();
        Step1Continue.click();
        Firstname.sendKeys("Janis");
        Lastname.sendKeys("Berzins");
        EMail.sendKeys("janis@janis.com");
        Telephone.sendKeys("123");
        Address.sendKeys("default");
        City.sendKeys("CityName");
        PostCode.sendKeys("code123");

        WebElement countryDropDown = countryDropdown;
        Select dropdown = new Select(countryDropDown);
        dropdown.selectByVisibleText("United Kingdom");

        WebElement zoneDropDown = zoneDropdown;
        Select zoneDrop = new Select(zoneDropDown);
        zoneDrop.selectByVisibleText("Aberdeenshire");

        Step2Continue.click();
        Step3Continue.click();
        TermsAndConditions.click();
        Step5Continue.click();
    }
}
