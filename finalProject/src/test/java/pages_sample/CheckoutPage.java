package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckoutPage {
   //    driver = new chromdriver();
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    @FindBy(how = How.XPATH, using = "//a[.='Desktops']")
    private WebElement desktops;
    @FindBy(how = How.XPATH, using = "//a[.='Mac (1)']']")
    private WebElement iMac;
    @FindBy(how = How.XPATH, using = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//i[@class='fa fa-shopping-cart']")
    private WebElement iMacAddtoCart;
    @FindBy(how = How.XPATH, using = "//span[.='Checkout']")
    private WebElement checkout;
    @FindBy(how = How.XPATH, using = "//input[@value='guest']")
    private WebElement GuestCheckout;
    @FindBy(how = How.CSS, using = "div[class='col-sm-6'] input[value='Continue']")
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
    @FindBy(how = How.CSS, using = "#input-payment-country")
    private WebElement Country;
    Select drpCountry = new Select(driver.findElement(By.cssSelector("#input-payment-country")));
    @FindBy(how = How.XPATH, using = "//option[@value='222']")
    private WebElement UnitedKingdom;
    @FindBy(how = How.CSS, using = "#input-payment-zone")
    private WebElement Zone;
    Select drpZone = new Select(driver.findElement(By.cssSelector("#input-payment-zone")));
    @FindBy(how = How.XPATH, using = "//option[@value='3513']")
    private WebElement Aberdeen;
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
    // @FindBy(how = How.XPATH, using = "//strong[contains(.,'Shipping')]/parent::following-sibling::*")
    private String ShippingRateVALUE;
    @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'Eco Tax')]")
    private WebElement EcoTax;
    // @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'Eco Tax')]/parent::following-sibling::*")
    private String EcoTaxVALUE;
    @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'VAT')]")
    private WebElement VAT;
    // @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'VAT')]/parent::following-sibling::")
    private String VATVALUE;
    @FindBy(how = How.CSS, using = "a[href='#collapse-payment-address']")
    private WebElement BillingDetails;
    @FindBy(how = How.XPATH, using = "//option[@value='117']")
    private WebElement Latvia;
    @FindBy(how = How.XPATH, using = "//option[@value='4053']")
    private WebElement AdazuNovads;


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        desktops.click();
        iMac.click();
        iMacAddtoCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//i[@class='fa fa-shopping-cart']")));
        iMacAddtoCart.click();


    }

    public void createOrder() {
        checkout.click();
        GuestCheckout = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='guest']")));
        GuestCheckout.click();
        Step1Continue.click();
        Firstname.sendKeys("Janis");
        Lastname.sendKeys("Berzins");
        EMail.sendKeys("janis@janis.com");
        Telephone.sendKeys("123");
        Address.sendKeys("default");
        City.sendKeys("CityName");
        PostCode.sendKeys("code123");
        Country.click();
        drpCountry.selectByVisibleText("United Kingdom");
        drpZone.selectByVisibleText("Aberdeenshire");
        Step2Continue.click();
        Step3Continue.click();
        TermsAndConditions.click();
        Step5Continue.click();


    }

    //Getter
    public String GETcollectShippingRateDataUK() {
        return ShippingRateVALUE;
    }

    //Setter
    public void SETcollectShippingRateDataUK(String ShippingRateVALUE) {

        if (ShippingRate.isDisplayed()) {

            this.ShippingRateVALUE = driver.findElement(By.xpath("//strong[contains(.,'Shipping')]/parent::*/following-sibling::*")).getText();
            System.out.println(ShippingRateVALUE);
} else {
        this.ShippingRateVALUE = null;
        System.out.println("Shipping rate is not displayed");

        }


        }

//Getter
public String GETcollectEcoTaxDataUK() {
        return EcoTaxVALUE;
        }

//Setter
public void SETcollectEcoTaxDataUK(String EcoTaxVALUE) {

        if (EcoTax.isDisplayed()) {
        this.EcoTaxVALUE = driver.findElement(By.xpath("//td[@colspan='4']/strong[contains(.,'Eco Tax')]/parent::*/following-sibling::*")).getText();
        System.out.println(EcoTaxVALUE);
        } else {
        this.EcoTaxVALUE = null;
        System.out.println("Eco Tax is not displayed");

        }

        }

//Getter
public String GETcollectVATDataUK() {
        return VATVALUE;
        }

//Setter
public void SETcollectVATDataUK(String VATVALUE) {

        if (VAT.isDisplayed()) {
        this.VATVALUE = driver.findElement(By.xpath("//td[@colspan='4']/strong[contains(.,'VAT')]/parent::*/following-sibling::*")).getText();
        System.out.println(VATVALUE);
        } else {
        this.VATVALUE = null;
        System.out.println("VAT is not displayed");

        }

        }



}
