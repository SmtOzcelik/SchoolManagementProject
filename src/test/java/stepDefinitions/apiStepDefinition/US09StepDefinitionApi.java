package stepDefinitions.apiStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US04Pojo.US04PostPojo;
import pojos.US04Pojo.US04ResponsePojo;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;

public class US09StepDefinitionApi {

    Faker faker=new Faker();
    Response response;
    US04PostPojo expectedData=new US04PostPojo();
    US04ResponsePojo actualDate;

    @Given("Kullanici path params olusturur")
    public void kullaniciPathParamsOlusturur() {

        spec.pathParams("1", "dean", "2", "save");

    }

    @And("Kullanici expected data olusturur.")
    public void kullaniciExpectedDataOlusturur() {
        expectedData.setBirthDay("2000-12-12");
        expectedData.setBirthPlace("karaman");
        expectedData.setGender("MALE");
        expectedData.setName("samet");
        expectedData.setPassword("Ab142799");
        String fakePhoneNumber=faker.number().numberBetween(100,999)+" "+ faker.number().numberBetween(100,999)+" "+faker.number().numberBetween(1000,9999);
        expectedData.setPhoneNumber(fakePhoneNumber);
        String fakerSsn =faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        expectedData.setSsn(fakerSsn);
        expectedData.setSurname("özçelik");
        String fakerUserName=faker.name().username();
        expectedData.setUsername(fakerUserName);


    }

    @When("Kullanici request gonderir response alir.")
    public void kullaniciRequestGonderirResponseAlir() {

        response = given(spec).body(expectedData).when().post("{1}/{2}");
        actualDate=response.as(US04ResponsePojo.class);


    }

    @And("Kullanici kayitlari dogrular.")
    public void kullaniciKayitlariDogrular() {
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(expectedData.getBirthDay(),actualDate.getObject().getBirthDay());
        Assert.assertEquals(expectedData.getBirthPlace(),actualDate.getObject().getBirthPlace());
        Assert.assertEquals(expectedData.getUsername(),actualDate.getObject().getUsername());
        Assert.assertEquals(expectedData.getName(),actualDate.getObject().getName());
        Assert.assertEquals(expectedData.getGender(),actualDate.getObject().getGender());
        Assert.assertEquals(expectedData.getSsn(),actualDate.getObject().getSsn());
        Assert.assertEquals(expectedData.getPhoneNumber(),actualDate.getObject().getPhoneNumber());
        Assert.assertEquals(expectedData.getSurname(),actualDate.getObject().getSurname());
        Assert.assertEquals("Dean Saved",actualDate.getMessage());
    }
}
