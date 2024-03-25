package TestMePomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement login;
    
    @FindBy(xpath = "//div[contains(text(),'Username or Password is wrong here')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username) {
        userNameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        login.click();
    }
    
    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
