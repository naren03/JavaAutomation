package com.myapp;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.tasks.Enter;
import net.serenitybdd.screenplay.tasks.Click;
import net.serenitybdd.screenplay.ui.PageElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginTests {

    private Actor user;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        user = Actor.named("user").whoCan(BrowseTheWeb.with(driver));
    }

    @Test
    public void validUserCanLogin() {
        user.attemptsTo(Open.url("http://myapp.com/login"));
        user.attemptsTo(Enter.theValue("validUser").into(PageElement.locatedBy("#username")));
        user.attemptsTo(Enter.theValue("validPassword").into(PageElement.locatedBy("#password")));
        user.attemptsTo(Click.on(PageElement.locatedBy("#loginButton")));
        user.should(seeThat(Text.of(PageElement.locatedBy("#welcomeMessage")), equalTo("Welcome validUser")));
    }

    @Test
    public void invalidUserCannotLogin() {
        user.attemptsTo(Open.url("http://myapp.com/login"));
        user.attemptsTo(Enter.theValue("invalidUser").into(PageElement.locatedBy("#username")));
        user.attemptsTo(Enter.theValue("invalidPassword").into(PageElement.locatedBy("#password")));
        user.attemptsTo(Click.on(PageElement.locatedBy("#loginButton")));
        user.should(seeThat(Text.of(PageElement.locatedBy("#errorMessage")), equalTo("Invalid credentials")));
    }
}
