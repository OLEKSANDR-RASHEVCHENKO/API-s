package API.JSON_XMLSchemaValidations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

//POJO ---->serilize----> JSON object --de-seril-->------------> Pojo
public class SetializationDeserialization {

@Test
    public void  convertPojoToJson() throws JsonProcessingException {
        //create java object using pojo class
        Student student = new Student();
        student.setName("Alex");
        student.setLocation("France");
        student.setPhone("123");
        String courseArray[] = {"C","C++"};
        student.setCourses(courseArray);

        // convert java object ---> to json objekt(serilization)

        ObjectMapper objectMapper = new ObjectMapper(); // from jakson library
        String jsonData=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(jsonData);
    }



    @Test
    public void  convertJsonToPojo() throws JsonProcessingException {
        // convert json object to java object
        String jsonData = "{\n" +
                "  \"name\" : \"Alex\",\n" +
                "  \"location\" : \"France\",\n" +
                "  \"phone\" : \"123\",\n" +
                "  \"courses\" : [ \"C\", \"C++\" ]\n" +
                "}";
        // convert json object to pojo object
        ObjectMapper objectMapper = new ObjectMapper(); // from jakson library
        Student student = objectMapper.readValue(jsonData, Student.class);
        System.out.println(student.getName());
        System.out.println(student.getCourses()[0]);
        System.out.println(student.getCourses()[1]);
        System.out.println(student.getLocation());
        System.out.println(student.getPhone());

    }
}
