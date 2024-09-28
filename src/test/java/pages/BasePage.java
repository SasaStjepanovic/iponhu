package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    int waitTime = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWait(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scrollTopOfWindow(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void clickSpecificCoordinate(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(100, 200).click();");
    }

    public void scroll(String x,String y){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void clickElement(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            System.out.println("Clicked element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            scrollToElement(element);
            element.click();
            System.out.println("Clicked element: " + log);
        }
    }

    public void clickElementJS(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).build().perform();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            System.out.println("Clicked element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            scrollToElement(element);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            System.out.println("Clicked element: " + log);
        }
    }

    public void checkCheckbox(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            if (!element.isSelected()) {
                System.out.println("Check box was not selected");
                element.click();
                System.out.println("Check box is selected");
            } else {
                element.isSelected();
                System.out.println("Check box is already selected");
            }
            System.out.println("Checked element" + log);
        } catch (Exception e) {
            e.printStackTrace();
            if (!element.isSelected()) {
                element.click();
            } else {
                element.isSelected();
                System.out.println("Check box is already selected");
            }
            System.out.println("Checked element" + log);
        }
    }

    public void checkUrlDefaultPage() {
        String expextedUrl = "https://ipon.hu/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current url address: " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expextedUrl), actualUrl);
    }

    public void checkUrlPage(String expectedUrl) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current url address: " + actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl), actualUrl);
    }

    public void typeText(WebElement element, String text, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            element.click();
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        }
    }

    public void typeTextJS(WebElement element, String text, String log) {
        explicitWait(element);

        try {
            new Actions(driver).moveToElement(element).perform();
            clickElementJS(element, " element is clicked");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            clickElementJS(element, " element is clickd");
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " :to element: " + log);
        }
    }

    public void compareText(WebElement element, String expectedText) {
        explicitWait(element);
        String actualText = element.getText();
        System.out.println("Actual text is: " + actualText);
        Assert.assertEquals(actualText, expectedText);
    }

    public String getElementText(WebElement element){

        return element.getText();
    }

    public String getElementCssValue(WebElement element, String attributeType){

        return element.getCssValue(attributeType);
    }
}
