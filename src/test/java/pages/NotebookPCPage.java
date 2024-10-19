package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Components.FooterComponent;

import java.util.List;

public class NotebookPCPage extends BasePage {

    FooterComponent footerComponent;

    public NotebookPCPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[contains(text(),'Price')]/../..//div//input[1]")
    WebElement minPriceInput;

    @FindBy(xpath = "//span[contains(text(),'Price')]/../..//div//input[2]")
    WebElement maxPriceInput;

    @FindBy(xpath = "//span[contains(text(),'Warranty')]/../..//div//input[1]")
    WebElement minWarrantyInput;

    @FindBy(xpath = "//span[contains(text(),'Warranty')]/../..//div//input[2]")
    WebElement maxWarrantyInput;

    @FindBy(xpath = "//main//*[@href='/shop/group/notebook-pc-ebook/1']//div[@class='text-slate-900 font-semibold text-sm dark:text-slate-400']")
    WebElement verifyCategoryNameNotebook;

    @FindBy(xpath = "//div[@class='flex-1 p-5 sm:pt-6 sm:pb-10']//h1")
    WebElement verifyNotebookProduct;//span[contains(text(),'Manufacturer')]//../..//*[contains(text(),"Show all")]

    @FindBy(xpath = "//span[contains(text(),'Manufacturer')]//../..//*[contains(text(),'Show all')]")
    WebElement showAllManufacturer;

    @FindBy(xpath = "//h3[contains(text(),'Sadly, there is no result we can show you!')]")
    WebElement noResult;

    @FindBy(xpath = "//div[@class='flex-1 p-5 sm:pt-6 sm:pb-10']/div[last()]//div[@class='grid gap-5 md:grid-cols-3 lg:grid-cols-4 2xl:grid-cols-6']/div[1]")
    WebElement firstItemFromFilteredList;


    public void selectNoteBookProduct(String notebook) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//div[@class='grid gap-3 grid-cols-2 lg:gap-5 lg:grid-cols-4 xl:grid-cols-6 my-5']//*[contains(text(),'" + notebook + "')]"));
        clickElement(element, "Notebook product is chosen");

    }

    public String getNameCategoryNotebook() {
        return getElementText(verifyCategoryNameNotebook);
    }

    public String    getNameNotebookProduct() {
        return getElementText(verifyNotebookProduct);
    }

    public String getUnsuccessfulFilterAction(){
        return getElementText(noResult);
    }

    public void setMinPrice(String minPrice) {
        typeText(minPriceInput, minPrice, "Min price is entered: " + minPrice + " ");
    }

    public void setMaxPrice(String maxPrice) {
        typeText(maxPriceInput, maxPrice, "Max price is entered: " + maxPrice + " ");
    }

    public void setMinWarranty(String minWarranty) {
        typeText(minWarrantyInput, minWarranty, "Min warranty is entered");
    }

    public void setMaxWarranty(String maxWarranty) {
        typeText(maxWarrantyInput, maxWarranty, "Max warranty is entered");
    }

    public void filter1(String manufacturer, String minPrice, String maxPrice, String pickup, String minWarranty, String maxWarranty) throws InterruptedException {
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);


        boolean b = showAllManufacturer.isDisplayed();
        if (b) {
            System.out.println("Filter is not expanded and Show all is displayed");
            clickElement(showAllManufacturer, "Show all button is pressed");
            System.out.println("Filter is expanded now and all is displayed");
        } else {
            System.out.println("do nothing");
        }

        scrollTopOfWindow();
        WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Manufacturer')]//../..//label[contains(text(),'" + manufacturer + "')]"));
        checkCheckbox(element1, "Manufacturer element is checked");

        WebElement element2 = driver.findElement(By.xpath("//span[contains(text(),'Pickup')]//../..//label[contains(text(),'" + pickup + "')]"));
        checkCheckbox(element2, "Pickup element is checked");

        setMinWarranty(minWarranty);
        setMaxWarranty(maxWarranty);
    }

    public void clickFistItem(){
        clickElement(firstItemFromFilteredList, "First item is selected");
    }


}


