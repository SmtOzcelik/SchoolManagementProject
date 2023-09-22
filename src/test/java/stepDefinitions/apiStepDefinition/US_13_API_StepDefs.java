package stepDefinitions.apiStepDefinition;

import baseUrl.ManagementSchoolUrl;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;


import static io.restassured.RestAssured.given;

public class US_13_API_StepDefs extends ManagementSchoolUrl {
    Response response;

    @Given("send get request by name {string}")
    public void send_get_request_by_name(String name) {
//        https://managementonschools.com/app/teachers/getTeacherByName?name=mr.john
//        Set the URL
        setUpViceDean();
        spec.pathParams("first","teachers","second","getTeacherByName").queryParam("name",name);

//        Send the request and get the response
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
    @Then("body should contain username {string}, name {string}, surname {string},birthDay {string}, birthPlace {string},phoneNumber {string},gender {string},email {string}")
    public void body_should_contain_username_name_surname_birth_day_birth_place_phone_number_gender_email(String username, String name, String surname, String birthDay, String birthPlace, String phoneNumber, String gender, String email) throws JsonProcessingException {
        JsonPath actualData = response.jsonPath();
        Assert.assertEquals(username,actualData.getList("username").get(0));
        System.out.println(actualData.getList("username"));
        Assert.assertEquals(name,actualData.getList("name").get(0));
        Assert.assertEquals(surname,actualData.getList("surname").get(0));
        Assert.assertEquals(birthDay,actualData.getList("birthDay").get(0));
        Assert.assertEquals(birthPlace,actualData.getList("birthPlace").get(0));
        Assert.assertEquals(phoneNumber,actualData.getList("phoneNumber").get(0));
        Assert.assertEquals(gender,actualData.getList("gender").get(0));
        Assert.assertEquals(email,actualData.getList("email").get(0));



    }
    @Then("body must be empty with non-existing {string}")
    public void bodyMustBeEmptyWithNonExisting(String name) {
        Assert.assertTrue(response.jsonPath().getList("name").isEmpty());
    }
}
