package Shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

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

        PageFactory.initElements(driver, this);
    }

    protected void waitForElement(ExpectedCondition<WebElement> isTrue, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(isTrue);
    }

   /* protected <V> void wait(Function<? super WebDriver, V> isTrue, long timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(isTrue);
        //ExpectedCondition<WebElement>*/



}

