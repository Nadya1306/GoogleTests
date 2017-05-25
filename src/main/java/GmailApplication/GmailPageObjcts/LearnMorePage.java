package GmailApplication.GmailPageObjcts;

import Shared.BasePageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class LearnMorePage extends BasePageObject {

    public LearnMorePage( WebDriver driver){

        super(driver);

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "remove")
    WebElement removeAccountDropdownList;

    @FindBy(xpath = ".//img[@alt='Remove']")
    WebElement removeImage;

    @FindBy(css = ".facebook-icon")
    WebElement facebookIcon;

    @FindBy(id = "u_0_2")
    WebElement facebookLogInButton;

    public void openRemoveAccountDropdownList(){

        super.waitForElement(ExpectedConditions.visibilityOf(removeAccountDropdownList),10);

        removeAccountDropdownList.click();

    }

    public void assertRemoveAccountDropdownListStatment(){
        Assert.assertTrue("Assert message - wrong statment",removeAccountDropdownList.getAttribute("aria-expanded").matches("true"));
    }

    public void assertRemoveImageIsDisplayd(){
        Assert.assertTrue("Remove Image is not displayd",removeImage.isDisplayed());
    }

    public void openFacebookLoginPage(){
        super.waitForElement(ExpectedConditions.visibilityOf(facebookIcon), 10);

       // String parentHandle = this.driver.getWindowHandle();

        facebookIcon.click();

//        for (String childHandle : driver.getWindowHandles()) {
//            if (!childHandle.equals(parentHandle)) {
//                driver.switchTo().window(childHandle);
//            }
//        }

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("got interrupted!");
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.switchTo().window(driver.getWindowHandles().iterator().next());

        Assert.assertTrue("facebookLogInButton is not disabled", facebookLogInButton.isDisplayed());

        facebookLogInButton.click();
    }
}
