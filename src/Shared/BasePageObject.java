package Shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sergey on 10-Apr-17.
 */
public class BasePageObject {

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {

        if (driver == null) {
            throw new NullPointerException("driver parameter should be provided.");
        }

        this.driver = driver;
    }

    protected <T> void waitForElement(ExpectedCondition<T> isTrue, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(isTrue);
    }

   /* protected <V> void wait(Function<? super WebDriver, V> isTrue, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(isTrue);
        //ExpectedCondition<WebElement>*/
}

