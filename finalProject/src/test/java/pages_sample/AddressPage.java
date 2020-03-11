package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    @FindBy(how = How.CSS, using = "#column-right [href$='address']")
    private WebElement addressBook;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    private WebElement newAddressButton;
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement nameField;
    @FindBy (how = How.ID,using = "input-lastname")
    private WebElement lastNameField;
    @FindBy (how = How.ID, using = "input-address-1")
    private WebElement address1Field;
    @FindBy (how = How.ID, using = "input-city")
    private WebElement cityField;
    @FindBy (how = How.ID, using = "input-postcode")
    private WebElement postCodeField;
    @FindBy (how = How.ID, using = "input-country")
    private WebElement countryDropdown;
    @FindBy (how = How.ID, using = "input-zone")
    private WebElement regionDropdown;
    @FindBy (how = How.XPATH, using = "//input[@value='1']")
    private WebElement yesButton;


    public void addressSubmenu(){
        addressBook.click();
    }
    public void addNewAddress(){
        newAddressButton.click();
    }
    public void addName(String name){
        nameField.sendKeys(name);
    }
    public void addLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }
    public void addAddress (String address){
        address1Field.sendKeys(address);
    }
    public void addCity(String city){
        cityField.sendKeys(city);
    }
    public void addPostCode(String postCode){
      postCodeField.sendKeys(postCode);
    }

    public void chooseCountry(String country){
        WebElement countryDropDown = countryDropdown;
        Select dropdown = new Select(countryDropDown);
        dropdown.selectByVisibleText(country);
    }

    public void chooseRegion (String region){
        WebElement regionDropDown = regionDropdown;
        Select dropdown = new Select(regionDropDown);
        dropdown.selectByVisibleText(region);
    }

    public void checkDefault(){

    }
    public void checkNonDefault(){

    }

    public void chooseYes(){
        yesButton.click();
    }
    public boolean isYesChosen(){
        return yesButton.isSelected();
    }

}
