package SearchApplication.SearchPageObjects;

import Shared.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailApplicationLogin extends BasePageObject {

    public GmailApplicationLogin(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".gb_5b")
    WebElement listApp;

    @FindBy(xpath = ".//*[@id='gb23']/span[1]")
    WebElement gmailLink;

    public void goToGmail() {

        super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gb_5b")), 10);

        listApp.click();

        super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='gb23']/span[1]")), 10);

        gmailLink.click();
    }
}


