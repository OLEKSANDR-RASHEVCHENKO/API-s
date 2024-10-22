package API.JSON_XMLSchemaValidations;

import io.restassured.matcher.RestAssuredMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class XmlSchemaValidations {
@Test
    public void xmlSchemaValidations(){
        given()

                .when()
                .get("http://restapi.adequateshop.com/api/Traveler")
                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
    }
}
