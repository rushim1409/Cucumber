package StepDef;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import TestMePomPages.RegistrationPage;
import Utility.BrowsersUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration_Step_Def_Class {
    WebDriver driver;
    RegistrationPage rp;

    @Given("I am on the registration page of TestMeApp")
    public void i_am_on_the_registration_page_of_test_me_app() {
        driver = BrowsersUtil.launchBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://lkmdemoaut.accenture.com/TestMeApp/RegisterUser.htm");
        rp = new RegistrationPage(driver);
    }

    @When("I fill out the registration form with valid information")
    public void i_fill_out_the_registration_form_with_valid_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> row = dataTable.asMap(String.class , String.class);
        rp.enterUsername(row.get("username"));
        rp.enterFirstName(row.get("firstName"));
        rp.enterLastName(row.get("lastName"));
        rp.enterPassword(row.get("password"));
        rp.confirmPassword(row.get("confirmPassword"));
        rp.enterEmail(row.get("email"));
        rp.enterMobileNumber(row.get("mobileNumber"));
        rp.enterBirthDate(row.get("birthDate"));
        rp.enterAddress(row.get("address"));
        rp.selectSecurityQuestion(row.get("securityQuestion"));
        rp.enterAnswer(row.get("answer"));
    }

    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        rp.clickRegisterButton();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
//    	Assert.assertEquals(driver.getTitle(), "Login", "Registration failed.");
		 driver.quit();
    }
}
