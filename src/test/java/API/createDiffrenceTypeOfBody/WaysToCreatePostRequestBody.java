package API.createDiffrenceTypeOfBody;

import API.createDiffrenceTypeOfBody.pojoPostReq.Pojo;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class WaysToCreatePostRequestBody {

    //1) Post body request using Hashmap
    @Test(priority = 1)
    public void createPostBodyUsingHashMap() {
        HashMap data = new HashMap();
        data.put("name", "Alex");
        data.put("locations", "France");
        data.put("phone", "123");

        String courseARR[] = {"C", "C++"};
        data.put("courses", courseARR);//add to body array


        given().contentType("application/json").body(data)

                .when().post("http://localhost:3000/students")

                .then().statusCode(201).body("name", equalTo("Alex")).body("locations", equalTo("France")).body("phone", equalTo("123")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("C++")).header("Content-Type", "application/json").log().all();
    }

    @Test(priority = 2)
    public void delete() {
        given().when().delete("http://localhost:3000/students/2913").then().statusCode(200);
    }


    //2) Post body request using Org.JSON
    @Test(priority = 3)
    public void createPostBodyUsingOrgJSON() {
        JSONObject data = new JSONObject();
        data.put("name", "Alex");
        data.put("locations", "France");
        data.put("phone", "123");
        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);


        given().contentType("application/json").body(data.toString())

                .when().post("http://localhost:3000/students")

                .then().statusCode(201).body("name", equalTo("Alex")).body("locations", equalTo("France")).body("phone", equalTo("123")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("C++")).header("Content-Type", "application/json").log().all();
    }

    @Test(priority = 2)
    public void delete2() {
        given().when().delete("http://localhost:3000/students/0682").then().statusCode(200);
    }


    //3) Post body request using POJO Class
    @Test
    public void createPostBodyUsingPOJO() {
        Pojo data = new Pojo();
        data.setName("Alex");
        data.setLocations("France");
        data.setPhone("123");
        String courseArr[] = {"C", "C++"};
        data.setCourses(courseArr);


        given().contentType("application/json").body(data)

                .when().post("http://localhost:3000/students")

                .then().statusCode(201).body("name", equalTo("Alex"))
                .body("locations", equalTo("France"))
                .body("phone", equalTo("123"))
                .body("courses[0]", equalTo("C"))
                .body("courses[1]", equalTo("C++"))
                .header("Content-Type", "application/json").log().all();
    }

    @Test(priority = 2)
    public void delete3() {
        given().when().delete("http://localhost:3000/students/0682").then().statusCode(200);
    }


    //4) Crate Post request body with extern File
    @Test
    public void createBodyWithExternBody() throws FileNotFoundException {
        File file = new File(".\\body.json");
        FileReader filereader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(filereader);
        JSONObject data = new JSONObject(jsonTokener);


        given().contentType("application/json").body(data.toString())

                .when().post("http://localhost:3000/students")

                .then().statusCode(201).body("name", equalTo("SmithAlexander"))
                .body("locations", equalTo("Canada"))
                .body("phone", equalTo("1654987654"))
                .body("courses[0]", equalTo("C++"))
                .body("courses[1]", equalTo("RestAPI"))
                .header("Content-Type", "application/json").log().all();
    }

    @Test(priority = 2)
    public void delete4() {
        given().when().delete("http://localhost:3000/students/c5bd").then().statusCode(200);
    }


}
