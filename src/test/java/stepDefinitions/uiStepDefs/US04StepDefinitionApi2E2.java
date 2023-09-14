package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.US_03_04.SametPage04;
import pojos.US04Pojo.US04PostPojo;
import pojos.US04Pojo.US04ResponsePojo;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.*;
import java.util.List;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;

public class US04StepDefinitionApi2E2 {
    Faker faker=new Faker();
    SametPage04 scholl=new SametPage04();
    private static String fakerPhoneNumber;
    private static String fakerSsn;

    private static String fakerUserName;
    static int userId;

    @And("Kullanici verileri girer {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciGirer(String name, String surname, String birthPlace, String phoneNumber, String gender, String birthday, String ssn, String username, String password) {
        // veriler arasında sistemin istediği unique olmasi gereken ssn phonenumber ve username de faker kullandık
        // o yüzden feature de ki verileri kullanmadık
        scholl.nameBox.sendKeys(name);
        scholl.surNameBox.sendKeys(surname);
        scholl.birthPlaceBox.sendKeys(birthPlace);
        // phoneNumber unique oldugu icin faker kullandık ve istenilen kaliba göre oluşturduk
        fakerPhoneNumber=faker.number().numberBetween(100,999)+" "+ faker.number().numberBetween(100,999)+" "+faker.number().numberBetween(1000,9999);
        scholl.phoneNumberBox.sendKeys(fakerPhoneNumber);
        scholl.maleRadioButton.click();
        scholl.birthDayBox.sendKeys(birthday);
        fakerSsn =faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        scholl.ssnBox.sendKeys(fakerSsn);
        fakerUserName=faker.name().username();
        scholl.userNameBox.sendKeys(fakerUserName);
        scholl.passwordBox.sendKeys(password);
    }

    @Given("Kullanici ana sayfa url girer")
    public void kullaniciAnaSayfaUrlGirer() {
        Driver.getDriver().get("https://managementonschools.com/");
    }

    @Given("Kullanici kayitli dean verisinin ID numarasini alir")
    public void kullaniciKayitliDeanVerisininIDNumarasiniAlir() {
        spec.pathParams("1","dean","2","getAll");
        Response response=given(spec).when().get("{1}/{2}");
        JsonPath jsonPath=response.jsonPath();
        List<Integer>userIdList=jsonPath.getList("findAll{it.ssn=='"+fakerSsn+"'}.userId");
        userId=userIdList.get(0);

    }
    US04ResponsePojo actualData;
    @Then("Kullanici dean verilerini hazirlar ve ID ile cagirilir")
    public void kullaniciDeanVerileriniHazirlar() {
        spec.pathParams("1","dean","2","getManagerById","3",userId);
        Response response=given(spec).when().get("{1}/{2}/{3}");
        actualData=response.as(US04ResponsePojo.class);
    }

     static US04PostPojo expectedData;
    @And("Kullanici dean bilgilerini dogrular")
    public void kullaniciDeanBilgileriniDogrular() {
        // Pojo class kullanarak dogrulama yapildi.
        expectedData=new US04PostPojo("2012-12-12","canakkale","MALE","samet","Ab142700",fakerPhoneNumber,fakerSsn,"ozcelik",fakerUserName);
        Assert.assertEquals(expectedData.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        Assert.assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
        Assert.assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());
        Assert.assertEquals(expectedData.getGender(),actualData.getObject().getGender());
        Assert.assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
        Assert.assertEquals(expectedData.getBirthPlace(),actualData.getObject().getBirthPlace());

        // expected data kullanmadan yapilan eşleştirme
        Assert.assertEquals(fakerPhoneNumber,actualData.getObject().getPhoneNumber());
        Assert.assertEquals(fakerSsn,actualData.getObject().getSsn());
        Assert.assertEquals(fakerUserName,actualData.getObject().getUsername());
        Assert.assertEquals("samet",actualData.getObject().getName());
        Assert.assertEquals("ozcelik",actualData.getObject().getSurname());
        Assert.assertEquals("MALE",actualData.getObject().getGender());
        Assert.assertEquals("canakkale",actualData.getObject().getBirthPlace());
        //System.out.println("actualData = " + actualData);
        Assert.assertEquals("Dean successfully found",actualData.getMessage());

    }
        Connection connection;
        Statement statement;
        ResultSet resultSet;

    @Given("Kullanici kayitli dean ID ile sorgulanir")
    public void kullaniciKayitliDeanIDIleSorgulanir() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        statement=connection.createStatement();
        resultSet=statement.executeQuery("select * from dean where id="+userId+"");
        resultSet.next();
    }

    @Then("Kullanici dean bilgilerini dogrular DB")
    public void kullaniciDeanBilgileriniDogrularDB() throws SQLException {
        //getString değerleri icin tabloda ki oluşturma şekline göre yazdik
        Assert.assertEquals(expectedData.getUsername(),resultSet.getString("username"));
        Assert.assertEquals(expectedData.getName(),resultSet.getString("name"));
        Assert.assertEquals(expectedData.getSurname(),resultSet.getString("surname"));
        Assert.assertEquals(expectedData.getBirthDay(),resultSet.getString("birth_day"));
        Assert.assertEquals(expectedData.getSsn(),resultSet.getString("ssn"));
        Assert.assertEquals(expectedData.getBirthPlace(),resultSet.getString("birth_place"));
        Assert.assertEquals(0,resultSet.getInt("gender"));// gender i 0 ve 1 olarak aldığı icin
        // expected 0 yaptık ve getInt olarak cağırdık
    }

    @Given("Kullanici dean verisini siler")
    public void kullaniciDeanVerisiniSiler() {
        spec.pathParams("1","dean","2","delete","3",userId);
        given(spec).when().delete("{1}/{2}/{3}");
    }
}
