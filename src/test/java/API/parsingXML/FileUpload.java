package API.parsingXML;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FileUpload {
    @Test
    public void singleFileUpload(){
        File myFile = new File("C:\\Users\\OleksandrRashevchenk\\OneDrive - QESTIT\\Desktop\\Docs");
        given().multiPart("file",myFile).contentType("multipart/form-data").

        when().post("http://localhost:8080/uploadFile")

                .then().statusCode(200)
                                .body("filename",equalTo("sdfsdf.txt")).log().all();
    }
}
