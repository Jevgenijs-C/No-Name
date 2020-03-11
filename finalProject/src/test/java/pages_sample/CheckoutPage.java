package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
//    driver = new chromdriver();

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
    @FindBy(how = How.XPATH, using = "//input[@value='Continue']")
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
    @FindBy(how = How.XPATH, using = "//option[@value='222']")
    private WebElement UnitedKingdom;
    @FindBy(how = How.XPATH, using = "//option[@value='3513']")
    private WebElement Aberdeen;







    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {

        desktops.click();
        iMac.click();
        iMacAddtoCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//i[@class='fa fa-shopping-cart']")));
        iMacAddtoCart.click();


    }

}
