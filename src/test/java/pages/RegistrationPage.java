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

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegistrationPage extends BasePage {



    FooterComponent footerComponent;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@type='submit']/..//a[contains(@href,'/registration')]")
    WebElement registrationButton;

    @FindBy(xpath = "//header//div[2]//div/a[last()]/span")
    WebElement logInVerification;

    @FindBy(css = "#registration_lastname")
    WebElement lastNameSelector;

    @FindBy(css = "#registration_firstname")
    WebElement firstNameSelector;

    @FindBy(css = "#registration_email")
    WebElement registrationEmailSelector;

    @FindBy(css = "#registration_plainPassword")
    WebElement registrationPasswordSelector;

    @FindBy(css = "#registration_username")
    WebElement registrationUserNameSelector;

    @FindBy(css = "#_username")
    WebElement username;

    @FindBy(css = "#registration_submit")
    WebElement registrationSubmit;

    @FindBy(xpath = "//input[@id='registration_lastname']/..//div")
    WebElement lastNameErrorMessage;

    @FindBy(xpath = "//input[@id='registration_firstname']/..//div")
    WebElement FirstNameErrorMessage;

    @FindBy(xpath = "//input[@id='registration_email']/..//div")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//form[@name='registration']//div//div[3]//div[@class='mt-1 text-red-700 text-xs']")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//input[@id='registration_username']/..//div")
    WebElement usernameErrorMessage;

    public void pressIWillRegisterButton() {
        clickElement(registrationSubmit, "I will register button is pressed");
    }

    public void pressRegistrationButton() {
        clickElementJS(registrationButton, "Registration button is pressed");
    }

    public void enterLastName(String lastName) {
        typeText(lastNameSelector, lastName, "lastname is entered");
    }

    public void enterFirstName(String firstName) {
        typeText(firstNameSelector, firstName, "FirstName is entered");
    }

    public void enterEmail(String email) {
        typeText(registrationEmailSelector, email, "Email is entered");
    }

    public void enterPassword(String password) {
        typeText(registrationPasswordSelector, password, "password is entered");
    }

    public void enterUsername(String username) {
        typeText(registrationUserNameSelector, username, "username is entered");
    }

    public String randomEmail() {
        String email;
        Random random = new Random();
        int randomNumber = random.nextInt(5000);
        email = "petrovic" + randomNumber + "@yahoo.com";
        System.out.println("Random mail is: " + email);
        return email;
    }

    public String randomLastName() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(1, 4999);
        String randomFirstName = "Jordan_" + number;
        System.out.println("Random last name exactly after generate is :" + randomFirstName);
        return randomFirstName;
    }

    public String randomFirstName() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(1, 4999);
        String randomFirstName = "Pera_" + number;
        System.out.println("Random first name exactly after generate is :" + randomFirstName);
        return randomFirstName;
    }

    public String randomUserName() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(200, 4999);
        String randomFirstName = "Mik_" + number;
        System.out.println("Random user name exactly after generate is :" + randomFirstName);
        return randomFirstName;
    }

    public String randomPassword() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(200, 4999);
        String passw = "mile" + number;
        System.out.println("Random password is: " + passw);
        return passw;
    }

    public void registrationRandom(String randomLastName, String randomFirstName, String randomEmail, String randomPassword, String randomUserName,
                                   String randomTypeYesNo, String lName, String fName, String mail, String passw, String user) {

        if (randomTypeYesNo.equalsIgnoreCase("yes")) {
            System.out.println("This is random method for filling data in the fields");
            typeText(lastNameSelector, randomLastName, "Random last name is entered");
            typeText(firstNameSelector, randomFirstName, "Random first name is entered");
            typeText(registrationEmailSelector, randomEmail, "Random email is entered");
            typeText(registrationPasswordSelector, randomPassword, "Random password is entered");
            typeText(registrationUserNameSelector, randomUserName, "Random user name is entered");
            pressIWillRegisterButton();
        } else {
            System.out.println("This is manual method for filling data in the fields");
            enterLastName(lName);
            enterFirstName(fName);
            enterEmail(mail);
            enterPassword(passw);
            enterUsername(user);
            pressIWillRegisterButton();
        }
    }

    public void verifyErrorMessageLastName(String errorMessageLastName) {
        compareText(lastNameErrorMessage, errorMessageLastName);
    }

    public void verifyErrorMessageFirstName(String errorMessageLastName) {
        compareText(FirstNameErrorMessage, errorMessageLastName);
    }

    public void verifyErrorMessageEmail(String errorMessageEmail) {
        compareText(emailErrorMessage, errorMessageEmail);
    }

    public void verifyErrorMessagePassword(String errorMessagePassword) {
        compareText(passwordErrorMessage, errorMessagePassword);
    }

    public void verifyErrorMessageUserName(String errorMessageUserName) {
        compareText(usernameErrorMessage, errorMessageUserName);
    }

    public void visibilityOfPopup(){
        WebElement element = driver.findElement(By.xpath("//div[@id='rc-imageselect']"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void closePopupWindow(){
        clickSpecificCoordinate();
        WebElement element = driver.findElement(By.cssSelector("#rc-imageselect"));
        explicitWait(element);
        if(element.isDisplayed()){
            System.out.println("Quiz popup window is displayed");
            clickSpecificCoordinate();
        } else {
            System.out.println("Do nothing");
        }
    }
}

