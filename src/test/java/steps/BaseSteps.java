package steps;

import com.fasterxml.jackson.databind.ser.Serializers;
import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.BasePage;
import pages.Components.FooterComponent;
import pages.LoginLogoutPage;
import pages.RegistrationPage;
import tests.BaseTest;

import java.util.Map;
import java.util.ResourceBundle;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    RegistrationPage rp = new RegistrationPage(driver);
    String randomLastName;
    String randomFirstName;
    String randomEmail;
    String randomPassword;
    String randomUserName;

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        ipon((env));
        randomLastName = rp.randomLastName();
        randomFirstName = rp.randomFirstName();
        randomEmail = rp.randomEmail();
        randomPassword = rp.randomPassword();
        randomUserName = rp.randomUserName();

    }

    @After
    public void tearDown() {
        quit();
    }

    @Given("a user reads test data from {string} {string} by id {string}")
    public void aUserReadsTestDataFromById(String fileName, String sheetName, String id) throws Exception {
        data = new ExcelSupport().getDataByID(fileName, sheetName, id);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        new LoginLogoutPage(driver).pressLoginButton();
    }

    @Given("the user is on the ipon page")
    public void theUserIsOnTheIponPage() {
        new BasePage(driver).checkUrlDefaultPage();
    }

    @And("user enters username and password for login action")
    public void userEntersUsernameAndPasswordForLoginAction() {
        new LoginLogoutPage(driver).loginButton(data.get("username"), data.get("email"), data.get("password"), data.get("emailYesNo"));
    }

    @Then("user should verify login action")
    public void userShouldVerifyLoginAction() {
        new LoginLogoutPage(driver).verifyLoginAction(data.get("logIn"));
    }

    @And("user chooses language")
    public void userChoosesLanguage() {
        new FooterComponent(driver).selectLanguage(data.get("languageNumber"));
    }

    @And("user enters email and password for login action")
    public void userEntersEmailAndPasswordForLoginAction() {
        new LoginLogoutPage(driver).loginButton(data.get("username"), data.get("email"), data.get("password"), data.get("emailYesNo"));
    }

    @Then("user should verify invalid login action")
    public void userShouldVerifyInvalidLoginAction() {
        new LoginLogoutPage(driver).checkMessage(data.get("invalidMessage"));
    }

    @And("user clicks login footer button")
    public void userClicksLoginFooterButton() {
        LoginLogoutPage lp = new LoginLogoutPage(driver);
        lp.logInFooterButton();
    }

    @And("check languages")
    public void checkLanguages() {
        new FooterComponent(driver).checkLanguages(data.get("invalidMessage"));
    }

    @And("user expand languages bar")
    public void userExpandLanguagesBar() {
        new FooterComponent(driver).expandLanguagesBar();
    }

    @Then("user should verify existing of all languages")
    public void userShouldVerifyExistingOfAllLanguages() throws InterruptedException {
        new FooterComponent(driver).verifyAllLanguages();
    }

    @And("user clicks logout button")
    public void userClicksLogoutButton() {
        new LoginLogoutPage(driver).logoutButton();
    }

    @Then("user should verify logout action")
    public void userShouldVerifyLogoutAction() {
        new LoginLogoutPage(driver).verifyLogOutAction(data.get("logOut"));
    }

    @And("user checks remember me option")
    public void userChecksRememberMeOption() {
        new LoginLogoutPage(driver).selectRememberMe();
    }

    @And("user enters username and password and check remember option for login action")
    public void userEntersUsernameAndPasswordAndCheckRememberOptionForLoginAction() {
        new LoginLogoutPage(driver).loginButtonRememberMe(data.get("username"), data.get("email"), data.get("password"), data.get("emailYesNo"));
    }

    @And("user clicks forgotten password button")
    public void userClicksForgottenPasswordButton() {
        new LoginLogoutPage(driver).pressForgottenPassword();
    }

    @Then("user should verify new page for lost password")
    public void userShouldVerifyNewPageForLostPassword() {
        new BasePage(driver).checkUrlPage(data.get("url2"));
    }

    @And("user clicks registration button")
    public void userClicksRegistrationButton() {
        new RegistrationPage(driver).pressRegistrationButton();
    }

    @And("user should verify registration page")
    public void userShouldVerifyRegistrationPage() {
        new BasePage(driver).checkUrlPage(data.get("url2"));
    }

    @And("user should fill all fields")
    public void userShouldFillAllFields() {
        new RegistrationPage(driver).registrationRandom(randomLastName, randomFirstName, randomEmail, randomPassword, randomUserName,
                data.get("randomTypeYesNo"),
                data.get("lastName"),
                data.get("firstName"),
                data.get("emailRegistration"),
                data.get("passwordRegistration"),
                data.get("userNameRegistration"));
    }

    @Then("user should verify that is registered")
    public void userShouldVerifyThatIsRegistered() {
        new BasePage(driver).checkUrlPage(data.get("url2"));
    }

    @Then("user should verify that the surename field is blank")
    public void userShouldVerifyThatTheSurenameFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageLastName(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the firstname field is blank")
    public void userShouldVerifyThatTheFirstnameFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageFirstName(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the email field is blank")
    public void userShouldVerifyThatTheEmailFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageEmail(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the password field is blank")
    public void userShouldVerifyThatThePasswordFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessagePassword(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the username field is blank")
    public void userShouldVerifyThatTheUsernameFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageUserName(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the email field is filled as invalid")
    public void userShouldVerifyThatTheEmailFieldIsFilledAsInvalid() {
        new RegistrationPage(driver).verifyErrorMessageEmail(data.get("errorMesssageEmailNotValid"));
    }

    @And("user closes popup window")
    public void userClosesPopupWindow() {
        new RegistrationPage(driver).closePopupWindow();
    }
}
