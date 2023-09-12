package stepDefinitions.apiStepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.US23Pojo.ViceDeanInfoPojo;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US23ApiStepDefss {
    Response response;
    @Given("Take ViceDean that is created with get request {string}")
    public void takeViceDeanThatIsCreatedWithGetRequest(String id) {
        //{{baseUrl}}/vicedean/getViceDeanById/469
        spec.pathParams("first","vicedean","second","getViceDeanById","third",Integer.valueOf(id));
        response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();
    }

    @Then("Verify ViceDean information : userId={string}, username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}")
    public void verifyViceDeanInformationUserIdUsernameNameSurnameBirthDaySsnBirthPlacePhoneNumberGender(String userId, String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender) throws JsonProcessingException {
        ViceDeanInfoPojo actualData = new ObjectMapper().readValue(response.asString(), ViceDeanInfoPojo.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(userId, actualData.getObject().getUserId()+"");
        assertEquals(username, actualData.getObject().getUsername());
        assertEquals(name, actualData.getObject().getName());
        assertEquals(surname, actualData.getObject().getSurname());
        assertEquals(birthDay, actualData.getObject().getBirthDay());
        assertEquals(ssn, actualData.getObject().getSsn());
        assertEquals(birthPlace, actualData.getObject().getBirthPlace());
        assertEquals(phoneNumber, actualData.getObject().getPhoneNumber());
        assertEquals(gender, actualData.getObject().getGender());

    }
}
