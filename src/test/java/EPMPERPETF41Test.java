import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
@SerenityTest
public class EPMPERPETF41Test {

    private static String baseUrl;
    private static String validUsername;
    private static String validPassword;
    private static String invalidUsername;
    private static String invalidPassword;

    @BeforeAll
    public static void setup() {
        baseUrl = "http://recipe-management-platform.com/api";
        validUsername = "validUser";
        validPassword = "validPassword";
        invalidUsername = "invalidUser";
        invalidPassword = "invalidPassword";
    }

    @Test
    public void testValidUserLogin() {
        SerenityRest.given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(validUsername, validPassword)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Access granted"))
                .body("content", equalTo("Personalized content"));
    }

    @Test
    public void testInvalidUserLogin() {
        SerenityRest.given()
                .baseUri(baseUrl)
                .auth().preemptive().basic(invalidUsername, invalidPassword)
                .when()
                .post("/login")
                .then()
                .statusCode(401)
                .body("message", equalTo("Unauthorized"));
    }
}
