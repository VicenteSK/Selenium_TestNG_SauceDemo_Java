package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By title = By.className("title");
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartButton = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    public CartPage clickCartButton() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
