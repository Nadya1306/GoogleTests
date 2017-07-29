package GmailApplication.GmailPageObjcts;


import Shared.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends BasePageObject {

    public LogOutPage (WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@class='gb_8a gbii']")
    WebElement accountButton;

    @FindBy(id = "gb_71")
    WebElement signOutButton;

    public void logout() {

        accountButton.click();

        signOutButton.click();
    }
}
