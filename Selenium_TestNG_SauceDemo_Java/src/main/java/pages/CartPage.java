package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartItems = By.className("cart_item");
    private By title = By.className("title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
