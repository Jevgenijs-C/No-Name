package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInAccPage {
    @FindBy(how = How.ID, using = "input-email")
    private WebElement eMailField;
    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginButton;

    public void enterMail(String email) {
        eMailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void logIn() {
        loginButton.click();
    }
}
