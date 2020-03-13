package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AppleCinemaProduct {

    public String GetAppleCinemaPage() {
        return "http://www.demoshop24.com/index.php?route=product/product&product_id=42";
    }
    @FindBy(how = How.CSS, using = ".dropdown-toggle[href$=\"25\"]")
    public WebElement components;
    @FindBy(how = How.CSS, using = ".list-unstyled [href$=\"28\"]")
    public WebElement monitors;

    @FindBy(how = How.CSS, using = ".caption a[href*=\"id=42\"]")
    public WebElement productNameAppleCinema;
    @FindBy(how = How.CSS, using = ".image a[href*=\"id=42\"]")
    public WebElement productImageAppleCinema;

    @FindBy(how = How.CSS, using = "img[src*=\"cinema\"]")
    public WebElement imageAppleCinema;
    @FindBy(how = How.CSS, using = "[class=\"col-sm-4\"]:nth-child(2)>h1")
    public WebElement nameAppleCinema;
    @FindBy(how = How.CSS, using = ".btn-default>[class*=\"fa-heart\"]")
    public WebElement AddToWishListButton;
    @FindBy(how = How.CSS, using = "[id=\"button-cart\"]")
    public WebElement AddToCartButton;
    @FindBy(how = How.CSS, using = ".btn-default>[class*=\"fa-exchange\"]")
    public WebElement CompareButton;
    @FindBy(how = How.CSS, using = "#product>h3")
    public WebElement AvailableOptions;
    @FindBy(how = How.CSS, using = "a[href*=\"tab-description\"]")
    public WebElement Description;
    @FindBy(how = How.CSS, using = "a[href*=\"tab-specification\"]")
    public WebElement Specification;
    @FindBy(how = How.CSS, using = "a[href*=\"tab-review\"]")
    public WebElement Review;
    @FindBy(how = How.CSS, using = ".list-unstyled h2")
    public WebElement Price;


    public void clickComponents() {components.click();}
    public void clickMonitors() {monitors.click();}
    public void clickAppleCinemaName() { productNameAppleCinema.click(); }
    public void clickAppleCinemaImage() { productImageAppleCinema.click(); }


}