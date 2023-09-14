package stepDefinitions.apiStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US04Pojo.US04ResponsePojo;
import pojos.US22Pojo.US22PostPojo;
import pojos.US22Pojo.US22ResponsePojo;
import static io.restassured.RestAssured.given;

import static baseUrl.ManagementSchoolUrl.spec;


public class US22StepDefinitionApi {

    US22PostPojo expectedData;
    Response response;
    Faker faker=new Faker();
    US22ResponsePojo actualData;


    @Given("Kullanici path params olusturur.")
    public void kullaniciPathParamsOlustururUS() {
       spec.pathParams("1","admin","2","save");
    }

    @Then("Kullanici expected data olusturur")
    public void kullaniciExpectedDataOlustururUS() {
        String fakerPhoneNumber=faker.number().numberBetween(100,999)+" "+faker.number().numberBetween(100,999)+" "+faker.number().numberBetween(1000,9999);
        String fakerSnn=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        String fakerUserName=faker.name().username();
        expectedData=new US22PostPojo("2008-12-12","Karaman","true","MALE","samett","Ab142789",fakerPhoneNumber,fakerSnn,"teslime",fakerUserName);
        //System.out.println("expectedData = " + expectedData);
    }

    @When("Kullanici request gonderir ve response alir")
    public void kullaniciRequestGonderirVeResponseAlir() {
        response=given(spec).body(expectedData).when().post("{1}/{2}");
    }

    @And("Kullanici dogrulama yapar")
    public void kullaniciDogrulamaYapar() {
        actualData=response.as(US22ResponsePojo.class);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
        Assert.assertEquals(expectedData.getBirthPlace(),actualData.getObject().getBirthPlace());
        Assert.assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());
        Assert.assertEquals(expectedData.getName(),actualData.getObject().getName());
        Assert.assertEquals(expectedData.getGender(),actualData.getObject().getGender());
        Assert.assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
        Assert.assertEquals(expectedData.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        Assert.assertEquals(expectedData.getSurname(),actualData.getObject().getSurname());
        Assert.assertEquals("Admin Saved",actualData.getMessage());
    }

}
