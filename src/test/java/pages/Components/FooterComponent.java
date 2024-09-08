package pages.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

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
}
