package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriver_Utility extends WaitUtility{

    WebDriver driver;
    public WebDriver_Utility(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public boolean DisplayText(By by){
        WebElement element = waitForElementPresent(by);
        return element.isDisplayed();
    }

    public String getTextValue(By by){
        WebElement element = waitForElementPresent(by);
        return element.getText();
    }

}
