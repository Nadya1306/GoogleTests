package GmailApplication.GmailPageObjcts;

import Shared.BasePageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePageObject {

    @FindBy(id = "identifierId")
    private WebElement userNameField;

    @FindBy(id = "identifierNext")
    private WebElement logInButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement signInButton;

    @FindBy(xpath = "descendant::div[@class='dEOOab RxsGPe']")
    private  WebElement errorMessageForUserNameField;

    @FindBy(id = "errormsg_0_Passwd")
    private WebElement errorMessageForPasswordField;

    @FindBy(xpath = ".//*[@id ='glifPromo']/div[1]/p[1]/a")
    private WebElement linkLearnMore;

    @FindBy(xpath = ".//*[@class ='fImV7']/div[2]")
    private  WebElement moreOptionsLink;

    @FindBy(xpath = "//content[contains(@class, 'z80M1') and .//div[contains(., 'Forgot email?')]]")
    private WebElement forgotEmailLink;

    @FindBy(id = "McfNlf")
    private WebElement secureOkButton;

    @FindBy(xpath =".//*[@id='lang-chooser']/div[1]/div[2]/div")
    private WebElement languageList;

    public LoginPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }


    public void enterUserName(String username) {

        userNameField.sendKeys(username);

        logInButton.click();
    }

    public void enterUserPassword(String password) {

        super.waitForElement(ExpectedConditions.visibilityOf(passwordField),ConstantForWait.waitConstantOfSeconds());

        passwordField.sendKeys(password);

        signInButton.click();
    }

    public LearnMorePage clickLinkLearnMore(){

        String parentHandle = this.driver.getWindowHandle();

        linkLearnMore.click();

        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }

        return new LearnMorePage(driver);
    }

    public void  clickMoreOptionsLink(){

        moreOptionsLink.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ForgotEmailPage clickForgotEmailLink(){

        forgotEmailLink.click();

        return  new ForgotEmailPage(driver);
    }

    public void clickLanguageList(){

        super.waitForElement(ExpectedConditions.visibilityOf(languageList),ConstantForWait.waitConstantOfSeconds());

        languageList.click();
    }

    public void clickOkSecureButton(){

        super.waitForElement(ExpectedConditions.visibilityOf(secureOkButton),ConstantForWait.waitConstantOfSeconds());

        secureOkButton.click();
    }


    public void assertErrorMessageForUserNameFieldIsShown() {
        super.waitForElement(ExpectedConditions.visibilityOf(errorMessageForUserNameField), ConstantForWait.waitConstantOfSeconds());

        Assert.assertTrue("Error message for user name field on login screen is not shown.", errorMessageForUserNameField.isDisplayed());
    }

    public void assertErrorMessageForEmptyUserNameFieldShown(){

        assertErrorMessageForUserNameFieldIsShown();

        Assert.assertTrue(errorMessageForUserNameField.getText().contains("Enter an email or phone number"));
    }

    public void assertErrorMessageForNotRecognizedUserNameFieldShown(){

        assertErrorMessageForUserNameFieldIsShown();

        Assert.assertTrue(errorMessageForUserNameField.getText().contains("Couldn't find your Google Account"));
    }

    public void assertErrorMessageForPasswordFieldShown(){

        Assert.assertTrue(errorMessageForPasswordField.isDisplayed());
    }
}
