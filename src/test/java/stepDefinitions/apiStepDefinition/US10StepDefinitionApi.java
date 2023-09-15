package stepDefinitions.apiStepDefinition;

import baseUrl.ManagementSchoolUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.US10Pojo.US10_ViceDeanResponsePojo;
import pojos.US10Pojo.US10_ViceDeanPostPojo;
import static baseUrl.ManagementSchoolUrl.spec;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class US10StepDefinitionApi {
    US10_ViceDeanPostPojo expectedData;
    Response response;
    US10_ViceDeanResponsePojo actualData;
    public static int kayitliLessonProgramId;


    @Given("ders programi olusturmak icin POST request hazirligi yapilir")
    public void dersProgramiOlusturmakIcinPOSTRequestHazirligiYapilir() {
        //Set the URL
        spec.pathParams("first", "lessonPrograms", "second", "save");
    }

    @And("gonderilecek ders programi bilgileri hazirlanir")
    public void gonderilecekDersProgramiBilgileriHazirlanir() {
        /*
        {
    "day": "WEDNESDAY",
    "educationTermId": "1",
    "lessonIdList": [
        "5"
    ],
    "startTime": "16:00",
    "stopTime": "18:00"
}
         */
        //Set the expected data
        expectedData = new US10_ViceDeanPostPojo("WEDNESDAY", "1",
                Collections.singletonList("5"), "16:00", "18:00");
    }

    @When("ders programi olusturmak icin POST request gonderilir")
    public void dersProgramiOlusturmakIcinPOSTRequestGonderilir() {
        //Send the request
        response = given(spec).body(expectedData).when().post("{first}/{second}");
    }

    @Then("olusturulan ders programi bilgileri dogrulanir")
    public void olusturulanDersProgramiBilgileriDogrulanir() {
        //Get the response and do assertion
        actualData = response.as(US10_ViceDeanResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getDay(), actualData.getObject().getDay());
        assertEquals("Created Lesson Program", actualData.getMessage());
        assertEquals("CREATED", actualData.getHttpStatus());
        kayitliLessonProgramId = actualData.getObject().getLessonProgramId();
    }


    /*
    {
    "object": {
        "lessonProgramId": 693,
        "startTime": "16:00:00",
        "stopTime": "18:00:00",
        "lessonName": [
            {
                "lessonId": 5,
                "lessonName": "Java",
                "creditScore": 16,
                "compulsory": true
            }
        ],
        "day": "WEDNESDAY"
    },
    "message": "Created Lesson Program",
    "httpStatus": "CREATED"
}
     */






    /*
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
     */
}
