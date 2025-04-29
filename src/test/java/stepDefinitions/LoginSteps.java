package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import hooks.Hooks;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        driver.get("http://example.com/homepage");
    }

    @Given("I am on a relevant page")
    public void i_am_on_a_relevant_page() {
        driver.get("http://example.com/relevant-page");
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("http://example.com/login");
    }

    @Then("I should see a prominently displayed login button")
    public void i_should_see_a_prominently_displayed_login_button() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
        assertTrue(loginButton.isDisplayed());
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();
    }

    @Then("a login modal should open")
    public void a_login_modal_should_open() {
        // Implementation for verifying the login modal is open
    }
}