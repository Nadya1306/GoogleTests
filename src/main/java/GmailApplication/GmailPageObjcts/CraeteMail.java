package GmailApplication.GmailPageObjcts;

import Shared.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

public class CraeteMail extends BasePageObject {


    public CraeteMail(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".T-I-KE")
    WebElement createMailButton;

    @FindBy(name = "to")
    WebElement addressField;

    @FindBy(name = "subjectbox")
    WebElement subjectField;

    @FindBy(xpath = ".//*[@class='Am Al editable LW-avf']")
    WebElement textField;

    @FindBy(xpath = ".//*[@class='gU Up']")
    WebElement sendButton;

    public void sendMail( String address, String subject, String text) {

        try {

            createMailButton.click();

            //super.driver.switchTo().frame(addressField);

            //super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.id(":hm")),10);

            addressField.sendKeys(address);

            subjectField.sendKeys(subject);

            textField.sendKeys(text);

            sendButton.click();

            super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.id("link_vsm")),10);

        } catch (NoSuchElementException exception) {

            System.out.println("The element was not located.");
        }


    }
}
