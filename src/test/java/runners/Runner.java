package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        tags = "@ipon",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "rerun:target/failed_scenarios.txt"}
)

public class Runner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
