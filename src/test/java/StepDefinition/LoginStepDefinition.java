package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.WaitUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginStepDefinition{
    WebDriver driver;
    LoginPage loginPage;
    HomePage homepage;

    @Given("user is on the login page")
    public void user_is_on_the_login_page()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://qa.telepain.md");
        loginPage=new LoginPage(driver);
        loginPage.clickSignInButton();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() throws InterruptedException {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        if (windowHandlesList.size() > 1) {
            driver.switchTo().window(windowHandlesList.get(1));
//            System.out.println("Switched to window with index: " + windowIndex);
        } else {
            System.out.println("Window index " +2 + " is out of bounds. Available windows: " + windowHandlesList.size());
        }

        loginPage.enterMail("akqawork25@gmail.com");
        loginPage.clickNextButton();
        Thread.sleep(2000);
        loginPage.enterPassword("ajiwork@08");

    }

//    @Then("^user enter the search bar\"(.*)\"$")
//    public void user_enter_the_search_bar(String name) {
//        driver.findElement(By.id("APjFqb")).sendKeys(name);
//    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() throws InterruptedException {
          Thread.sleep(1000);
        homepage = loginPage.clickNextButton();
    }

    @Then("user should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() throws InterruptedException {
        WaitUtility waitUtility=new WaitUtility(driver);
        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        waitUtility.waitForElementVisible(homepage.OposTextLocatorWait);

        Assert.assertEquals("OPOS",homepage.oposText());
        System.out.println("logged in successfully ");
    }
}
