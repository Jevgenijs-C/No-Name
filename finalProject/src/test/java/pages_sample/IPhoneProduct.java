package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;

public class IPhoneProduct {

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/h4/a")
    private WebElement productNameIPhone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a/img")
    private WebElement productImageIPhone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/div[3]/p/a[2]")
    private WebElement WriteReview;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
    private WebElement AddToCart;

    public void clickIPhoneName() { productNameIPhone.click(); }
    public void clickIPhoneImage() { productImageIPhone.click(); }
    public void clickWriteReview() { WriteReview.click(); }


}

