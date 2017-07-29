import GmailApplication.GmailPageObjcts.CraeteMail;
import GmailApplication.GmailPageObjcts.LogOutPage;
import GmailApplication.GmailPageObjcts.LoginPage;
import GmailApplication.GmailPageObjcts.GmailApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CreateMailTests {

    private WebDriver driver;
    private GmailApplication app;
    private LoginPage loginPage;
    private LogOutPage logOutPage;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        app = new GmailApplication(driver);
        app.open();
        loginPage = app.openLoginPage();
        loginPage.enterUserName("TestNM1306@gmail.com");
        loginPage.enterUserPassword("hf,jnfdnasa");
    }

    @Test
    public void createMail() {

        CraeteMail craeteMail = new CraeteMail(driver);

        craeteMail.sendMail("TestNM1306@gmail.com", "Test mail", "УРААА!");
    }

    @After
    public void quitOut() {

        logOutPage = app.openLogoutPage();

        logOutPage.logout();

        driver.quit();
    }
}
