package stepDefinitions.dbStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.US_03_04.SametPage04;
import pojos.US04Pojo.US04PostPojo;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JDBCUtils;
import utilities.ReusableMethods;

import java.sql.*;
import java.util.List;

import static baseUrl.ManagementSchoolUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.JDBCUtils.execute;
import static utilities.JDBCUtils.executeQuery;

public class US04StepDefinitionDataBase {
    Connection connection;
    Statement statement;

    SametPage04 scholl=new SametPage04();
    ResultSet resultSet;
    Faker faker=new Faker();
    static String fakerUserName;
    static String fakePhoneNumber;
    static String fakerSsn;

    static US04PostPojo expectedData;
    static int userId;

    @And("Kullanici girer {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void kullaniciGirer(String name, String surname, String birthPlace, String phoneNumber, String gender, String birthday, String ssn, String username, String password) {
        // veriler arasında sistemin istediği unique olmasi gereken ssn phonenumber ve username de faker kullandık
        // o yüzden feature de ki verileri kullanmadık
        scholl.nameBox.sendKeys(name);
        scholl.surNameBox.sendKeys(surname);
        scholl.birthPlaceBox.sendKeys(birthPlace);
        // phoneNumber unique oldugu icin faker kullandık ve istenilen kaliba göre oluşturduk
        fakePhoneNumber=faker.number().numberBetween(100,999)+" "+ faker.number().numberBetween(100,999)+" "+faker.number().numberBetween(1000,9999);
        scholl.phoneNumberBox.sendKeys(fakePhoneNumber);
        scholl.maleRadioButton.click();
        scholl.birthDayBox.sendKeys(birthday);
        fakerSsn =faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        scholl.ssnBox.sendKeys(fakerSsn);
        fakerUserName=faker.name().username();
        scholl.userNameBox.sendKeys(fakerUserName);
        scholl.passwordBox.sendKeys(password);

        expectedData=new US04PostPojo("2012-12-12",birthPlace,gender,name,password,fakePhoneNumber,fakerSsn,surname,fakerUserName);
    }

    @Given("Kullanici ana sayfa {string} girer")
    public void kullaniciAnaSayfaGirer(String arg0) {
        Driver.getDriver().get(arg0);
    }

    @And("Kullanici User Name girer")
    public void kullaniciUserNameGirer() {
        scholl.userName.sendKeys("AdminSamet");
    }

    @And("Kullanici Password girer")
    public void kullaniciPasswordGirer() {
        scholl.password.sendKeys("Ab142790");
    }

    @And("Kullanici Login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        scholl.loginButton.click();
    }

    @And("Kullanici Menu tiklar")
    public void kullaniciMenuTiklar() {
        scholl.menuButon.click();
        ReusableMethods.waitFor(1);
    }

    @And("Kullanici Dean Management tiklar")
    public void kullaniciDeanManagementTiklar() {
        scholl.deanManagementButon.click();
        ReusableMethods.waitFor(2);
    }
    @And("Kullanici submit butonu tiklar")
    public void kullaniciSubmitButonuTiklar() {

        ReusableMethods.clickElementByJS(scholl.submitButon);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanici Dean Saved uyarisinin görünürlügünü test eder")
    public void kullaniciDeanSavedUyarisininGörünürlügünüTestEder() {
        //ReusableMethods.waitFor(1);
        Assert.assertTrue(scholl.alertMessage.getText().contains("Saved"));
    }

    @Given("Kullanici datebase baglantisini oluşturur Dean")
    public void kullaniciDatebaseBaglantisiniOluşturur() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM dean WHERE username = '" + fakerUserName + "'");
        resultSet.next();
    }




    @Given("Kullanici datebase baglantisini oluştururAdmin")
    public void kullaniciDatebaseBaglantisiniOluştururAdmin() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM admins WHERE username = '" + fakerUserName + "'");
        resultSet.next();
    }


    @Then("Kullanici dean datebase sorgulamasini gerceklestirir")
    public void kullaniciDeanDatebaseSorgulamasiniGerceklestirir() throws SQLException {
        Assert.assertEquals(expectedData.getSsn(),resultSet.getString("ssn"));
        Assert.assertEquals(expectedData.getSurname(),resultSet.getString("surname"));
        Assert.assertEquals(expectedData.getPhoneNumber(),resultSet.getString("phone_number"));
        Assert.assertEquals(expectedData.getBirthPlace(),resultSet.getString("birth_place"));
        Assert.assertEquals(expectedData.getName(),resultSet.getString("name"));
        Assert.assertEquals(expectedData.getUsername(),resultSet.getString("username"));
    }

    @Then("Kullanici username ile sorgulama yapar")
    public void kullaniciUsernameIleSorgulamaYapar() throws SQLException {
        Assert.assertEquals(expectedData.getName(),resultSet.getString("name"));
        Assert.assertEquals(expectedData.getUsername(),resultSet.getString("username"));
        Assert.assertEquals(expectedData.getSsn(),resultSet.getString("ssn"));
        Assert.assertEquals(expectedData.getSurname(),resultSet.getString("surname"));
        Assert.assertEquals(expectedData.getPhoneNumber(),resultSet.getString("phone_number"));
        Assert.assertEquals(expectedData.getBirthPlace(),resultSet.getString("birth_place"));
    }

    @Given("Kullanici ana sayfa url girer.")
    public void kullaniciAnaSayfaUrlGirer() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Given("Kullanici dean datasinin id sini api ile cagirir")
    public void kullaniciDeanDatasiniSiler() {
        spec.pathParams("1","dean","2","getAll");
        Response response=given(spec).when().get("{1}/{2}");
        JsonPath jsonPath=response.jsonPath();
        List<Integer> userIdList=jsonPath.getList("findAll{it.ssn=='"+fakerSsn+"'}.userId");
        userId=userIdList.get(0);

    }

    @Then("Kullanici dean datasini id ile siler")
    public void kullaniciDeanDatasiniIdIleSiler() {
        spec.pathParams("1","dean","2","delete","3",userId);
        given(spec).when().delete("{1}/{2}/{3}");

    }

}
