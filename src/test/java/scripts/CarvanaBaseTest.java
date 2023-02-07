package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaBasePage;
import utils.ConfigReader;
import utils.Driver;

public class CarvanaBaseTest {

        CarvanaBasePage carvanaBasePage;
        CarvanaBaseTest carvanaBaseTest;
        CarvanaTest carvanaTest;

        WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        carvanaBasePage = new CarvanaBasePage();
    }

    @AfterMethod
    public void teardown (){
        Driver.quitDriver();
    }
}