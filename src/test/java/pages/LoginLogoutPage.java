package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLogoutPage extends BasePage {
    public LoginLogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header//div[2]/a[last()]/span")
    WebElement logInButtonHeader;

    @FindBy(css = "#_username")
    WebElement username;

    @FindBy(css = "#_password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement logInButton;

    public void pressLoginButton() {
        clickElement(logInButtonHeader, "Login button is pressed");
    }

    public void enterUserName(String user) {
        typeText(username, user, "Username is entered");
    }

    public void enterPassword(String passw) {
        typeText(password, passw, "Password is entered");
    }

    public void logInButton() {
        clickElement(logInButton, "Login button is pressed");
    }

    public void login(String user, String passw) {
        enterUserName(user);
        enterPassword(passw);
        logInButton();
    }
}
