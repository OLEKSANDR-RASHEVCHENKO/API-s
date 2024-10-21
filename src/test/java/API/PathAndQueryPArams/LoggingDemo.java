package API.PathAndQueryPArams;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LoggingDemo {
    @Test
    public void testLog(){
        given()
                .when().get("https://reqres.in/api/users?page=2&id=5")
                .then().log().headers();
    }
}
