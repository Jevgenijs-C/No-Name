package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {


    @FindBy (how = How.ID, using = "input-email")
    private WebElement eMailField;
    @FindBy (how = How.ID, using = "input-password")
    private WebElement passwordField;
    @FindBy (how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginButton;

    public void enterMail(){
        eMailField.sendKeys("testt@test.com");
    }
    public void enterPassword(){
        passwordField.sendKeys("12345");
    }
    public void logIn(){
        loginButton.click();
    }
}
