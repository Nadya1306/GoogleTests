import java.util.concurrent.TimeUnit;

import Shared.LoginGoogleApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginGoogleApplicationTests {

        private WebDriver driver;


        @Before
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("http://www.google.com/ncr");
        }

        @Test
        public void logInLogOutTest () {
            LoginGoogleApplication searchApplication = new LoginGoogleApplication(driver);
            searchApplication.logIn("TestNM1306@gmail.com", "hf,jnfdnasa");
            searchApplication.logOut();
        }

        @After
        public void quitOut() {
            driver.quit();
        }
}
