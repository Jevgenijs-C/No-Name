package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;

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
    @FindBy(how = How.XPATH, using = "//input[@value='Continue']") /*"div[class='col-sm-6'] input[value='Continue']"*/
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
    @FindBy(how = How.XPATH, using = "//strong[contains(.,'Shipping')]/parent::*/following-sibling::*")
    private WebElement ShippingRateVALUE;
    @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'Eco Tax')]")
    private WebElement EcoTax;
    @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'Eco Tax')]/parent::*/following-sibling::*")
    private WebElement EcoTaxVALUE;
    @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'VAT')]")
    private WebElement VAT;
    @FindBy(how = How.XPATH, using = "//td[@colspan='4']/strong[contains(.,'VAT')]/parent::*/following-sibling::*")
    private WebElement VATVALUE;
    @FindBy(how = How.CSS, using = "a[href='#collapse-payment-address']")
    private WebElement BillingDetails;

    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(desktops)).click();
        // desktops.click();
        wait.until(ExpectedConditions.visibilityOf(iMac)).click();
        // iMac.click();
        wait.until(ExpectedConditions.visibilityOf(iMacAddtoCart)).click();
        //  iMacAddtoCart.click();

    }

    public void createOrder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(checkout)).click();
        // checkout.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(GuestCheckout)).click();
        //  GuestCheckout.click();
        Step1Continue.click();
        wait.until(ExpectedConditions.visibilityOf(Firstname)).sendKeys("Janis");
        //  Firstname.sendKeys("Janis");
        Lastname.sendKeys("Berzins");
        EMail.sendKeys("janis@janis.com");
        Telephone.sendKeys("123");
        Address.sendKeys("default");
        City.sendKeys("CityName");
        PostCode.sendKeys("code123");

        WebElement countryDropDown = countryDropdown;
        Select dropdown = new Select(countryDropDown);
        dropdown.selectByVisibleText("United Kingdom");
        wait.until(ExpectedConditions.visibilityOf(zoneDropdown));
        WebElement zoneDropDown = zoneDropdown;
        Select zoneDrop = new Select(zoneDropDown);
        zoneDrop.selectByVisibleText("Aberdeenshire");
        wait.until(ExpectedConditions.visibilityOf(Step2Continue)).click();
        // Step2Continue.click();
        wait.until(ExpectedConditions.visibilityOf(Step3Continue)).click();
        //  Step3Continue.click();
        wait.until(ExpectedConditions.visibilityOf(TermsAndConditions)).click();
        // TermsAndConditions.click();
        Step5Continue.click();
        Thread.sleep(3000);

    }

    public String collectShipRateUK() {

        String shippingValuetext = ShippingRateVALUE.getText();
        return shippingValuetext;
    }

    public String collectEcoTaxUK() {
        String ecotaxvaluetext = EcoTaxVALUE.getText();
        return ecotaxvaluetext;
    }

    public String collectVATUK() {
        String VATvaluetext = VATVALUE.getText();
        return VATvaluetext;
    }

    public void changeTargetAdressLatvia() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        BillingDetails.click();
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        WebElement countryDropDown = countryDropdown;
        Select dropdown = new Select(countryDropDown);
        dropdown.selectByVisibleText("Latvia");
        wait.until(ExpectedConditions.visibilityOf(zoneDropdown));
        WebElement zoneDropDown = zoneDropdown;
        Select zoneDrop = new Select(zoneDropDown);
        zoneDrop.selectByVisibleText("Ādažu novads");

        Step2Continue.click();
        wait.until(ExpectedConditions.visibilityOf(Step3Continue)).click();
        // Step3Continue.click();
        wait.until(ExpectedConditions.visibilityOf(TermsAndConditions)).click();
        // TermsAndConditions.click();
        Step5Continue.click();
        Thread.sleep(3000);
    }

    public String collectShipRateLV() throws InterruptedException {
        if (ShippingRate.isDisplayed()) {
            String shippingValuetext2 = ShippingRateVALUE.getText();
            return shippingValuetext2;
        } else {
            System.out.println("Shipping rate is not displayed");
            String shippingValuetext2 = null;
            return shippingValuetext2;

        }


    }


    public String collectEcoTaxLV() throws InterruptedException {
        assertTrue(driver.findElement(By.xpath("//td[@colspan='4']/strong[contains(.,'Eco Tax')]")).isDisplayed());
        if (driver.findElement(By.xpath("//td[@colspan='4']/strong[contains(.,'Eco Tax')]")) == null) {
            System.out.println("Eco Tax is not displayed");
            String ecotaxvaluetext2 = null;
            return ecotaxvaluetext2;


        } else {
            String ecotaxvaluetext2 = EcoTaxVALUE.getText();
            return ecotaxvaluetext2;

           /* assertFalse(EcoTax.isDisplayed());
            return "";*/

        }
    }

    public String collectVATLV() throws InterruptedException {
        if (VAT.getSize() == null) {
            System.out.println("VAT is not displayed");
            String VATvaluetext2 = null;
            return VATvaluetext2;


        } else {
            String VATvaluetext2 = VATVALUE.getText();
            return VATvaluetext2;


        }


    }
}
