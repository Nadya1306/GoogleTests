package GmailApplication.GmailPageObjcts;


import Shared.BasePageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePageObject {

    @FindBy(id = "Email")
    private WebElement mailField;

    @FindBy(id = "next")
    private WebElement logInButton;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(id = "errormsg_0_Email")
    private  WebElement errorMessageForUserNameField;

    @FindBy(id = "errormsg_0_Passwd")
    private WebElement errorMessageForPasswordField;

    @FindBy(css = ".glif-promo a")
    private WebElement linkLearnMore;


    public LoginPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }


    public void enterUserName(String username) {

        mailField.sendKeys(username);

        logInButton.click();
    }

    public void enterUserPassword(String password) {

        passwordField.sendKeys(password);

        signInButton.click();
    }

    public void clickLinkLearnMore(){

        linkLearnMore.click();
    }

    public void assertErrorMessageForUserNameFieldIsShown() {
        super.waitForElement(ExpectedConditions.visibilityOf(errorMessageForUserNameField), 10);

        Assert.assertTrue("Error message for user name field on login screen is not shown.", errorMessageForUserNameField.isDisplayed());
    }

    public void assertErrorMessageForEmptyUserNameFieldShown(){

        assertErrorMessageForUserNameFieldIsShown();

        Assert.assertTrue(errorMessageForUserNameField.getText().contains("Enter an email or phone number. Молодец !!! ;)"));
    }

    public void assertErrorMessageForNotRecognizedUserNameFieldShown(){

        assertErrorMessageForUserNameFieldIsShown();

        Assert.assertTrue(errorMessageForUserNameField.getText().contains("Sorry, Google doesn't recognize that email."));
    }

    public void assertErrorMessageForPasswordFieldShown(){

        Assert.assertTrue(errorMessageForPasswordField.isDisplayed());
    }
}
