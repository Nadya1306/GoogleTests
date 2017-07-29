import SearchApplication.SearchPageObjects.SearchPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchApplicationTests {

    private WebDriver driver ;



    @Before
    public void setUp() {

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.google.com/ncr");
    }

    @Test
    public void searchTest(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.enterSearchData("Selenium");

        WebElement element = driver.findElement(By.xpath(".//*[@class='st']"));

        Assert.assertTrue("Search result must contain the text.",element.getText().contains("Selenium is a suite of tools"));
    }

    @Test
    public void searchWithVoice(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.clickVoiceButton();

        WebElement voiceImage = driver.findElement(By.id("spchb"));

        Assert.assertNotNull(voiceImage);
    }

    @Test
    public  void clickFeelingButton(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.clickFeelingButton();

        //WebElement element = driver.findElement(By.id ("latest-title"));

        //Assert.assertTrue("Search result must contain the text.",element.getText().contains("Children's Day 2017 (Panama, Venezuela)"));
    }

    @After
    public void quitOut() {

       // driver.quit();
    }
}
