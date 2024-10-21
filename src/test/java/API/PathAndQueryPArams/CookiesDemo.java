package API.PathAndQueryPArams;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesDemo {
    @Test(priority = 1)
    public void testCookies() {
        given()
                .when().get("https://www.google.de/")
                .then().cookie("AEC","AVYB7crQ0Uh2dpbR30zQRZUVeeekDsReqoH_f5r8ZnXWhovsV2InhT5NHZc")
                .log().all();
    }

    @Test(priority = 2)
    public void getCookiesInfo() {
        Response response = given()
                .when().get("https://www.google.de/");
        //get single cookie INFO
        //String cookie_value=response.getCookie("AEC");
        //System.out.println("Value of cookies is "  + cookie_value);

        //get all cookies INFO
       Map<String,String> cookies_values=response.getCookies();
        for (String k:cookies_values.keySet()){
            String cookie = response.getCookie(k);
            System.out.println(k + "    "+ cookies_values);
        }
    }
}
