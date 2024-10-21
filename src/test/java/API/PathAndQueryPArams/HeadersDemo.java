package API.PathAndQueryPArams;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {
    @Test(priority = 1)
    public void testHeaders() {
        given()
                .when().get("https://www.google.de/")
                .then().header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws");
    }



    @Test(priority = 2)
    public void getHeadersTwo() {
       Response response =  given()
                .when().get("https://www.google.de/");
      //String headerValue =  response.getHeader("Content-Type");
        //System.out.println("headerValue: " + headerValue);

        // get All headers information
        Headers myHeaders = response.getHeaders();
        for (Header header:myHeaders){
            System.out.println(header.getName() + "  "+header.getValue());
        }
    }



}
