package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage12 {


    @FindBy (how = How.ID, using = "input-email")
    private WebElement eMailField;
    @FindBy (how = How.ID, using = "input-password")
    private WebElement passwordField;
    @FindBy (how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginButton;

    public void enterMail(){
        eMailField.sendKeys("victoriaushkova@gmail.com");
    }
    public void enterPassword(){
        passwordField.sendKeys("bailando153");
    }
    public void logIn(){
        loginButton.click();
    }
}