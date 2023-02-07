package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaBasePage {

    public CarvanaBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[name()='svg'][@role='presentation'])[6]")
    public WebElement logo;


    @FindBy(css = "div[class*='Navigationstyles__NavigationWrapper']")
    public WebElement headerItems;

    @FindBy(css = "a[data-cv-test='headerSignInLink']")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(xpath = "//button[@data-testid]")
    public WebElement continueButton;

    @FindBy(css = "input[type*='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "button[type*='submit']")
    public WebElement submitButton;
    @FindBy(id = "error-banner")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test*='headerSearchLink']")
    public WebElement searchCarsButton;

    @FindBy(css = "div[data-qa='menu-flex']")
    public WebElement filterOptions;

    @FindBy(css = "input[data-test='SearchBarInput']")
    public WebElement searchBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "div[class='result-tile']")
    public List<WebElement> resultTiles;

    @FindBy(css = "picture[class='vehicle-image']")
    public WebElement vehicleImage;

    @FindBy(css = "div[data-qa='base-favorite-vehicle']")
    public WebElement favoriteButton;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBody;

    @FindBy(css = "div[data-qa='base-inventory-type']")
    public WebElement inventoryType;

    @FindBy(css = "div[class='year-make']")
    public WebElement ymmInformation;

    @FindBy(css = "div[class='trim-mileage']")
    public WebElement trimMileageInfo;

    @FindBy(css = "div[data-qa='price']")
    public WebElement price;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public WebElement monthlyPayment;

    @FindBy(css = "div[class='down-payment']")
    public WebElement downPayment;

    @FindBy(css = "div[class*='top-[-1px]']")
    public WebElement deliveryChip;
}