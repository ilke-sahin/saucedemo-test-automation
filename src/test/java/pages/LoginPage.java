package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(id = "user-name")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;


    public void login(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        ReusableMethods.waitForElementClickable(btnLogin, 5);
        btnLogin.click();
    }
}