package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.Components.FooterComponent;

import java.util.List;

public class CheckoutPage extends BasePage {



    FooterComponent footerComponent;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//button[@class='button button--success button--vlg button--icon--right checkout__nav__button checkout__nav__button--pay'])[1]")
    WebElement orderButton;

    @FindBy(xpath = "(//div[@class='input__error form-group__error'][normalize-space()='This value should not be blank.'])[1]")
    WebElement zipcodeErrorMessageBlank;

    @FindBy(xpath = "(//div[normalize-space()='This value is not a valid zip code.'])[1]")
    WebElement zipcodeErrorMessageBad;

    @FindBy(xpath = "(//div[@class='input__error form-group__error'][normalize-space()='This value should not be blank.'])[2]")
    WebElement cityErrorMessage;

    @FindBy(xpath = "(//div[@class='input__error form-group__error'][normalize-space()='This value should not be blank.'])[3]")
    WebElement streetErrorMessage;

    @FindBy(css = "#checkout_base_billingCountry")
    WebElement selectCountry;

    @FindBy(css = "#checkout_base_billingZip")
    WebElement zipcode;

    @FindBy(css = "#checkout_base_billingCity")
    WebElement city;

    @FindBy(css = "#checkout_base_billingAddress")
    WebElement address;

    @FindBy(xpath = "//i[@class='fas fa-shopping-cart text-xl md:text-2xl mr-1']")
    WebElement shoppingCartButton;

    @FindBy(xpath = "(//span[@class='button__text'][normalize-space()='Edit'])[1]")
    WebElement editButtownOwnData;

    @FindBy(xpath = "(//span[@class='button__text'][normalize-space()='Edit'])[2]")
    WebElement editButtonPickup;

    @FindBy(xpath = "(//span[@class='button__text'][normalize-space()='Edit'])[3]")
    WebElement editButtonPayment;

    public String getZipCodeMessageBlank(){
        return getElementText(zipcodeErrorMessageBlank);
    }

    public String getZipCodeMessageBad(){
        return getElementText(zipcodeErrorMessageBad);
    }

    public String getCityMessage(){
        return getElementText(cityErrorMessage);
    }

    public String getStreetMessage(){
        return getElementText(streetErrorMessage);
    }

    public void pressOrderButton(){
        clickElementJS(orderButton, "Order button is pressed");
    }

    public void pressShoppingCartButton(){
        clickElement(shoppingCartButton, "Shopping cart button is pressed");
    }

    public void pressEditOwnButton(){
        clickElement(editButtownOwnData, "Edit button is pressed");
    }

    public void pressPickupButton(){
        clickElement(editButtonPickup, "Edit button is pressed");
    }

    public void pressEditPayment(){
        clickElement(editButtonPayment, "Edit button is pressed");
    }

    public void selectCountry(String country){

        Select dropdown = new Select(selectCountry);
        dropdown.selectByVisibleText(country);
    }

    public void enterZipcode(String zip){
        typeText(zipcode, zip,"Zipcode is entered");
    }

    public void enterCity(String town){
        typeText(city, town, "City is entered");
    }

    public void enterStreet(String street){
        typeText(address, street, "Street is entered");
    }

    public void editOwnData(String country, String zip, String city, String street){

        selectCountry(country);
        enterZipcode(zip);
        enterCity(city);
        enterStreet(street);
    }

}

