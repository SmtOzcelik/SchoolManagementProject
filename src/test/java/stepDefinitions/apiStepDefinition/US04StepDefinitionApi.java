package stepDefinitions.apiStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.US04Pojo.US04Dean_User_Pojo;
import utilities.ConfigReader;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;


public class US04StepDefinitionApi {
    RequestSpecification spec;
    Faker faker=new Faker();
    Response response;
    US04Dean_User_Pojo expectedData=new US04Dean_User_Pojo();

    @Given("Kullanici path params olusturur")
    public void kullaniciPathParamsOlusturur() {

        spec = new RequestSpecBuilder().setBaseUri("https://managementonschools.com/app").build();
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
        response = given().spec(spec).contentType(ContentType.JSON).
                header("Authorization",generateToken(ConfigReader.getProperty("usernameAdmin"), ConfigReader.getProperty("password"))).
                body(expectedData).post("/{1}/{2}");
    }

    @And("Kullanici kayitlari dogrular.")
    public void kullaniciKayitlariDogrular() {
        //response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        US04Dean_User_Pojo actualData=response.as(US04Dean_User_Pojo.class);
        System.out.println("actualData = " + actualData);

    }
}
