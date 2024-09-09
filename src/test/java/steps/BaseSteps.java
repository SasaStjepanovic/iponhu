package steps;

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
import tests.BaseTest;

import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        ipon((env));
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
        new LoginLogoutPage(driver).login(data.get("username"), data.get("email"),data.get("password"), data.get("emailYesNo"));
    }

    @Then("user should verify login action")
    public void userShouldVerifyLoginAction() {
        new BasePage(driver).checkUrlPage(data.get("url"));
    }

    @And("user chooses language")
    public void userChoosesLanguage() {
        new FooterComponent(driver).selectLanguage(data.get("languageNumber"));
    }

    @And("user enters email and password for login action")
    public void userEntersEmailAndPasswordForLoginAction() {
        new LoginLogoutPage(driver).login(data.get("username"), data.get("email"),data.get("password"), data.get("emailYesNo"));
    }

    @Then("user should verify invalid login action")
    public void userShouldVerifyInvalidLoginAction() {
        new LoginLogoutPage(driver).checkMessage(data.get("invalidMessage"));
    }
}
