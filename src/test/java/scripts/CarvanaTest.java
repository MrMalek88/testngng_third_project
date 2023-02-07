package scripts;

import org.junit.Assert;
import org.testng.annotations.Test;
import utils.Waiter;

public class CarvanaTest extends CarvanaBaseTest {
    @Test(priority = 1, testName = "Validate Carvana home page title and url")
    public void validateHomePageTitleandURL() {
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, testName = "Validate Carvana Logo")
    public void validateCarvanaLogo() {
        Assert.assertTrue(carvanaBasePage.logo.isDisplayed());
    }

    @Test(priority = 3, testName = "Validate the main navigation section items")

    public void validateHeaderItems() {
        Assert.assertTrue(carvanaBasePage.headerItems.isDisplayed());
    }

    @Test(priority = 4)
    public void validateSignInErrorMessage() {
        carvanaBasePage.signInButton.click();
        Waiter.pause(3);
        carvanaBasePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaBasePage.continueButton.click();
        Waiter.pause(3);
        carvanaBasePage.passwordInputBox.sendKeys("abcd1234");
        carvanaBasePage.submitButton.click();
        Waiter.pause(3);
        Assert.assertEquals(carvanaBasePage.errorMessage.getText(), "Email address and/or password combination is incorrect.");
    }

    @Test(priority = 5)
    public void validateSearchOptions() {
        carvanaBasePage.searchCarsButton.click();
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        Assert.assertEquals(carvanaBasePage.filterOptions.getText(), "PAYMENT & PRICE\n" +
                "MAKE & MODEL\n" +
                "BODY TYPE\n" +
                "YEAR & MILEAGE\n" +
                "FEATURES\n" +
                "MORE FILTERS");
    }

    @Test(priority = 6)
    public void validateSearchResultTiles() {
        Waiter.pause(2);
        carvanaBasePage.searchCarsButton.click();
        carvanaBasePage.searchBox.sendKeys("mercedes-benz");
        carvanaBasePage.goButton.click();
        Waiter.pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (int i = 0; i < carvanaBasePage.resultTiles.size(); i++) {
            Assert.assertTrue(carvanaBasePage.vehicleImage.isDisplayed());
            Assert.assertTrue(carvanaBasePage.favoriteButton.isEnabled());
            Assert.assertTrue(carvanaBasePage.tileBody.get(i).isDisplayed());

            for (int j = 0; j < carvanaBasePage.tileBody.size(); j++) {
                Assert.assertTrue(carvanaBasePage.inventoryType.isDisplayed());
                Assert.assertTrue(carvanaBasePage.ymmInformation.isDisplayed());
                Assert.assertTrue(carvanaBasePage.trimMileageInfo.isDisplayed());
                Assert.assertTrue(carvanaBasePage.price.isDisplayed());
                Assert.assertTrue(carvanaBasePage.monthlyPayment.isDisplayed());
                Assert.assertTrue(carvanaBasePage.downPayment.isDisplayed());
                Assert.assertTrue(carvanaBasePage.deliveryChip.isDisplayed());
            }
        }
    }
}