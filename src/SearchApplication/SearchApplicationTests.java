package SearchApplication;


import SearchApplication.SearchPageObjects.SearchPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchApplicationTests {

    private WebDriver driver ;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.google.com/ncr");
    }

    @Test
    public void searchTest(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.enterSearchData("Selenium");

        WebElement element = driver.findElement(By.cssSelector(".rc .s"));

        Assert.assertTrue("Search result must contain the text.",element.getText().contains("Selenium is a suite of tools"));

    }

    @After
    public void quitOut() {

       // driver.quit();
    }

}
