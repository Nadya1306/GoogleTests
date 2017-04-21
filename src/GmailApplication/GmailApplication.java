package GmailApplication;

import GmailApplication.GmailPageObjcts.LogOutPage;
import GmailApplication.GmailPageObjcts.LoginPage;
import Shared.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class GmailApplication {

    private WebDriver driver ;

    public GmailApplication(WebDriver driver) {

        this.driver = driver;
    }

    public  LoginPage openLoginPage() {

        return new LoginPage(driver);

    }

    public LogOutPage openLogoutPage(){

        return new LogOutPage(driver);
    }

    public void open(){

        driver.get("https://mail.google.com");
    }

    public void close(){

        driver.quit();
    }




}
