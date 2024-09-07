package tests;

import org.openqa.selenium.WebDriver;
import selenium.DriverManager;
import selenium.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    DriverManager driverManager;

    public void init(String browser, String wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(wait), TimeUnit.SECONDS);
    }

    public void ipon(String env) throws Exception {
        switch (env.toUpperCase()){
            case "QA": {
                driver.get("https://www.booking.com/");
            }
            break;
            case "PROD": {
                driver.get("https://ipon.hu/");
            }
            break;
            case "BIZ": {
                driver.get("https://www.yahoo.com/");
            }
            break;
            default:
                throw new Exception("No such environment: " + env);
        }
    }

    public void quit(){
        driverManager.quitWebDriver();
    }
}
