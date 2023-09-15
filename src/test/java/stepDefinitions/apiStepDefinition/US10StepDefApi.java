package stepDefinitions.apiStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.US10Pojo.US10_ViceDeanPostPojo;
import pojos.US10Pojo.US10_ViceDeanResponsePojo;

import java.util.Collections;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US10StepDefApi {
    US10_ViceDeanPostPojo expectedData;
    Response response;
    US10_ViceDeanResponsePojo actualData;
    public static int kayitliLessonProgramId;

    @Given("ders programi olusturmak icin POST request hazirligi yapilir.")
    public void dersProgramiOlusturmakIcinPOSTRequestHazirligiYapilir() {
        //Set the URL
        spec.pathParams("first", "lessonPrograms", "second", "save");
    }

    @And("gonderilecek ders programi bilgileri hazirlanir.")
    public void gonderilecekDersProgramiBilgileriHazirlanir() {
        expectedData = new US10_ViceDeanPostPojo("WEDNESDAY", "1",
                Collections.singletonList("5"), "16:00", "18:00");
    }

    @When("ders programi olusturmak icin POST request gonderilir.")
    public void dersProgramiOlusturmakIcinPOSTRequestGonderilir() {
        //Send the request
        response = given(spec).body(expectedData).when().post("{first}/{second}");
    }

    @Then("olusturulan ders programi bilgileri dogrulanir.")
    public void olusturulanDersProgramiBilgileriDogrulanir() {
        //Get the response and do assertion
        actualData = response.as(US10_ViceDeanResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getDay(), actualData.getObject().getDay());
        assertEquals("Created Lesson Program", actualData.getMessage());
        assertEquals("CREATED", actualData.getHttpStatus());
        kayitliLessonProgramId = actualData.getObject().getLessonProgramId();
    }
}
