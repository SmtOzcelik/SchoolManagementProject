package stepDefinitions.apiStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US06Pojo.US06PostPojo;
import pojos.US06Pojo.US06ResponsePojo;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;


public class US06StepDefinitionApi {

    Faker faker = new Faker();
    private static String fakerUserName;
    private static String fakerSsn;
    private static String fakerPhoneNumber;
    private static US06PostPojo expectedData;
    private static Response response;
   // private static String isim;


    @Given("Kulllanici PathParam olusturur")
    public void kulllaniciPathParamOlusturur() {
        spec.pathParams("first", "vicedean", "second", "save");

    }

    @When("Kullanici expected data olusturur! password={string}, username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}")
    public void kullaniciExpectedDataOlustururPasswordUsernameNameSurnameBirthDaySsnBirthPlacePhoneNumberGender(String password, String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender) {
        fakerUserName = faker.name().username();
        fakerPhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        fakerSsn = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
        expectedData = new US06PostPojo(birthDay, birthPlace, gender, name, password, fakerPhoneNumber, fakerSsn, surname, fakerUserName);
        System.out.println("expectedData = " + expectedData);

        //isim=name;


    }

    @And("Kullanici requset gonderir ve response alir.")
    public void kullaniciRequsetGonderirVeResponseAlir() {
        response = given(spec).body(expectedData).when().post("{first}/{second}");

    }


    @Then("Kullanici dogrulama yapar.")
    public void kullaniciDogrulamaYapar() {
        US06ResponsePojo actualData = response.as(US06ResponsePojo.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getName(), actualData.getObject().getName());
        Assert.assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        Assert.assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        Assert.assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        Assert.assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        Assert.assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        Assert.assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        Assert.assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        Assert.assertEquals("Vice dean Saved", actualData.getMessage());


        /*
        JsonPath json=response.jsonPath();
        Assert.assertEquals("Salihh",json.getString("object.name"));
        Assert.assertEquals("Vice dean Saved",json.getString("message"));
        Assert.assertEquals(isim,actualData.getObject().getName());

         */
    }

    @Then("Kullanici dogrulama yapar.\\(negatif Test)")
    public void kullaniciDogrulamaYaparNegatifTest() {

        Assert.assertEquals(400,response.statusCode());



    }
}





