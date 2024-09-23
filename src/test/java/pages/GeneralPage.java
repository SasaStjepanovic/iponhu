package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Components.FooterComponent;

import java.util.List;
import java.util.Random;

public class GeneralPage extends BasePage {



    FooterComponent footerComponent;

    public GeneralPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@type='submit']/..//a[contains(@href,'/registration')]")
    WebElement registrationButton;

    @FindBy(xpath = "//header//div[2]//div/a[last()]/span")
    WebElement logInVerification;

    @FindBy(xpath = "//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li[1]//i")
    WebElement ordersSelector;

    @FindBy(xpath = "//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li[2]//i")
    WebElement favouritesSelector;

    @FindBy(xpath = "//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li[3]//i")
    WebElement monitoredItemsSelector;

    @FindBy(xpath = "//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li[4]//i")
    WebElement partnerProgramItemsSelector;

    @FindBy(xpath = "//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li[5]//i")
    WebElement personalInformationItemsSelector;

    @FindBy(xpath = "//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li[6]//i")
    WebElement settingsItemselector;

    @FindBy(xpath = "//h2[contains(text(),'Orders')]")
    WebElement verifyOrdersSelector;

    @FindBy(xpath = "//h2[contains(text(),'Favourites')]")
    WebElement verifyFavouritesSelector;

    @FindBy(xpath = "//h2[contains(text(),'Monitored items')]")
    WebElement verifyMonitoredItemsSelector;

    @FindBy(xpath = "//h2[contains(text(),'Partner Program')]")
    WebElement verifyPartnerProgramItemsSelector;

    @FindBy(xpath = "//h2[contains(text(),'Personal information')]")
    WebElement verifyPersonalInformationItemsSelector;

    @FindBy(xpath = "//h2[contains(text(),'Settings')]")
    WebElement verifySettingsItemsSelector;

    @FindBy(xpath = "//button//span[contains(text(),'Shop menu')]")
    WebElement shopMenuButton;

    @FindBy(xpath = "//div[@class='flex-1 p-5 sm:pt-6 sm:pb-10']/div[last()]//div[@class='grid gap-5 md:grid-cols-3 lg:grid-cols-4 2xl:grid-cols-6']/div[1]")
    WebElement firstItemFromFilteredList;

    public void verifyAllItemsMyProfile() throws InterruptedException {

        List<WebElement> menu = driver.findElements(By.xpath("//header//div[@class='relative']//div[@x-show='isProfileOpen']//ul//li"));
        String[] menuItems = {"Orders", "Favourites", "Monitored items", "Partner Program", "Personal information", "Settings"};

        for (int i = 0; i < menu.size(); i++) {
            String item = menu.get(i).getText();
            Assert.assertEquals(item, menuItems[i], "Menu item not displayed");
            System.out.println("Menu item: " + item + " is displayed");
            Assert.assertTrue(menu.get(i).isDisplayed(), menuItems[i]);
        }
    }

    public void clickOrders() throws InterruptedException {
        hoverOverMenu();
        clickElementJS(ordersSelector, "Orders item is selected");
    }

    public void clickFavourites() throws InterruptedException {
        hoverOverMenu();
        clickElementJS(favouritesSelector, "Favourites item is selected");
    }

    public void clickMonitoredItems() throws InterruptedException {
        hoverOverMenu();
        clickElementJS(monitoredItemsSelector, "Monitored items item is selected");
    }

    //todo This is an issue
    public void clickPartnerProgramItems() throws InterruptedException {
        hoverOverMenu();
        clickElementJS(partnerProgramItemsSelector, "Partner program items item is selected");
    }

    public void clickPersonalInformationItems() throws InterruptedException {
        hoverOverMenu();
        clickElementJS(personalInformationItemsSelector, "Personal information items item is selected");
    }

    public void clickSettingsItems() throws InterruptedException {
        hoverOverMenu();
        clickElementJS(settingsItemselector, "Setting item is selected");
    }

    public void hoverOverMenu() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(ordersSelector);
    }

    public void verifyOrders(String orders){
        compareText(verifyOrdersSelector,orders);
    }

    public String getNameFavouritesItem(){
        return getElementText(verifyFavouritesSelector);
    }

    public String getNameMonitoredItem(){
        return getElementText(verifyMonitoredItemsSelector);
    }

    public String getNamePartnerProgram(){
        return getElementText(verifyPartnerProgramItemsSelector);
    }

    public String getNamePersonalInformation(){
        return getElementText(verifyPersonalInformationItemsSelector);
    }

    public String getNameSettings(){
        return getElementText(verifySettingsItemsSelector);
    }

    public void selectCategory1_6 (String category) throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//div[@class='grid gap-3 grid-cols-1 lg:gap-5 lg:grid-cols-2 xl:grid-cols-3 my-5']//*[contains(text(),'"+ category +"')]"));
        clickElement(element, "Category 1 from 6 is choosen");
    }

    public void selectCategory7_20 (String category) throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//div[@class='grid gap-3 grid-cols-1 md:gap-5 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4']//*[contains(text(),'"+ category +"')]"));
        clickElement(element, "Category 7 from 20 is choosen");
    }
}

