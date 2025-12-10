package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.createDriver();
        driver.get("https://www.saucedemo.com/");

        // Guardar driver para el listener
        org.testng.Reporter.getCurrentTestResult().setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
