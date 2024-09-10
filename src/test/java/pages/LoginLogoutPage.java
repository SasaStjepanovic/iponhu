package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Components.FooterComponent;

public class LoginLogoutPage extends BasePage {

    FooterComponent footerComponent;

    public LoginLogoutPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
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

    @FindBy(xpath = "//div[@class='mt-1 text-red-700 text-xs']")
    WebElement invalidMessage;

    public void pressLoginButton() {
        clickElement(logInButtonHeader, "Login button is pressed");
    }

    public void enterUserNameOrEmail(String user) {
        typeText(username, user, "Username is entered");
    }

    public void enterPassword(String passw) {
        typeText(password, passw, "Password is entered");
    }

    public void logInButton() {
        clickElement(logInButton, "Login button is pressed");
    }

    public void logInFooterButton() {
        footerComponent.pressLoginFooter();
    }

    public void login(String user, String email, String password, String yesOrNoEmail) {
        if (yesOrNoEmail.equalsIgnoreCase("No")) {
            enterUserNameOrEmail(user);
            enterPassword(password);
            logInButton();
        } else {
            enterUserNameOrEmail(email);
            enterPassword(password);
            logInButton();
        }
    }

    public void checkMessage (String expectedMessage){
        compareText(invalidMessage, expectedMessage);
    }
}
