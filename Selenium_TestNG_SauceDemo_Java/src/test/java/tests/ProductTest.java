package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;

public class ProductTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);

        // login
        loginPage.login("standard_user", "secret_sauce");

        // navegar a productos
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle(), "Products");

        // agregar producto
        productsPage.addBackpackToCart();

        // ir al carrito
        CartPage cartPage = productsPage.clickCartButton();

        // validar 1 item en el carrito
        Assert.assertEquals(cartPage.getCartItemsCount(), 1);
    }
}
