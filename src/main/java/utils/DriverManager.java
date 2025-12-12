package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    public static WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();

        // Ejecutar Chrome en modo incógnito
        options.addArguments("--incognito");

        // Opcional: desactivar servicios que disparan popups
        options.addArguments("--disable-save-password-bubble");
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("credentials_enable_service", false);
            put("profile.password_manager_enabled", false);
        }});

        return new ChromeDriver(options);
    }
}
