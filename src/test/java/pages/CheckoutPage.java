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
    WebElement zipcodeErrorMessage;

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

    public String getZipCodeMessage(){
        return getElementText(zipcodeErrorMessage);
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

}

