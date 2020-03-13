package pages_sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Review {
    @FindBy(how = How.CSS, using = "[onclick*=\"tab-review\"]:last-child")
    public WebElement WriteReview;
    @FindBy(how = How.CSS, using = ".active [href*=\"#tab-review\"][aria-expanded = \"true\"]")
    public WebElement TabReviewIsOpened;
    @FindBy(how = How.CSS, using = "#input-name")
    public WebElement nameInputField;
    @FindBy(how = How.CSS, using = "#input-review")
    public WebElement reviewInputField;
    @FindBy(how = How.CSS, using = "[type=\"radio\"][value=\"1\"]")
    public WebElement ratingWithValueOne;
    @FindBy(how = How.CSS, using = "[type=\"radio\"][value=\"2\"]")
    public WebElement ratingWithValueTwo;
    @FindBy(how = How.CSS, using = "[type=\"radio\"][value=\"3\"]")
    public WebElement ratingWithValueThree;
    @FindBy(how = How.CSS, using = "[type=\"radio\"][value=\"4\"]")
    public WebElement ratingWithValueFour;
    @FindBy(how = How.CSS, using = "[type=\"radio\"][value=\"5\"]")
    public WebElement ratingWithValueFive;
    @FindBy(how = How.CSS, using = ".pull-right #button-review")
    public WebElement ContinueSubmitReview;
    @FindBy(how = How.CSS, using = ".alert-success")
    public WebElement successMessage;
    @FindBy(how = How.CSS, using = ".alert-danger")
    public WebElement errorText;
    @FindBy(how = How.CSS, using = "alert-danger")
    public WebElement errorRating;

    public void clickWriteReview() { WriteReview.click(); }
    public void enterNameInReview(String name){ nameInputField.sendKeys(name);
    }
    public void enterTextInReview(String text){ reviewInputField.sendKeys(text);
    }
    public void enterInvalidText(String invalidText) {reviewInputField.sendKeys(invalidText);}
    public void enterInvalidName(String invalidName) {reviewInputField.sendKeys(invalidName);}
    public void selectRatingOne() { ratingWithValueOne.click(); }
    public void selectRatingTwo() { ratingWithValueTwo.click();}
    public void selectRatingThree() { ratingWithValueThree.click();}
    public void selectRatingFour() { ratingWithValueFour.click();}
    public void selectRatingFive() { ratingWithValueFive.click();}
    public void clickContinueReview(){ ContinueSubmitReview.click();}
    public String successMessageText(){return successMessage.getText();}
    public String errorTextMessageText() {return errorText.getText();}
    public String errorRatingMessageText() {return errorRating.getText();}

}

