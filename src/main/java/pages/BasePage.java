package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Wrapper para click
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    // Wrapper para escribir texto
    protected void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    // Obtener texto de un elemento
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Obtener WebElement (por si se necesita)
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // Verificar si un elemento está visible
    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
