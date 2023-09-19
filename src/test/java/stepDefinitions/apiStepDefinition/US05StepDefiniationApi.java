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

import java.util.List;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;

public class US05StepDefiniationApi {


    @Given("Kullanici kayitli dean verilerinin ID numaralarini alir ve dean verilerinin oldugunu dogrular")
    public void kullaniciKayitliDeanVerilerininIDNumaralariniAlirVeDeanVerilerininOldugunuDogrular() {
        spec.pathParams("first", "dean", "second", "getAll");
       Response response = given(spec).when().get("{first}/{second}");

        JsonPath json = response.jsonPath();
        List<Integer> userIdList = json.getList("findAll{it.ssn}.userId");
        //System.out.println("userIdList = " + userIdList);

        Assert.assertTrue(userIdList.size() != 0);

    }
    Faker faker = new Faker();

    private static US06PostPojo expectedData;
    private static Response response;
    private static String fakerPhoneNumber;

    @Given("Kullanici path params olusturur..")
    public void kullaniciPathParamsOlusturur() {
        spec.pathParams("first", "dean", "second", "update","third",176);

    }

    @And("Kullanici expected data olusturur.{string}, username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}")
    public void kullaniciExpectedDataOlustururUsernameNameSurnameBirthDaySsnBirthPlacePhoneNumberGender(String password, String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender) {
        fakerPhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        expectedData = new US06PostPojo(birthDay, birthPlace, gender, name, password,fakerPhoneNumber,ssn,surname,username);

    }

    @And("kullanici request gonderir ve response alir")
    public void kullaniciRequestGonderirVeResponseAlir() {
        response = given(spec).body(expectedData).when().put("{first}/{second}/{third}");
    }

    @Then("Kullanici dogrulama yapar..")
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
        Assert.assertEquals("Dean updated Successful", actualData.getMessage());

    }
}
