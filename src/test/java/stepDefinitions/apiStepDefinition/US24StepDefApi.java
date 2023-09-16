package stepDefinitions.apiStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.US24Pojo.US24AdminPostPojo;
import pojos.US24Pojo.US24ResponsePojo;

import java.util.Collections;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US24StepDefApi {
    US24AdminPostPojo expectedData;
    Response response;
    US24ResponsePojo actualData;
    Faker faker = new Faker();


    @Given("Ogretmen olusturmak icin POST request hazirligi yapilir.")
    public void ogretmenOlusturmakIcinPOSTRequestHazirligiYapilir() {
        //Set the URL
        spec.pathParams("first", "teachers", "second", "save");
    }

    @And("gonderilecek ogretmen bilgileri hazirlanir.")
    public void gonderilecekOgretmenBilgileriHazirlanir() {
        //Set the expected data
        expectedData = new US24AdminPostPojo("1997-12-09",
                faker.address().city(),
                faker.internet().emailAddress(), "MALE",
                true,
                Collections.singletonList("5"),
                faker.name().firstName(), faker.regexify("[A-Z][a-z]{1}[0-9]{6}"),
                faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}"),
                faker.regexify("[0-9]{3}-[0-9]{2}-[0-9]{4}"),
                faker.name().lastName(), faker.name().username());

    }

    @When("ogretmen olusturmak icin POST request gonderilir.")
    public void ogretmenOlusturmakIcinPOSTRequestGonderilir() {
        //Send the request
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
    }

    @Then("olusturulan ogretmen bilgileri dogrulanir.")
    public void olusturulanOgretmenBilgileriDogrulanir() {
        //Get the response and do assertion
        actualData = response.as(US24ResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getEmail(), actualData.getObject().getEmail());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.isIsAdvisorTeacher(), actualData.getObject().isAdvisorTeacher());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals("Teacher saved successfully", actualData.getMessage());
        assertEquals("CREATED", actualData.getHttpStatus());


    }
}
