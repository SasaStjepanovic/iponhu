package pages.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class FooterComponent extends BasePage {


    public FooterComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fab fa-youtube']")
    WebElement youtube;

    @FindBy(xpath = "//i[@class='fab fa-facebook-square']")
    WebElement facebook;

    @FindBy(xpath = "//i[@class='fab fa-instagram']")
    WebElement instagram;

    @FindBy(xpath = "//i[@class='fab fa-discord']")
    WebElement discord;

    @FindBy(xpath = "//div[@class='relative']//ul/../..")
    WebElement languagesField;

    public void selectLanguage(String rowLanguage){

        int rowNumber = Integer.parseInt(rowLanguage);
        clickElement(languagesField, "Languages drop down menu is expanded");
//        WebElement languageNumber = driver.findElement(By.xpath("//div[@class='relative']//ul//li["+ (rowNumber) +"]"));
        WebElement languageNumber = driver.findElement(By.cssSelector("div[x-show='isOpen']>ul>li:nth-child(3)"));
        System.out.println("Row number: " + rowLanguage);
        clickElement(languageNumber, "Language is selected");

        WebElement language = driver.findElement(By.xpath("//div[@class='relative']//ul//li["+ (rowNumber) +"]//span"));
//        WebElement language = driver.findElement(By.cssSelector("div[x-show='isOpen']>ul>li:nth-child(3)>a>span"));
        String selectedLanguage = language.getText();
        System.out.println("Selected language is: " + selectedLanguage);
    }

    public void checkItems(String[] menuItems) throws InterruptedException {

        List<WebElement> menu = driver.findElements(By.cssSelector(".bm-item-list>a"));
        Thread.sleep(1000);
        for (int i = 0; i < menu.size(); i++) {
            String item = menu.get(i).getText();
            Assert.assertEquals(item, menuItems[i], "Menu item not displayed");
            System.out.println("Menu item: " +item+ " is displayed");
            Assert.assertTrue(menu.get(i).isDisplayed(), menuItems[i]);

        }
    }
}
