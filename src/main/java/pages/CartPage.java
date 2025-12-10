package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // Locators
    private By cartItems = By.className("cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }
    public boolean isProductInCart(String productName) {
        return driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).size() > 0;
    }

}
