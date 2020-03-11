package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditAccPage {
    @FindBy(how = How.XPATH, using = "//*[@id='column-right']/div/a[2]")
    private WebElement editSubmenu;
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement nameField;
    @FindBy (how = How.ID,using = "input-lastname")
    private WebElement lastNameField;
    @FindBy (how = How.ID, using = "input-email")
    private WebElement emailField;
    @FindBy (how = How.ID, using = "input-telephone")
    private WebElement phoneField;
    @FindBy (how = How.ID, using = "//input[@value='Continue']")
    private WebElement submitButton;


    public void editAcc(){
        editSubmenu.click();
    }
    public void editName(String newName){
        nameField.clear();
        nameField.sendKeys(newName);
    }
    public void editLastName(String newLastName){
        lastNameField.clear();
        lastNameField.sendKeys(newLastName);
    }
    public void editEmail(String newEmail){
        emailField.clear();
        emailField.sendKeys(newEmail);
    }
    public void editPhone(String newPhone){
        phoneField.clear();
        phoneField.sendKeys(newPhone);
    }
    public void submitEditing(){
        submitButton.click();
    }
}
