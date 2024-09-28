package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Components.FooterComponent;

import java.util.List;
import java.util.Random;

public class ShoppingPage extends BasePage {



    FooterComponent footerComponent;

    public ShoppingPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@class='mt-5 btn inline-flex items-center text-sm px-4 py-2']")
    WebElement continueButton;

    @FindBy(xpath = "//i[@class='fas fa-shopping-cart text-xl md:text-2xl mr-1']")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//h3[contains(text(),'Your cart is empty!')]")
    WebElement emptyCart;

    @FindBy(xpath = "//i[@class='fas fa-plus']")
    WebElement plusButton;

    @FindBy(xpath = "//div[@class=' divide-y divide-neutral-200 px-5 py-1 overflow-y-auto']//div")
    WebElement firstElementInTheBasket;//a[@title='To cart']

    @FindBy(xpath = "//a[@title='To cart']")
    WebElement addToCart;

    @FindBy(xpath = "//button[@class='ml-2 text-neutral-600 dark:text-slate-500 text-lg bg-black/10 h-9 w-9 rounded-full hover:bg-black/20']//i[@class='fas fa-times']")
    WebElement closeCart;

    @FindBy(xpath = "(//div[@class='absolute -top-2 -right-1 px-1 py-0.5 text-xs text-white font-semibold bg-red-500 rounded-md md:text-sm md:right-2 md:px-2 md:py-1 cart-button-badge md:-top-1'])[1]")
    WebElement shoppingCartColor;

    @FindBy(xpath = "//a[normalize-space()='Continue to checkout']")
    WebElement continueToCheckout;

    @FindBy(xpath = "(//a[normalize-space()='Cart'])[1]")
    WebElement cartButton;

    @FindBy(xpath = "(//span[normalize-space()='Delete all'])[1]")
    WebElement deleteAllButton;

    public void pressDeleteAllButton(){
        clickElement(deleteAllButton, "Delete all button is pressed");
    }

    public void pressCartButton(){
        clickElement(cartButton, "Cart button is pressed");
    }

    public void clickContinueCheckOut(){
        clickElementJS(continueToCheckout, "Continue to checkout button is pressed");
    }

    public void clickCloseCart(){
        clickElement(closeCart, "Cart window is closed");
    }

    public void clickAddCart(){
        clickElementJS(addToCart, "Add cart button is pressed");
    }

    public void clickContinueButton(){
        clickElementJS(continueButton, "Continue button is pressed");
    }

    public void clickShoppingBasketButton(){
        clickElement(shoppingCartButton,"Shopping basket button is pressed");
    }

    public String getNameEmptyCart(){
        return getElementText(emptyCart);
    }

    public void clickPlusButton(){
        clickElementJS(plusButton, "Plus button is pressed");
    }


    public void addQuantity(String quantity){

        int quantityNumber = Integer.parseInt(quantity);
        for (int i = 0; i <  quantityNumber; i++){
            clickPlusButton();
        }

    }

    public void deleteAllChartsFromBasket(){

        while (firstElementInTheBasket.isDisplayed()){
            System.out.println("Prvi element je prikazan");
        }
        System.out.println("Prvi element NIJE prikazan");
    }

    public String getColorShoppingBasket(String attributeType){
        scrollTopOfWindow();
        return getElementCssValue(shoppingCartColor, attributeType);
    }

    public void deleteAllproducts(){
        List<WebElement> elements = driver.findElements(By.xpath("//a[normalize-space()='Continue to checkout']"));

        if (elements.isEmpty()) {
            System.out.println("Shopping basket is empty");
        } else {
            clickContinueCheckOut();
            pressCartButton();
            pressDeleteAllButton();
        }
    }

    public void verifyTheBasketIsEmpty(){
        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='absolute -top-2 -right-1 px-1 py-0.5 text-xs text-white font-semibold bg-red-500 rounded-md md:text-sm md:right-2 md:px-2 md:py-1 cart-button-badge md:-top-1'])[1]"));

        if (elements.isEmpty()) {
            System.out.println("Shopping basket is empty");
        } else {
            System.out.println("Shopping basket is NOT empty");
            driver.quit();
        }


    }

}

