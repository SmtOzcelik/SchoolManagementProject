package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.US05_06.SalihPages;
import pages.US07_08.ErolPages;
import pojos.US08_E2EPojo.ObjectPojo;
import pojos.US08_E2EPojo.US08E2EPojo;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.List;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US08_E2EStepDef {
    SalihPages sManagement = new SalihPages();
    ErolPages erolPages = new ErolPages();

    US08E2EPojo actualData;
    US08E2EPojo expectedData;
    public static String firstName;
    public static String lastName;
    public static String phoneNumber;

    public static  String userName;

    Faker faker = new Faker();
    Response response;
    String name;
    public static  String fakeSsn;
    public static int userId;

    @Then("User enters {string} {string} {string} {string} {string} {string}")
    public void userEnters(String name, String surname, String birthPlace, String gender, String birthDay, String Phone) {
        firstName = faker.name().firstName();
        System.out.println("name = " + name);
        lastName = faker.name().lastName();
        System.out.println("name = " + name);
        phoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        System.out.println("name = " + name);
        sManagement.ViceDeanName.sendKeys(firstName, Keys.TAB, lastName, Keys.TAB, "Ankara", Keys.TAB);
        sManagement.ViceDeanGender.click();
        sManagement.ViceDeanDogumTarihi.sendKeys("01/02/2000", Keys.TAB, phoneNumber, Keys.TAB);
        ReusableMethods.waitFor(5);
    }

    @And("User enters {string} {string} {string}")
    public void userEnters(String ViceDeanSSNnNo, String ViceDeanUserName, String ViceDeanPassword) {
        fakeSsn = faker.idNumber().ssnValid();
        System.out.println("ViceDeanSSNnNo = " + ViceDeanSSNnNo);
        sManagement.ViceDeanSSNnNo.sendKeys(fakeSsn, Keys.TAB);
        userName = faker.name().firstName();
        System.out.println("ViceDeanSSNnNo = " + ViceDeanSSNnNo);

        sManagement.ViceDeanUserName.sendKeys(userName, Keys.TAB);

        sManagement.ViceDeanPassword.sendKeys(ConfigReader.getProperty("ViceDeanPassword"), Keys.TAB);
    }


    @And("User clicks submit buttton")
    public void userClicksSubmitButtton() {
        ReusableMethods.clickElementByJS(sManagement.submitButton);
        ReusableMethods.waitFor(1);
    }

    @Then("User verifies that viceDean is created")
    public void userVerifiesThatViceDeanIsCreated() {
        Assert.assertTrue(erolPages.viceDeanSaved.isDisplayed());
    }

    @Given("Get the ID number of the registered viceDean data")
    public void getTheIDNumberOfTheRegisteredViceDeanData() {
        spec.pathParams("first", "vicedean", "second", "getAll");
        Response response = given(spec).when().get("{first}/{second}");

        JsonPath jsonPath = response.jsonPath();
        List<Integer> userIdList = jsonPath.getList("findAll{it.ssn=='" + fakeSsn + "'}.userId");
        userId = userIdList.get(0);
    }

    @And("ViceDean's data is prepared")
    public void vicedeanSDataIsPrepared() {
        ObjectPojo object = new ObjectPojo(userId, userName, firstName, lastName, "2000-02-01", fakeSsn, "Ankara", phoneNumber, "MALE");
        expectedData = new US08E2EPojo(object, "Vice dean successfully found", "OK");
    }


    @And("The registered {string} is called with ID number")
    public void theRegisteredIsCalledWithIDNumber(String arg0) {
        spec.pathParams("first", "vicedean", "second", "getViceDeanById", "third", userId);
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
        actualData = response.as(US08E2EPojo.class);
    }

    @Then("Verify registered viceDean information")
    public void verifyRegisteredViceDeanInformation() {
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getObject().getUsername(), actualData.getObject().getUsername());
        assertEquals(expectedData.getObject().getName(), actualData.getObject().getName());
        assertEquals(expectedData.getObject().getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getObject().getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getObject().getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getObject().getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getObject().getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getObject().getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getMessage(), actualData.getMessage());
        assertEquals(expectedData.getHttpStatus(), actualData.getHttpStatus());
    }
}
