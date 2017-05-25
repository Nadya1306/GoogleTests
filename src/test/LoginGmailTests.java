package GmailApplication;

import GmailApplication.GmailPageObjcts.LearnMorePage;
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

       // app.close();
    }

    @Test
    public void verifyAutorisationGmail(){

        loginPage.enterUserName("testnm1306@gmail.com");

        loginPage.enterUserPassword("hf,jnfdnasa");

        LogOutPage logOutPage = app.openLogoutPage();

        logOutPage.logout();

    }

    @Test
    public void verifyErrorMessageForEmptyUserNameField(){

        loginPage.enterUserName(" ");

        loginPage.assertErrorMessageForEmptyUserNameFieldShown();
    }

    @Test
    public void verifyErrorMessageForEmptyPasswordField(){

        loginPage.enterUserName("TestNM1306@gmail.com");

        loginPage.enterUserPassword(" ");

        loginPage.assertErrorMessageForPasswordFieldShown();
    }

    @Test
    public void verifyErrorMessageForNotRecognizedUserNameField(){

        loginPage.enterUserName("hghbhhbhb@njnj.com");

        loginPage.assertErrorMessageForNotRecognizedUserNameFieldShown();
    }

    @Test
    public void openlinklearnmore() {

        loginPage.clickLinkLearnMore();

    }

    @Test
    public void openRemoveAccountDropdownList(){

        LearnMorePage learnMorePage = loginPage.clickLinkLearnMore();

        learnMorePage.openRemoveAccountDropdownList();

        learnMorePage.assertRemoveAccountDropdownListStatment();

        learnMorePage.assertRemoveImageIsDisplayd();

    }

    @Test
    public void openFacebookPage(){

        LearnMorePage learnMorePage = loginPage.clickLinkLearnMore();

        learnMorePage.openFacebookLoginPage();

    }

    @Test
    public void changeLanguage(){

        loginPage.clickLanguageList();
        // a change

    }

    @Test
    public void clickSecureOkButton(){

        loginPage.clickOkSecureButton();
    }
}


