package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {

        // ===== LOGIN =====
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Validar que el login funcionó
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "El login falló, no se pudo continuar con el checkout.");

        // ===== CHECKOUT =====
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // 1. Agregar producto al carrito
        checkoutPage.addBackpackToCart();

        // 2. Ir al carrito
        checkoutPage.goToCart();

        // 3. Iniciar checkout
        checkoutPage.clickCheckout();

        // 4. Llenar formulario
        checkoutPage.fillInformation("Vicente", "Valenzuela", "8330123");
        checkoutPage.clickContinue();

        // 5. Validar total
        String total = checkoutPage.getTotal();
        System.out.println("Total encontrado: " + total);

        Assert.assertTrue(total.contains("Total"),
                "El total del checkout no aparece correctamente.");

        // 6. Finalizar compra
        checkoutPage.clickFinish();

        // 7. Validar mensaje final
        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!",
                "El mensaje final del checkout no coincide.");

        System.out.println("Checkout completado correctamente.");
    }
}
