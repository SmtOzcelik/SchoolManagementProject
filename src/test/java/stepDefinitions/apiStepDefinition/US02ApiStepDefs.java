package stepDefinitions.apiStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.US02Pojo.US02guestListPojo;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class US02ApiStepDefs {
    Response response;
    JsonPath jsonPath;


    @Given("Admin tum Guest User bilgilerini gorebilir")
    public void adminTumGuestUserBilgileriniGorebilir() {

        //      set the url
        spec.pathParams("first", "guestUser", "second", "getAll").queryParam("size", "1000");

        //     send the request and get the response
        //String url = "{{baseUrl}}/guestUser/getAll?size=1000";
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }

   @Then("Admin Guest User List, {string} {string} {string} {string} {string} bilgilerini dogrular")
    public void adminGuestUserListBilgileriniDogrular(String name, String surname, String phoneNumber, String ssn, String username) {


        //set the expected data
      US02guestListPojo expectedData=new US02guestListPojo(name, surname, phoneNumber, ssn, username);

       //Do assertion
       jsonPath = response.jsonPath();
    Object actualName = jsonPath.getList("content.findAll{it.username=='"+username+"'}.name").get(0);
    Object actualSurname = jsonPath.getList("content.findAll{it.username=='"+username+"'}.surname").get(0);
    Object actualPhoneNumber = jsonPath.getList("content.findAll{it.username=='"+username+"'}.phoneNumber").get(0);
    Object actualSsn = jsonPath.getList("content.findAll{it.username=='"+username+"'}.ssn").get(0);
    Object actualUsername = jsonPath.getList("content.findAll{it.username=='"+username+"'}.username").get(0);

       assertEquals(200,response.statusCode());
       assertEquals(expectedData.getName(),actualName);
       assertEquals(expectedData.getSurname(),actualSurname);
       assertEquals(expectedData.getPhoneNumber(),actualPhoneNumber);
       assertEquals(expectedData.getSsn(),actualSsn);
       assertEquals(expectedData.getUsername(),actualUsername);
   }

//{
//    "object": {
//        "userId": 1366,
//        "username": "emasu21",
//        "name": "usame",
//        "surname": "emasu",
//        "birthDay": "2001-12-25",
//        "ssn": "856-65-6559",
//        "birthPlace": "usame",
//        "phoneNumber": "246-663-6589",
//        "gender": "MALE"
//    },
    @Given("Admin silecegi Guest User bilgilerini delete request yapar")
    public void adminSilecegiGuestUserBilgileriniDeleteRequestYapar() {
        //https://managementonschools.com/app/guestUser/delete/1367
        //set the url
        spec.pathParams("first", "guestUser", "second", "delete", "third", 1367);

        //send the request and get the response for DELETE
        response = given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();
    }

//    {
//        "message": " Guest User deleted Successful",
//        "httpStatus": "OK"
//    }
    @Then("Guest Userin silindigini dogrular")
    public void guestUserinSilindiginiDogrular() {
        //do assertion
        jsonPath = response.jsonPath();

        String expectedMessage = " Guest User deleted Successful";
        String expectedHttpStatus = "OK";
        String actualMessage = jsonPath.getString("message");
        String actualHttpStatus = jsonPath.getString("httpStatus");
        assertEquals(200, response.statusCode());
        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedHttpStatus, actualHttpStatus);
    }
}
