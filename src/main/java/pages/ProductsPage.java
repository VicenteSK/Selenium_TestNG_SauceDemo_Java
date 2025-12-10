package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    // ====== LOCATORS ======
    private By productsTitle = By.xpath("//span[@class='title']");
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButton = By.id("shopping_cart_container");

    // ====== CONSTRUCTOR ======
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ====== MÉTODOS ======

    /** Verifica que estás en la página de productos */
    public boolean isProductPageDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    /** Agrega la mochila al carrito */
    public void addBackpackToCart() {
        driver.findElement(addToCartBackpack).click();
    }

    /** Agrega la luz para bicicleta al carrito */
    public void addBikeLightToCart() {
        driver.findElement(addToCartBikeLight).click();
    }

    /** Va al carrito */
    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}
