package SearchApplication.SearchPageObjects;


import GmailApplication.GmailPageObjcts.ConstantForWait;
import Shared.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPageObject extends BasePageObject {

    public SearchPageObject(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);

    }

        @FindBy(id = "lst-ib")
        WebElement searchField;

        @FindBy(id = "_fZl")
        WebElement searchButton;

        @FindBy(id = "gsri_ok0")
        WebElement voiceButton;

        @FindBy(xpath= ".//div[@class='jsb']/center[1]/input[2]")
         WebElement feelingButton;

        @FindBy(xpath= ".//div[@class='jsb']/center[1]/div[1]/div[1]")
        WebElement feelingButton2;

        @FindBy(xpath = ".//span[@id='fsr']/a[3]")
        WebElement ieGoogleLink;



    public void enterSearchData(String text) {

        try {

            searchField.click();

            searchField.sendKeys(text);

            searchButton.click();

        } catch (NoSuchElementException exception) {

            System.out.println("The element was not located.");
        }
    }

    public void clickVoiceButton(){

        super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.id("gsri_ok0")), ConstantForWait.waitConstantOfSeconds());

        voiceButton.click();
    }

    public void clickFeelingButton(){

        //super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='jsb']/center[1]/div[1]/div[1]/div[1]")), ConstantForWait.waitConstantOfSeconds());

        feelingButton.click();

        //super.waitForElement(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@class='jsb']/center[1]/div[1]/div[1]/div[1]")), ConstantForWait.waitConstantOfSeconds());

        feelingButton2.click();

        //Actions action = new Actions(driver);

        //action.doubleClick(feelingButton);
    }

}
