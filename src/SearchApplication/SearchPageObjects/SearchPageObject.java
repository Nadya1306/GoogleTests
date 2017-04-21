package SearchApplication.SearchPageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObject {
    public WebDriver driver;

    public SearchPageObject(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }


        @FindBy(id = "lst-ib")
        WebElement searchField;

        @FindBy(id = "_fZl")
        WebElement searchButton;



    public void enterSearchData(String text) {

        try {

            searchField.click();

            searchField.sendKeys(text);

            searchButton.click();

        } catch (NoSuchElementException exception) {
            System.out.println("The element was not located.");
        }
    }

}
