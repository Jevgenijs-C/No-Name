package pages_sample;

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
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement lastNameField;
    @FindBy(how = How.ID, using = "input-address-1")
    private WebElement address1Field;
    @FindBy(how = How.ID, using = "input-city")
    private WebElement cityField;
    @FindBy(how = How.ID, using = "input-postcode")
    private WebElement postCodeField;
    @FindBy(how = How.ID, using = "input-country")
    private WebElement countryDropdown;
    @FindBy(how = How.NAME, using = "zone_id")
    private WebElement regionDropdown;
    @FindBy(how = How.CSS, using = ".radio-inline [value='1']")
    private WebElement yesButton;
    @FindBy(how = How.CSS, using = "tr:nth-child(1) a[href*='edit']")
    private WebElement editNewAddress;
    @FindBy(how = How.CSS, using = "tr:nth-child(2) a[href*='edit']")
    private WebElement editOldAddress;
    @FindBy(how = How.CSS, using = ".pull-left [href*=address]")
    private WebElement backButton;
    @FindBy(how = How.CSS, using = "tr:nth-child(2) a[href*='delete']")
    private WebElement deleteNonDefault;

    public void addressSubmenu() {
        addressBook.click();
    }

    public void addNewAddress() {
        newAddressButton.click();
    }

    public void addName(String name) {
        nameField.sendKeys(name);
    }

    public void addLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void addAddress(String address) {
        address1Field.sendKeys(address);
    }

    public void addCity(String city) {
        cityField.sendKeys(city);
    }

    public void addPostCode(String postCode) {
        postCodeField.sendKeys(postCode);
    }

    public void chooseCountry(String country) {
        WebElement countryDropDown = countryDropdown;
        Select dropdown = new Select(countryDropDown);
        dropdown.selectByVisibleText(country);
    }

    public void chooseRegion(String region) throws InterruptedException {
        WebElement regionDropDown = regionDropdown;

        Select dropdown = new Select(regionDropDown);
        dropdown.selectByVisibleText(region);
    }

    public void checkDefault() {
        editNewAddress.click();
    }

    public void deleteNotDefault(){
        backButton.click();
        deleteNonDefault.click();
    }

    public void checkNonDefault() {
        backButton.click();
        editOldAddress.click();
    }

    public void chooseYes() {
        yesButton.click();
    }

    public boolean isYesChosen() {
        return yesButton.isSelected();
    }

}
