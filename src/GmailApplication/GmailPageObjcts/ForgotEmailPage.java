package GmailApplication.GmailPageObjcts;


import Shared.BasePageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotEmailPage extends BasePageObject {


    public ForgotEmailPage(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "Email")
    WebElement emailField;

    @FindBy(id = "next")
    WebElement nextButton;


    public void enterEmailData(String emailData){

        emailField.sendKeys(emailData);

        nextButton.click();
    }

    public void assertForgotPasswordPageIsDisplayd() {

        super.waitForElement(ExpectedConditions.visibilityOf(emailField),ConstantForWait.waitConstantOfSeconds());

        Assert.assertTrue("Element is not displayed",emailField.isDisplayed());
    }
}
