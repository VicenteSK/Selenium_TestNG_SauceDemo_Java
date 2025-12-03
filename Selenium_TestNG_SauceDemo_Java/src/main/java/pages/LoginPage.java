package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Métodos "visibles" con espera interna (NO lanzan checked exception)
    public void enterUsername(String username) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        driver.findElement(loginButton).click();
    }

    // Método conveniente que usan tus tests (sin throws)
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
