package API.PathAndQueryPArams;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathUndQueryParam {
    @Test
    public void testQueryAndPathParams(){
        //https://reqres.in/api/users?page=2&id=5
        given()
                .pathParam("mypath2","users")//path parameters
                .queryParam("page",2)//query parameters
                .queryParam("id",5)// query parameters

                .when().get("https://reqres.in/api/{mypath2}")
                .then().statusCode(200).log().all();
    }

}
