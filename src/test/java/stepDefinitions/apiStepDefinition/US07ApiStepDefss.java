package stepDefinitions.apiStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US07ApiStepDefss {
    Response response;

    @Given("Take all of messages with Get request")
    public void takeAllOfMessagesWithGetRequest() {
        spec.pathParams("first","contactMessages","second","getAll").
                queryParams("size","10000");

        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("Verify body : name={string}, email={string}, subject={string}, message={string}, date={string}")
    public void verifyBodyNameEmailSubjectMessageDate(String name, String email, String subject, String message, String date) {
        JsonPath jsonPath = response.jsonPath();
        String actName = jsonPath.getList("content.findAll{it.email=='merve@gmail.com'}.name").get(0).toString();
        String actEmail = jsonPath.getList("content.findAll{it.email=='merve@gmail.com'}.email").get(0).toString();
        String actSubject = jsonPath.getList("content.findAll{it.email=='merve@gmail.com'}.subject").get(0).toString();
        String actMessage = jsonPath.getList("content.findAll{it.email=='merve@gmail.com'}.message").get(0).toString();
        String actDate = jsonPath.getList("content.findAll{it.email=='merve@gmail.com'}.date").get(0).toString();

        assertEquals(200,response.statusCode());
        assertEquals(actName,name);
        assertEquals(actEmail,email);
        assertEquals(actSubject,subject);
        assertEquals(actMessage,message);
        assertEquals(actDate,date);
    }
}
