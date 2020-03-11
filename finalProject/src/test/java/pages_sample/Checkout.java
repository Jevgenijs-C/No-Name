package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;


public class Checkout {
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/h4/a")
    private WebElement CheckoutButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"collapse-payment-address\"]/div/form/div[1]/label/input")
    private WebElement SelectBillingDetails;
    @FindBy(how = How.CSS, using = "[id=\"button-payment-address\"]")
    private WebElement BillingContinue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"collapse-shipping-address\"]/div/form/div[1]/label/input")
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
