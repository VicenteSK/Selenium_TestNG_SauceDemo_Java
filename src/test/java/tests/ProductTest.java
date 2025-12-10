package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;

public class ProductTest extends BaseTest {

    @Test
    public void ProductTest_01_verifyProductsPageLoads() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductPageDisplayed(),
                "❌ La página de productos no se muestra correctamente");
    }

    @Test
    public void ProductTest_02_addBackpackToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductPageDisplayed(), "No entró a Products");

        productsPage.addBackpackToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "❌ La mochila no está en el carrito");
    }

    @Test
    public void ProductTest_03_addBikeLightToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductPageDisplayed(), "No entró a Products");

        productsPage.addBikeLightToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"),
                "❌ La Bike Light no está en el carrito");
    }

    @Test
    public void ProductTest_04_addTwoProducts() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductPageDisplayed(), "No entró a Products");

        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "❌ La Backpack no está en el carrito");
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"),
                "❌ La Bike Light no está en el carrito");
    }
}
