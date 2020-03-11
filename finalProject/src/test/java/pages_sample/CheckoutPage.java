package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage {
    @FindBy (how = How.XPATH, using = "//a[.='Desktops']")
    private WebElement desktops;
    @FindBy (how = How.XPATH, using = "//a[.='Mac (1)']']")
    private WebElement iMac;

}
