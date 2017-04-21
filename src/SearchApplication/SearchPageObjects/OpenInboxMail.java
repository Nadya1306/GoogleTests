package SearchApplication.SearchPageObjects;

import Shared.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenInboxMail extends BasePageObject {

    public OpenInboxMail(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".nZ.TO .n0")
    WebElement inboxLink;

    @FindBy(xpath="//td[@id=':3d']/div/div/div/span[2]")
    WebElement mailLink;

    public void openMail(){

        try{
            inboxLink.click();

          super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id=':3d']/div/div/div/span[2]")),  10);

            mailLink.click();

        }catch (NoSuchElementException exception){
            System.out.println("The element was not located.");
        }
    }

}
