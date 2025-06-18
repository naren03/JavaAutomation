import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
@SerenityTest
public class LoginTest {

    private static final String BASE_URL = "https://recipe-management-platform.com/api";

    @Test
    public void shouldAuthenticateWithValidCredentials() {
        Actor user = Actor.named("User").whoCan(CallAnApi.at(BASE_URL));

        user.attemptsTo(
            Post.to("/login")
                .with(request -> request
                    .header("Content-Type", "application/json")
                    .body("{"username": "validUser", "password": "validPassword"}")
                )
        );

        user.should(
            ResponseConsequence.seeThatResponse("User should be authenticated",
                response -> response.statusCode(200))
        );
    }

    @Test
    public void shouldRejectInvalidCredentials() {
        Actor user = Actor.named("User").whoCan(CallAnApi.at(BASE_URL));

        user.attemptsTo(
            Post.to("/login")
                .with(request -> request
                    .header("Content-Type", "application/json")
                    .body("{"username": "invalidUser", "password": "invalidPassword"}")
                )
        );

        user.should(
            ResponseConsequence.seeThatResponse("User should not be authenticated",
                response -> response.statusCode(401))
        );
    }
}
