package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage extends BasePage {

    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ⭐ PAUSA (solo para visualizar el flujo)
    private void pause() {
        try {
            Thread.sleep(1000); // 1 segundo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Elementos
    private By btnAddBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    private By btnCheckout = By.id("checkout");

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");

    private By btnContinue = By.id("continue");
    private By btnFinish = By.id("finish");

    private By totalLabel = By.cssSelector(".summary_total_label");
    private By confirmationHeader = By.cssSelector("h2.complete-header");

    // Acciones

    public void addBackpackToCart() {
        pause();
        click(btnAddBackpack);
    }

    public void goToCart() {
        pause();
        click(cartIcon);
    }

    public void clickCheckout() {
        pause();
        click(btnCheckout);
    }

    public void fillInformation(String first, String last, String zip) {

        // 🔥 Espera obligatoria
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));

        pause();
        type(firstNameInput, first);

        pause();
        type(lastNameInput, last);

        pause();
        type(postalCodeInput, zip);
    }

    public void clickContinue() {
        pause();
        click(btnContinue);
    }

    public void clickFinish() {
        pause();
        click(btnFinish);
    }

    public String getTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalLabel));
        pause();
        return driver.findElement(totalLabel).getText();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationHeader));
        pause();
        return driver.findElement(confirmationHeader).getText();
    }
}
