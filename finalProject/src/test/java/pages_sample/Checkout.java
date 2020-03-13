package pages_sample;

import com.gargoylesoftware.htmlunit.html.DomNode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Checkout {
    @FindBy(how = How.CSS, using = "a[title =\"Checkout\"]>i") //"[title=\"Checkout\"] .hidden-md")
    public WebElement CheckoutButton;
    @FindBy(how = How.XPATH, using = "//input [@value=\"existing\"]")
    private WebElement SelectBillingDetails;
    @FindBy(how = How.CSS, using = "[id=\"button-payment-address\"]")
    public WebElement BillingContinue;
    @FindBy(how = How.CSS, using = ".radio:nth-child(1) [name=\"shipping_address\"]")
    private WebElement SelectDeliveryDetails;
    @FindBy(how = How.CSS, using = "[id=\"button-shipping-address\"]")
    private WebElement DeliveryContinue;
    @FindBy(how = How.CSS, using = "[name=\"shipping_method\"]")
    private WebElement SelectShippingMethod;
    @FindBy(how = How.CSS, using = "[id=\"button-shipping-method\"]")
    private WebElement ContinueShippingMethod;
    @FindBy(how = How.CSS, using = "[name=\"payment_method\"]")
    private WebElement SelectPaymentMethod;
    @FindBy(how = How.CSS, using = "[name=\"agree\"]")
    private WebElement AgreeCheckbox;
    @FindBy(how = How.CSS, using = "[id=\"button-payment-method\"]")
    private WebElement PaymentMethodContinue;
    @FindBy(how = How.CSS, using = "[id=\"button-confirm\"]")
    private WebElement ConfirmOrder;
    @FindBy(how = How.CSS, using = "#content h1")
    public WebElement ConfirmationMessage;

    public String CheckoutPage() {
        return "http://www.demoshop24.com/index.php?route=checkout/checkout";
    }

    public void clickCheckout() { CheckoutButton.click(); }
    public void clickExistingAddress() { SelectBillingDetails.click(); }
    public void clickContinueOne() { BillingContinue.click(); }
    public void clickExistingDeliveryAddress() { SelectDeliveryDetails.click(); }
    public void clickContinueTwo() { DeliveryContinue.click(); }
    public void clickFlatRate() { SelectShippingMethod.click(); }
    public void clickContinueThree() { ContinueShippingMethod.click(); }
    public void clickCash() { SelectPaymentMethod.click(); }
    public void clickAgree() { AgreeCheckbox.click(); }
    public void clickContinueFour() { PaymentMethodContinue.click(); }
    public void clickConfirm() { ConfirmOrder.click(); }


}