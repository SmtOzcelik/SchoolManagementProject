package stepDefinitions.apiStepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pojos.US08Pojo.US08LessonPojo;


import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US08ApiStepDefs {

    Response response;

     @Given("Do get request with lessonName {string}")
    public void doGetRequestWithLessonName(String lessonName) {
        spec.pathParams("first","lessons","second","getLessonByName")
                .queryParams("lessonName","History of World");
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("Verify lesson body that return: lessonId={string}, lessonName={string}, creditScore={string},  compulsory={string}, message={string}")
    public void verifyLessonBodyThatReturnLessonIdLessonNameCreditScoreCompulsoryMessage(String lessonId, String lessonName, String creditScore, String compulsory, String message) throws JsonProcessingException {
        //Response'ı LessonPojo class'a çevirerek scenario outline'dan gelen data ile doğruluyorum:
        US08HistoryLessonPojo actualData = new ObjectMapper().readValue(response.asString(), US08HistoryLessonPojo.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(lessonId,actualData.getObject().getLessonId()+"");
        assertEquals(lessonName,actualData.getObject().getLessonName());
        assertEquals(creditScore,actualData.getObject().getCreditScore()+"");
        assertEquals(compulsory,actualData.getObject().getCompulsory());
        assertEquals(message,actualData.getMessage());
    }
}
