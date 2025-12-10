package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] users() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true},
                {"performance_glitch_user", "secret_sauce", true},
                {"error_user", "secret_sauce", true},
                {"visual_user", "secret_sauce", true}
        };
    }

    @Test(dataProvider = "users")
    public void loginWithMultipleUsers(String username, String password, boolean shouldLogin) throws InterruptedException {

        // Nombre dinámico para el reporte
        String testName = "Login test for user: " + username;
        System.out.println(testName);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        if (shouldLogin) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                    "El usuario debería ingresar, pero falló: " + username);
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"),
                    "El usuario bloqueado debería mostrar error: " + username);
        }
    }
}
