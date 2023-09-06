package stepDefinitions.dbStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US_03_04.SametPage04;
import utilities.Driver;
import utilities.JDBCUtils;
import utilities.ReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

import static utilities.JDBCUtils.execute;
import static utilities.JDBCUtils.executeQuery;

public class US04StepDefinitionDataBase {
    SametPage04 scholl=new SametPage04();
    ResultSet resultSet;
    Faker faker=new Faker();
    String fakerUserName;
    String fakePhoneNumber;
    String fakerSsn;

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
    }

    @Given("Kullanici ana sayfa {string} girer")
    public void kullaniciAnaSayfaGirer(String arg0) {
        Driver.getDriver().get(arg0);
    }
    @Then("Kullanici Login  tiklar")
    public void kullaniciLoginTiklar() {
        ReusableMethods.clickElementByJS(scholl.anasayfaLogin);
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

    @Given("Kullanici datebase baglantisini oluşturur")
    public void kullaniciDatebaseBaglantisiniOluşturur() {
        //executeQuery() metodu ile aşağıda query hem gönderip hemde bağlantıyı aynı anda sağlıyoruz
    }

    @Then("Kullanici datebase e query gonderir ve username ile alır")
    public void kullaniciDatebaseEQueryGonderirVeUsernameIleAlır() throws SQLException {

        String query="select * from guest_user where username ='"+fakerUserName+"'";

        // query dönüyor mu kontrol amaçlı execute(query) kullanilabilir true ya da false döner
        System.out.println("query dönüyor mu ? "+execute(query));


        resultSet=executeQuery(query);
        System.out.println("aaaaaaaaaaa"+resultSet);

    }

    @And("Kullanici dogrulamalırı {string},{string},{string},{string},{string},{string},{string},{string},{string} gercekleştirir")
    public void kullaniciDogrulamalırıGercekleştirir(String name, String surname, String birthPlace, String phoneNumber, String gender, String birthday, String ssn, String username, String password) throws SQLException {

        resultSet.next();
        String actualName=resultSet.getString("name");
        System.out.println("actualName = " + actualName);
        String actualSurname=resultSet.getString("surname");
        String actualBirthPlace=resultSet.getString("birthPlace");
        String actualPhoneNumber=resultSet.getString("phoneNumber");
        String actualGender=resultSet.getString("gender");
        String actualBirthday=resultSet.getString("birthday");
        String actualSsn=resultSet.getString("ssn");
        String actualUserName=resultSet.getString("username");
        String actualPassword=resultSet.getString("password");

        Assert.assertEquals(name,actualName);
        Assert.assertEquals(surname,actualSurname);
        Assert.assertEquals(birthPlace,actualBirthPlace);
        Assert.assertEquals(fakePhoneNumber,actualPhoneNumber);
        Assert.assertEquals(gender,actualGender);
        Assert.assertEquals(birthday,actualBirthday);
        Assert.assertEquals(fakerSsn,actualSsn);
        Assert.assertEquals(fakerUserName,actualUserName);
        Assert.assertEquals(password,actualPassword);

    }
}
