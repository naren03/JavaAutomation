package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;

public class Hooks {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    // Add teardown method if necessary
}