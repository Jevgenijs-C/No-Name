package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;

public class AppleCinemaProduct {

    public String GetAppleCinemaPage() {
        return "http://www.demoshop24.com/index.php?route=product/product&product_id=42";
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/h4/a")
    public WebElement productNameAppleCinema;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[3]/div/div[1]/a/img")
    public WebElement productImageAppleCinema;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[1]/ul[1]/li[1]/a/img")
    public WebElement imageAppleCinema;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/h1")
    public WebElement nameAppleCinema;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]/i")
    public WebElement AddToWishListButton;
    @FindBy(how = How.CSS, using = "[id=\"button-cart\"]")
    public WebElement AddToCartButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[2]")
    public WebElement CompareButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"product\"]/h3")
    public WebElement AvailableOptions;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[1]/a")
    public WebElement Description;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")
    public WebElement Specification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[3]/a")
    public WebElement Review;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[1]/div[2]/ul[2]/li[2]/h2")
    public WebElement Price;

    public void clickAppleCinemaName() {
        productNameAppleCinema.click();
    }
    public void clickAppleCinemaImage() { productImageAppleCinema.click(); }


}
