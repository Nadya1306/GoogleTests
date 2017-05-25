package Shared;

import Shared.BasePageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginGoogleApplication extends BasePageObject {

    public LoginGoogleApplication(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

      //  Assert assert = new Assert();
    }

     @FindBy(id = "gb_70")
    WebElement goTologInButton;

    @FindBy(id = "Email")
    WebElement mailField;

    @FindBy(id = "next")
    private WebElement logInButton;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(css = ".gb_9a")
    WebElement accountButton;

    @FindBy(id = "gb_71")
    WebElement signOutButton;

    //Assert.assertTrue(!goTologInButton.isDisplayed());



    public void logIn (String username, String password){

        //this.waitForElement(ExpectedConditions.presenceOfElementLocated(By.id("gb_70")),10);

        goTologInButton.click();

        mailField.sendKeys(username);

        logInButton.click();

        passwordField.sendKeys(password);

        signInButton.click();

    }

    public void logOut(){

        accountButton.click();

        signOutButton.click();
    }


}
