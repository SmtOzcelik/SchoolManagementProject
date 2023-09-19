package stepDefinitions.apiStepDefinition;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.apiStepDefinition.US11ApiStepDefinition.actualLessonProgramId;

public class US12ApiStepDefinition {
    @Then("Do Assertion creat lesson program")
    public void doAssertionCreatLessonProgram() {

        //https://managementonschools.com/app/lessonPrograms/getById/1
        spec.pathParams("first", "lessonPrograms", "second", "getById","third",actualLessonProgramId);
        Response response=given(spec).get("{first}/{second}/{third}");

        assertEquals(response.statusCode(),200);
    }
}
