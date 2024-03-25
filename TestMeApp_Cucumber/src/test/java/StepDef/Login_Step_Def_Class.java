package StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import TestMePomPages.LoginPage;
import Utility.BrowsersUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login_Step_Def_Class {
    WebDriver driver;
    LoginPage lp;

    public Login_Step_Def_Class() {
        driver = BrowsersUtil.launchBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp = new LoginPage(driver);
    }

    @Given("I navigate to the TestMeApp login page")
    public void i_navigate_to_the_test_me_app_login_page() {
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) {
        lp.enterUsername(username);
        lp.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        lp.clickLogin();
    }

    @Then("I should be logged in successfully and go to homepage")
    public void i_should_be_logged_in_successfully_and_go_to_homepage() {
        Assert.assertEquals("Home", driver.getTitle());
        driver.quit();
    }

    @When("I enter invalid username {string} and password {string}")
    public void i_enter_invalid_username_and_password(String username, String password) {
        lp.enterUsername(username);
        lp.enterPassword(password);
    }

    @Then("I should see an error message indicating unsuccessful login")
    public void i_should_see_an_error_message_indicating_unsuccessful_login() {
        Assert.assertEquals("Username or Password is wrong here!!!", lp.getErrorMessageText());
        driver.quit();
    }
}
