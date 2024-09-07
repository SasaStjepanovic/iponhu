package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Reporter;
import tests.BaseTest;

public class BaseSteps extends BaseTest {

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        ipon((env));
    }

    @After
    public void tearDown(){
        quit();
    }
}
