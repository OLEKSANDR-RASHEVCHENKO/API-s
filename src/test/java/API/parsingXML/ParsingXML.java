package API.parsingXML;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXML {
    @Test
    public void parseTestXML() {

        //Approach 1
       /* given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1")

                .then().statusCode(200)
                .header("Content-Type", "application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page",equalTo("1"));*/

        //Approach 2
        Response response = given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/xml; charset=utf-8");
        String pageNO = response.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertEquals(pageNO, "1");


    }

    @Test
    public void testXMLResponseBody() {

        //Approach 2
        Response response = given()
                .when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

        XmlPath xmlPath = new XmlPath(response.asString());
        //verify total number of travellers
        List<String> travellers = xmlPath.getList("TravelerinformationResponse.travelers.travelerinformation");
        Assert.assertEquals(travellers.size(), 10);
        // verify traveller name is present in response
        List<String> travellersName = xmlPath.getList("TravelerinformationResponse.travelers.travelerinformation.name");
        boolean status = false;
        for (String travaller :travellersName){
            if (travaller.equals("Vitraly Oleks")){
                status = true;
                break;
            }
        }
        Assert.assertEquals(status,true);


    }
}
