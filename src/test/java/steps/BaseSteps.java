package steps;

import com.fasterxml.jackson.databind.ser.Serializers;
import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import pages.*;
import pages.Components.FooterComponent;
import tests.BaseTest;

import java.util.Map;
import java.util.ResourceBundle;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    RegistrationPage rp = new RegistrationPage(driver);
    String randomLastName;
    String randomFirstName;
    String randomEmail;
    String randomPassword;
    String randomUserName;

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        ipon((env));
        randomLastName = rp.randomLastName();
        randomFirstName = rp.randomFirstName();
        randomEmail = rp.randomEmail();
        randomPassword = rp.randomPassword();
        randomUserName = rp.randomUserName();

    }

    @After
    public void tearDown() {
        quit();
    }

    @Given("a user reads test data from {string} {string} by id {string}")
    public void aUserReadsTestDataFromById(String fileName, String sheetName, String id) throws Exception {
        data = new ExcelSupport().getDataByID(fileName, sheetName, id);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() throws InterruptedException {
        new LoginLogoutPage(driver).pressLoginButton();
    }

    @Given("the user is on the ipon page")
    public void theUserIsOnTheIponPage() {
        new BasePage(driver).checkUrlDefaultPage();
    }

    @And("user enters username and password for login action")
    public void userEntersUsernameAndPasswordForLoginAction() {
        new LoginLogoutPage(driver).loginButton(data.get("username"), data.get("email"), data.get("password"), data.get("emailYesNo"));
    }

    @Then("user should verify login action")
    public void userShouldVerifyLoginAction() {
        new LoginLogoutPage(driver).verifyLoginAction(data.get("logIn"));
    }

    @And("user chooses language")
    public void userChoosesLanguage() {
        new FooterComponent(driver).selectLanguage(data.get("languageNumber"));
    }

    @And("user enters email and password for login action")
    public void userEntersEmailAndPasswordForLoginAction() {
        new LoginLogoutPage(driver).loginButton(data.get("username"), data.get("email"), data.get("password"), data.get("emailYesNo"));
    }

    @Then("user should verify invalid login action")
    public void userShouldVerifyInvalidLoginAction() {
        new LoginLogoutPage(driver).checkMessage(data.get("invalidMessage"));
    }

    @And("user clicks login footer button")
    public void userClicksLoginFooterButton() {
        LoginLogoutPage lp = new LoginLogoutPage(driver);
        lp.logInFooterButton();
    }

    @And("check languages")
    public void checkLanguages() {
        new FooterComponent(driver).checkLanguages(data.get("invalidMessage"));
    }

    @And("user expand languages bar")
    public void userExpandLanguagesBar() {
        new FooterComponent(driver).expandLanguagesBar();
    }

    @Then("user should verify existing of all languages")
    public void userShouldVerifyExistingOfAllLanguages() throws InterruptedException {
        new FooterComponent(driver).verifyAllLanguages();
    }

    @And("user clicks logout button")
    public void userClicksLogoutButton() throws InterruptedException {
        new LoginLogoutPage(driver).logoutButton();
    }

    @Then("user should verify logout action")
    public void userShouldVerifyLogoutAction() {
        new LoginLogoutPage(driver).verifyLogOutAction(data.get("logOut"));
    }

    @And("user checks remember me option")
    public void userChecksRememberMeOption() {
        new LoginLogoutPage(driver).selectRememberMe();
    }

    @And("user enters username and password and check remember option for login action")
    public void userEntersUsernameAndPasswordAndCheckRememberOptionForLoginAction() throws InterruptedException {
        new LoginLogoutPage(driver).loginButtonRememberMe(data.get("username"), data.get("email"), data.get("password"), data.get("emailYesNo"));
    }

    @And("user clicks forgotten password button")
    public void userClicksForgottenPasswordButton() {
        new LoginLogoutPage(driver).pressForgottenPassword();
    }

    @Then("user should verify new page for lost password")
    public void userShouldVerifyNewPageForLostPassword() {
        new BasePage(driver).checkUrlPage(data.get("url2"));
    }

    @And("user clicks registration button")
    public void userClicksRegistrationButton() {
        new RegistrationPage(driver).pressRegistrationButton();
    }

    @And("user should verify registration page")
    public void userShouldVerifyRegistrationPage() {
        new BasePage(driver).checkUrlPage(data.get("url2"));
    }

    @And("user should fill all fields")
    public void userShouldFillAllFields() {
        new RegistrationPage(driver).registrationRandom(randomLastName, randomFirstName, randomEmail, randomPassword, randomUserName,
                data.get("randomTypeYesNo"),
                data.get("lastName"),
                data.get("firstName"),
                data.get("emailRegistration"),
                data.get("passwordRegistration"),
                data.get("userNameRegistration"));
    }

    @Then("user should verify that is registered")
    public void userShouldVerifyThatIsRegistered() {
        new BasePage(driver).checkUrlPage(data.get("url2"));
    }

    @Then("user should verify that the surename field is blank")
    public void userShouldVerifyThatTheSurenameFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageLastName(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the firstname field is blank")
    public void userShouldVerifyThatTheFirstnameFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageFirstName(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the email field is blank")
    public void userShouldVerifyThatTheEmailFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageEmail(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the password field is blank")
    public void userShouldVerifyThatThePasswordFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessagePassword(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the username field is blank")
    public void userShouldVerifyThatTheUsernameFieldIsBlank() {
        new RegistrationPage(driver).verifyErrorMessageUserName(data.get("errorMessageEmpty"));
    }

    @Then("user should verify that the email field is filled as invalid")
    public void userShouldVerifyThatTheEmailFieldIsFilledAsInvalid() {
        new RegistrationPage(driver).verifyErrorMessageEmail(data.get("errorMesssageEmailNotValid"));
    }

    @And("user closes popup window")
    public void userClosesPopupWindow() {
        new RegistrationPage(driver).closePopupWindow();
    }

    @Then("user should verify that the password field is filled as invalid")
    public void userShouldVerifyThatThePasswordFieldIsFilledAsInvalid() {
        new RegistrationPage(driver).verifyErrorMessagePassword(data.get("errorMesssageEmailNotValid"));
    }

    @Then("user should verify that the username field is filled as invalid")
    public void userShouldVerifyThatTheUsernameFieldIsFilledAsInvalid() {
        new RegistrationPage(driver).verifyErrorMessageUserName(data.get("errorMesssageEmailNotValid"));
    }

    @And("user clicks Myprofile button")
    public void userClicksMyprofileButton() throws InterruptedException {
        new LoginLogoutPage(driver).expandMyProfile();
    }

    @Then("user should verify all myprofile items")
    public void userShouldVerifyAllMyprofileItems() throws InterruptedException {
        new GeneralPage(driver).verifyAllItemsMyProfile();
    }

    @And("user clicks Order item")
    public void userClicksOrderItem() throws InterruptedException {
        new GeneralPage(driver).clickOrders();
    }

    @Then("user should verify visibility of item")
    public void userShouldVerifyVisibilityOfItem() {
        new GeneralPage(driver).verifyOrders(data.get("myProfileItem1"));
    }

    @And("user want to get name favourites")
    public String userWantToGetNameFavourites() {
        return new GeneralPage(driver).getNameFavouritesItem();
    }

    @Then("user should verify visibility of item Favourites")
    public void userShouldVerifyVisibilityOfItemFavourites() {
        Assert.assertEquals(new GeneralPage(driver).getNameFavouritesItem(),data.get("myProfileItem2"));
    }

    @And("user clicks Favourites item")
    public void userClicksFavouritesItem() throws InterruptedException {
        new GeneralPage(driver).clickFavourites();
    }

    @And("user clicks Monitored item")
    public void userClicksMonitoredItem() throws InterruptedException {
        new GeneralPage(driver).clickMonitoredItems();
    }

    @And("user want to get name monitored item")
    public String userWantToGetNameMonitoredItem() {
        return new GeneralPage(driver).getNameMonitoredItem();
    }

    @Then("user should verify visibility of Monitored item")
    public void userShouldVerifyVisibilityOfMonitoredItem() {
        Assert.assertEquals(new GeneralPage(driver).getNameMonitoredItem(),data.get("myProfileItem3"));
    }

    @And("user clicks Partner Program item")
    public void userClicksPartnerProgramItem() throws InterruptedException {
        new GeneralPage(driver).clickPartnerProgramItems();
    }

    @And("user want to get name partner program item")
    public void userWantToGetNamePartnerProgramItem() {

    }

    @Then("user should verify visibility of Partner program item")
    public void userShouldVerifyVisibilityOfPartnerProgramItem() {
        Assert.assertEquals(new GeneralPage(driver).getNamePartnerProgram(),data.get("myProfileItem4"));
    }

    @And("user clicks Personal Information item")
    public void userClicksPersonalInformationItem() throws InterruptedException {
        new GeneralPage(driver).clickPersonalInformationItems();
    }

    @And("user want to get name personal information item")
    public String userWantToGetNamePersonalInformationItem() {
        return new GeneralPage(driver).getNamePersonalInformation();
    }

    @Then("user should verify visibility of Personal information item")
    public void userShouldVerifyVisibilityOfPersonalInformationItem() {
        Assert.assertEquals(new GeneralPage(driver).getNamePersonalInformation(),data.get("myProfileItem5"));
    }

    @And("user clicks Settings item")
    public void userClicksSettingsItem() throws InterruptedException {
        new GeneralPage(driver).clickSettingsItems();
    }

    @And("user want to get name settings item")
    public String userWantToGetNameSettingsItem() {
        return new GeneralPage(driver).getNameSettings();
    }

    @Then("user should verify visibility of Settings item")
    public void userShouldVerifyVisibilityOfSettingsItem() {
        Assert.assertEquals(new GeneralPage(driver).getNameSettings(), data.get("myProfileItem6"));
    }

    @And("user choose category")
    public void userChooseCategory() throws InterruptedException {
        new GeneralPage(driver).selectCategory1_6(data.get("category"));
    }

    @And("user choose notebook as a product")
    public void userChooseNotebookAsAProduct() throws InterruptedException {
        new NotebookPCPage(driver).selectNoteBookProduct(data.get("notebook"));
    }

    @And("user want to get name of Notebook category")
    public String userWantToGetNameOfNotebookCategory() {
        return new NotebookPCPage(driver).getNameCategoryNotebook();
    }

    @Then("user should verify visibility of Notebook category")
    public void userShouldVerifyVisibilityOfNotebookCategory() {
        Assert.assertEquals(new NotebookPCPage(driver).getNameCategoryNotebook(), data.get("category"));
    }

    @And("user filters appropriate notebook")
    public void userFiltersAppropriateNotebook() throws InterruptedException {
        new NotebookPCPage(driver).filter1(data.get("typeFilterNotebook"), data.get("minPrice"), data.get("maxPrice"), data.get("pickup"), data.get("warrantyMin"), data.get("warrantyMax"));
    }

    @Then("user should verify visibility Notebook product")
    public void userShouldVerifyVisibilityNotebookProduct() {
        Assert.assertEquals(new NotebookPCPage(driver).getNameNotebookProduct(), data.get("notebook"));
    }

    @Then("user should verify invisibility of filtered product")
    public void userShouldVerifyInvisibilityOfFilteredProduct() {
        Assert.assertEquals(new NotebookPCPage(driver).getUnsuccessfulFilterAction(), data.get("noFilteredAction"));
    }

    @And("user selects one item")
    public void userSelectsOneItem() {
        new NotebookPCPage(driver).clickFistItem();
    }

    @Then("user verify empty shopping basket")
    public void userVerifyEmptyShoppingBasket() {
        ShoppingPage sp = new ShoppingPage(driver);
        Assert.assertEquals(sp.getNameEmptyCart(), data.get("emptyBasket"));
    }

    @And("user clicks continue shopping")
    public void userClicksContinueShopping() {
        new ShoppingPage(driver).clickContinueButton();
    }

    @And("user adds products quantity number")
    public void userAddsProductsQuantityNumber() {
        new ShoppingPage(driver).addQuantity(data.get("quantity"));
    }

    @And("user delete all products from basket")
    public void userDeleteAllProductsFromBasket() {
        new ShoppingPage(driver).deleteAllChartsFromBasket();
    }

    @And("user clicks shopping basket button")
    public void userClicksShoppingBasketButton() {
        new ShoppingPage(driver).clickShoppingBasketButton();
    }

    @And("user clicks add to cart")
    public void userClicksAddToCart() {
        new ShoppingPage(driver).clickAddCart();
    }

    @Then("user should verify that product is added in the shoopping basket")
    public void userShouldVerifyThatProductIsAddedInTheShooppingBasket() {
        Assert.assertEquals(new ShoppingPage(driver).getColorShoppingBasket(data.get("attributeType")), data.get("color"));
    }

    @And("user closes cart window")
    public void userClosesCartWindow() {
        new ShoppingPage(driver).clickCloseCart();
    }

    @And("user clicks continue to cart button")
    public void userClicksContinueToCartButton() {
        new ShoppingPage(driver).clickContinueCheckOut();
    }

    @And("user delete all products")
    public void userDeleteAllProducts() {
        new ShoppingPage(driver).deleteAllproducts();
    }

    @Then("user should verify the basket is empty")
    public void userShouldVerifyTheBasketIsEmpty() {
        new ShoppingPage(driver).verifyTheBasketIsEmpty();
    }

    @And("user clicks continue to checkout")
    public void userClicksContinueToCheckout() {
        new ShoppingPage(driver).clickContinueCheckOut();
    }

    @And("user clicks order button")
    public void userClicksOrderButton() {
        new CheckoutPage(driver).pressOrderButton();
    }

    @Then("user should verify error message for empty zip code")
    public void userShouldVerifyErrorMessageForEmptyZipCode() {
        Assert.assertEquals(new CheckoutPage(driver).getZipCodeMessageBlank(),data.get("zipcodeMessage"));
    }

    @When("user clicks shopping cart button")
    public void userClicksShoppingCartButton() {
        new CheckoutPage(driver).pressShoppingCartButton();
    }

    @And("user clicks edit button of own data")
    public void userClicksEditButtonOfOwnData() {
        new CheckoutPage(driver).pressEditOwnButton();
    }

    @And("user wants to edit own")
    public void userWantsToEditOwn() {
        new CheckoutPage(driver).editOwnData(data.get("country"),data.get("zip"),data.get("city"),data.get("street"));
    }

    @Then("user should verify error message for bad zip code")
    public void userShouldVerifyErrorMessageForBadZipCode() {
        Assert.assertEquals(new CheckoutPage(driver).getZipCodeMessageBad(),data.get("zipcodeMessage"));
    }

    @Then("user should verify error message for empty city")
    public void userShouldVerifyErrorMessageForEmptyCity() {
        Assert.assertEquals(new CheckoutPage(driver).getCityMessage(),data.get("cityMessage"));
    }

    @Then("user should verify error message for empty street")
    public void userShouldVerifyErrorMessageForEmptyStreet() {
        Assert.assertEquals(new CheckoutPage(driver).getStreetMessage(),data.get("streetMessage"));
    }

    @And("user adds new address")
    public void userAddsNewAddress() {
        new GeneralPage(driver).addNewInvoiceAddress();
    }

    @When("user add new information for invoice address")
    public void userAddNewInformationForInvoiceAddress() {
        new GeneralPage(driver).newInvoiceAddress(data.get("name"),data.get("zip"),data.get("city"),data.get("street"),data.get("phone"));
    }

    @And("user clicks save button")
    public void userClicksSaveButton() {
        new GeneralPage(driver).clickSaveButton();
    }

    @Then("user should verify user name")
    public void userShouldVerifyUserName() {
        Assert.assertEquals(new GeneralPage(driver).getInvociceAddressName(), data.get("name"));
    }

    @Then("user should verify other data")
    public void userShouldVerifyOtherData() {
        Assert.assertEquals(new GeneralPage(driver).getInvoiceData(), data.get("otherData"));
    }
}
