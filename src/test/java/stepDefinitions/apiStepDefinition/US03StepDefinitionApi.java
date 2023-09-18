package stepDefinitions.apiStepDefinition;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US03Pojo.US03PostPojo;
import pojos.US03Pojo.US03ResponsePojo;
import pojos.US04Pojo.US04ResponsePojo;


import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;

public class US03StepDefinitionApi {
    static US03PostPojo expectedData;
    static Response response;
    static US03ResponsePojo actualData;

    @Given("Kullanici path params olusturur Contact")
    public void kullaniciPathParamsOlustururContactPozitif() {
        spec.pathParams("1","contactMessages","2","save");
    }

    @Then("Kullanici expected data olusturur {string} {string} {string} {string}")
    public void kullaniciExpectedDataOlusturur(String email, String message, String name, String subject) {
        expectedData=new US03PostPojo(email,message,name,subject);
    }

    @When("Kullanici request gonderir response alir Contact")
    public void kullaniciRequestGonderirResponseAlirContactPozitif() {
        response=given(spec).body(expectedData).when().post("{1}/{2}");


    }

    @And("Kullanici dogrulama yapar Contact Pozitif")
    public void kullaniciDogrulamaYaparContactPozitif() {
        actualData=response.as(US03ResponsePojo.class);
        Assert.assertEquals(expectedData.getMessage(),actualData.getObject().getMessage());
        Assert.assertEquals(expectedData.getName(),actualData.getObject().getName());
        Assert.assertEquals(expectedData.getEmail(),actualData.getObject().getEmail());
        Assert.assertEquals(expectedData.getSubject(),actualData.getObject().getSubject());
        Assert.assertEquals("Contact Message Created Successfully",actualData.getMessage());
    }

    @And("Kullanici dogrulama yapar Contact negatif")
    public void kullaniciDogrulamaYaparContactNegatif() {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals("Please enter valid email",jsonPath.getString("validations.email"));
        Assert.assertEquals(400,response.getStatusCode());
    }
}
