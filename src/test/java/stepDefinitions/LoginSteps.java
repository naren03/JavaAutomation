package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("I am on the e-commerce website login page")
    public void i_am_on_the_login_page() {
        // Code to navigate to the login page
    }

    @Then("I should see the login button")
    public void i_should_see_the_login_button() {
        // Code to verify the login button is visible
    }

    @Then("the login button should be clickable")
    public void the_login_button_should_be_clickable() {
        // Code to verify the login button is clickable
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        // Code to enter valid credentials
    }

    @Then("I should be redirected to my account dashboard")
    public void i_should_be_redirected_to_dashboard() {
        // Code to verify redirection to the dashboard
    }

    @Then("I should see a welcome message")
    public void i_should_see_welcome_message() {
        // Code to verify welcome message
    }

    // Additional step definitions for other scenarios
}