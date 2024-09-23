package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Components.FooterComponent;

import java.security.PublicKey;

public class LoginLogoutPage extends BasePage {

    FooterComponent footerComponent;

    public LoginLogoutPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header//div[2]/a[last()]/span")
    WebElement logInButtonHeader;

    @FindBy(xpath = "//header//div[2]//div/a[last()]/span")
    WebElement logInVerification;

    @FindBy(css = "#_username")
    WebElement username;

    @FindBy(css = "#_password")
    WebElement password;

    @FindBy(xpath = "//input[@id='_password']/..//a")
    WebElement forgottenPassord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement logInButton;

    @FindBy(xpath = "//header//div[@class='relative']//a[contains(@href,'/kilepes')]")
    WebElement logOutButton;

    @FindBy(xpath = "//div[@class='mt-1 text-red-700 text-xs']")
    WebElement invalidMessage;

    @FindBy(xpath = "//header//div[@class='relative']")
    WebElement expandProfile;

    @FindBy(css = "#_remember_me")
    WebElement rememberMe;

    public void pressForgottenPassword() {
        clickElement(forgottenPassord, "Forgotten password button is pressed");
    }

    public void pressLoginButton() throws InterruptedException {
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

    public void loginButton(String user, String email, String password, String yesOrNoEmail) {
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

    public void expandMyProfile() throws InterruptedException {
        clickElement(expandProfile, "My profile is expanded");
        Thread.sleep(3000);
    }

    public void logoutButton() throws InterruptedException {
        expandMyProfile();
        clickElementJS(logOutButton, "logOut button is pressed");
    }

    public void checkMessage(String expectedMessage) {
        compareText(invalidMessage, expectedMessage);
    }

    public void verifyLoginAction(String expectedText) {
        compareText(logInVerification, expectedText);
    }

    public void verifyLogOutAction(String expectedText) {
        compareText(logInButtonHeader, expectedText);
    }

    public void selectRememberMe() {
        checkCheckbox(rememberMe, "Remember check box is checked");
    }

    public void loginButtonRememberMe(String user, String email, String password, String yesOrNoEmail) throws InterruptedException {
        if (yesOrNoEmail.equalsIgnoreCase("No")) {
            enterUserNameOrEmail(user);
            enterPassword(password);
            selectRememberMe();
            logInButton();
        } else {
            enterUserNameOrEmail(email);
            enterPassword(password);
            selectRememberMe();
            logInButton();
        }
    }
}
