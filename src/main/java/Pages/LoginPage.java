package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    WebDriver driver;
    public LoginPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "gbtn")
    public WebElement signInButton;

    @FindBy(id = "identifierId")
    WebElement mailLocator;

    @FindBy(xpath = "//*[text()='Next']")
    WebElement nextButtonLocator;

    @FindBy(name = "Passwd")
    WebElement passwordLocator;


    public void clickSignInButton(){
        signInButton.click();
    }

    public void enterMail(String mail){
        mailLocator.sendKeys(mail);
    }

    public HomePage clickNextButton(){
        nextButtonLocator.click();
        return new HomePage(driver);
    }

    public void enterPassword(String pass) throws InterruptedException {
        Thread.sleep(2000);
        passwordLocator.sendKeys(pass);

    }

//    public By siginButtonLocator = By.id("gbtn");

//    public By mailLocator =By.id("identifierId");

//    public By nextButtonLocator = By.xpath("//*[text()='Next']");

//    public By passwordLocator = By.name("Passwd");



}
