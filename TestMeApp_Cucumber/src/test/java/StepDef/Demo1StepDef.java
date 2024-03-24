package StepDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import TestMePomPages.LoginPage;
import Utility.BrowsersUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1StepDef {
WebDriver driver;
LoginPage lp;
@Given("user is on login page")
public void user_is_on_login_page() {
	  driver = BrowsersUtil.launchBrowser("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("https://lkmdemoaut.accenture.com/TestMeApp/login.htm");
}

@When("user enter {string} and {string}")
public void user_enter_and(String string, String string2) {
	lp = new LoginPage(driver);
	lp.enterUsername(string);
	lp.enterPassword(string2);
}

@When("user click on login button")
public void user_click_on_lofin_button() {
   lp.clickLogin();
}

@Then("user should be login successfully")
public void user_should_be_login_successfully() {
	Assert.assertEquals(driver.getTitle(), "Home");
	driver.close();
}

}
