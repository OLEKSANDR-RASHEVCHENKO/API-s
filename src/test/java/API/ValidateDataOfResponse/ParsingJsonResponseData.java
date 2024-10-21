package API.ValidateDataOfResponse;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonResponseData {
    @Test(priority = 1)
    public void testJsonResponseParse() {
        //Approach1

        /*given().contentType("application.JSON")
                .when().get("http://localhost:3000/book")
                .then().statusCode(200).header("Content-Type", "application/json")
                .body("x[3].title",equalTo("The Lord of the Rings"));*/

        //Approach2
        /*Response response = given().contentType("ContentType.JSON")
                .when().get("http://localhost:3000/book");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.header("Content-Type"),"application/json");
        JsonPath jsonPath = new JsonPath(String.valueOf(response));
        String bookname=jsonPath.getString(".[3].title");
        Assert.assertEquals(bookname,"The Lord of the Rings");
    }*/

        //Approach3
        Response response = given().contentType(ContentType.JSON)
                .when().get("http://localhost:3000/book");
        JSONObject jsonObject = new JSONObject(response.asString());

        for (int i=0;i<jsonObject.getJSONArray("x").length();i++){
           String bookTitle = jsonObject.getJSONArray("x").getJSONObject(i).get("title").toString();
            System.out.println(bookTitle);
        }



    }
}