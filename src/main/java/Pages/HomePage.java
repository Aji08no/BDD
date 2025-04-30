package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    WebDriver driver;
    public HomePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='OPOS']")
    public WebElement OposTextLocator;

    @FindBy(xpath = "(//*[@class='main-menu-icon ng-star-inserted'])[2]")
    WebElement PracticeListLocator;

    @FindBy(xpath = "(//*[@class='main-menu-icon ng-star-inserted'])[3]")
    WebElement ProviderListLocator;

   public By OposTextLocatorWait= By.xpath("//*[text()='OPOS']");

//    public By PracticeListLocator= By.xpath("(//*[@class='main-menu-icon ng-star-inserted'])[2]");

//    public By ProviderListLocator= By.xpath("(//*[@class='main-menu-icon ng-star-inserted'])[3]");

    public String oposText(){
        String text = driver.findElement(OposTextLocatorWait).getText();
        return text;
    }

    public void clickPracticeList(){
        PracticeListLocator.click();
    }

    public void clickProviderList(){
        ProviderListLocator.click();
    }

}
