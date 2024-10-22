package API.JSON_XMLSchemaValidations;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class JSONSchemaValidations {

    //https://jsonformatter.org/json-to-jsonschema -- json schema editor
    @Test
    public void JsonSchemaValidations(){

        given()

                .when().get("http://localhost:3000/book")

                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaJson.json")).log().all();
    }
}
