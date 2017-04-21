package GmailApplication;

import GmailApplication.GmailPageObjcts.LogOutPage;
import GmailApplication.GmailPageObjcts.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginGmailTests  {

    private WebDriver driver;
    private GmailApplication app;
    private LoginPage loginPage;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        app = new GmailApplication(driver);
        app.open();

        loginPage = app.openLoginPage();
    }

    @After
    public void quitOut() {
        app.close();
    }

    @Test
    public void LogInLogOutGmail(){

        loginPage.enterUserName("testnm1306@gmail.com");

        loginPage.enterUserPassword("hf,jnfdnasa");

        LogOutPage logOutPage = app.openLogoutPage();

        logOutPage.logout();
    }

    @Test
    public void EmptyLogin(){

        loginPage.enterUserName(" ");

        loginPage.assertErrorMessageForEmptyUserNameFieldShown();
    }

    @Test
    public void EmptyPassword(){

        loginPage.enterUserName("TestNM1306@gmail.com");

        loginPage.enterUserPassword(" ");

        loginPage.assertErrorMessageForPasswordFieldShown();
    }

    @Test
    public void WrongLogin(){

        loginPage.enterUserName("hghbhhbhb@njnj.com");

        loginPage.assertErrorMessageForNotRecognizedUserNameFieldShown();
    }

    @Test
    public void LinkLearnMore() {

        String parentHandle = driver.getWindowHandle();

        loginPage.clickLinkLearnMore();

        for(String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
    }


}


