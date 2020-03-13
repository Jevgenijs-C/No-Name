package pages_sample;

import com.gargoylesoftware.htmlunit.html.DomNode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IPhoneProduct {
    public String GeIPhonePage() {
        return "http://www.demoshop24.com/index.php?route=product/product&product_id=40";
    }
    //click Phones and pda
    @FindBy(how = How.CSS, using = "a[href*=\"category&path=24\"]")
    public WebElement PhonesTab;
    @FindBy(how = How.CSS, using = "h4 a[href*=\"id=40\"]")
    public WebElement productNameIPhone;
    @FindBy(how = How.CSS, using = ".image a[href*=\"id=40\"]")
    public WebElement productImageIPhone;
    @FindBy(how = How.CSS, using = "[id=\"button-cart\"]")
    public WebElement AddToCart;



    @FindBy(how = How.CSS, using = "[id=\"cart\"]")
    public WebElement CartTotalButton;
    @FindBy(how = How.CSS, using = ".text-left [href*=\"id=40\"]")
    public WebElement IPhoneIsAddedToCart;

    public void clickPhonesTab() {PhonesTab.click();}
    public void clickIPhoneName() { productNameIPhone.click(); }
    public void clickIPhoneImage() { productImageIPhone.click(); }

    public void clickAddToCart() {AddToCart.click();}
    public void clickToSeeCart() {CartTotalButton.click();}


}

