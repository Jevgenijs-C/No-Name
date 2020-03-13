package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AccountPage {

    @FindBy(how = How.CLASS_NAME, using = "list-group-item")
    private List<WebElement> submenus;

    public List<WebElement> listOfItems() {
        return submenus;
    }

}
