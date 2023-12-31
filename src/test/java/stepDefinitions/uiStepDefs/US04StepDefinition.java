package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.US_03_04.SametPage04;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class US04StepDefinition {

    SametPage04 scholl =new SametPage04();
    Faker faker=new Faker();
    Actions actions=new Actions(Driver.getDriver());

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


    @And("Kullanici Name {string} girer")
    public void kullaniciNameGirer(String arg0) {
        scholl.nameBox.sendKeys(arg0);
    }

    @And("Kullanici  Surname {string} girer")
    public void kullaniciSurnameGirer(String arg0) {
        scholl.surNameBox.sendKeys(arg0);
    }

    @And("Kullanici Birth Place {string} girer")
    public void kullaniciBirthPlaceGirer(String arg0) {
        scholl.birthPlaceBox.sendKeys(arg0);
    }

    @And("Kullanici Gender tiklar")
    public void kullaniciGenderTiklar() {
        scholl.maleRadioButton.click();
    }

    @And("Kullanici Date Of Birth {string} girer")
    public void kullaniciDateOfBirthGirer(String arg0) {
        scholl.birthDayBox.sendKeys(arg0);
    }

    @And("Kullanici  gecerli Phone numarasi girer")
    public void kullaniciGecerliPhoneNumarasiGirer() {
        String fakePhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        scholl.phoneNumberBox.sendKeys(fakePhoneNumber);
    }

    @And("Kullanici gecerli Ssn numarasi girer")
    public void kullaniciGecerliSsnNumarasiGirer() {
        String fakeSsn = faker.idNumber().ssnValid();
        scholl.ssnBox.sendKeys(fakeSsn);
    }

    @And("Kullanici Name girer")
    public void kullaniciNameGirer() {

        String fakeUsername = faker.name().username();
        scholl.userNameBox.sendKeys(fakeUsername);

    }

    @And("Kullanici gecerli Password {string} girer")
    public void kullaniciPasswordGirer(String arg0) {
        scholl.passwordBox.sendKeys(arg0);
    }

    @And("Kullanici submit butonu tiklar")
    public void kullaniciSubmitButonuTiklar() {

        ReusableMethods.clickElementByJS(scholl.submitButon);
        ReusableMethods.waitFor(1);
    }

    @And("Kullanici  gecersiz eksik {string}Phone numarasi girer")
    public void kullaniciGecersizEksikPhoneNumarasiGirer(String arg0) {
        scholl.phoneNumberBox.sendKeys(arg0);
    }

    @And("Kullanici hatali phone number den dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliPhoneNumberDanDolayiGirisYapilamadiginiDogrular() {

        Driver.scrollTopJS();
        actions.doubleClick(scholl.phoneNumberBox);
        Assert.assertTrue(scholl.hataliPhoneNumberUyariText.getText().contains("Minimum"));
    }

    @And("Kullanici Please enter valid phone uyarisinin gorunurlugunu test eder")
    public void kullaniciPleaseEnterValidPhoneUyarisininGorunurlugunuTestEder() {
        ReusableMethods.waitForVisibility(scholl.alertMessage, 5);
        assertTrue(scholl.alertMessage.getText().contains("valid"));
    }

    @And("Kullanici gecersiz eksik {string} Ssn numarisi girer")
    public void kullaniciGecersizEksikSsnNumarisiGirer(String arg0) {
        scholl.ssnBox.sendKeys(arg0);
    }

    @And("Kullanici gecersiz {string} Ssn numarisi girer")
    public void kullaniciGecersizSsnNumarisiGirer(String arg0) {
        scholl.ssnBox.sendKeys(arg0);
    }

    @And("Kullanici Please enter valid Ssn uyarisinin gorunurlugunu test eder")
    public void kullaniciPleaseEnterValidSsnUyarisininGorunurlugunuTestEder() {
        ReusableMethods.waitForVisibility(scholl.alertMessage, 5);
        assertTrue(scholl.alertMessage.getText().contains("valid"));
    }

    @And("Kullanici gecersiz eksik {string} password girer")
    public void kullaniciGecersizEksikPasswordGirer(String arg0) {
        scholl.passwordBox.sendKeys(arg0);
    }

    @And("Kullanici hatali Ssn number den dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliSsnNumberDenDolayiGirisYapilamadiginiDogrular() {
        Driver.scrollTopJS();
        actions.doubleClick(scholl.ssnBox);
        Assert.assertTrue(scholl.hataliSsnNumberUyariText.getText().contains("Minimum"));

    }

    @And("Kullanici hatali eksik password den dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliPasswordDenDolayiGirisYapilamadiginiDogrular() {
        Driver.scrollTopJS();
        actions.doubleClick(scholl.passwordBox);
        Assert.assertTrue(scholl.hataliPasswordUyariEksikElemanText.getText().contains("At least 8 characters"));
    }

    @And("Kullanici hatali password buyuk harf olmadıgından dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliPasswordBuyuhHarfOlmadıgındanDolayiGirisYapilamadiginiDogrular() {
        Driver.scrollTopJS();
        actions.doubleClick(scholl.passwordBox);
        Assert.assertTrue(scholl.hataliPasswordUyariBuyukHarfYokText.getText().contains("One uppercase character"));
    }

    @And("Kullanici hatali password kucuk harf olmadıgından dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliPasswordKucukHarfOlmadıgındanDolayiGirisYapilamadiginiDogrular() {
        Driver.scrollTopJS();
        actions.doubleClick(scholl.phoneNumberBox);
        Assert.assertTrue(scholl.hataliPasswordUyariKucukHarfYokText.getText().contains("One lowercase character"));
    }

    @And("Kullanici hatali password kucuk ve buyuk harf olmadıgından dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliPasswordKucukVeBuyukHarfOlmadıgındanDolayiGirisYapilamadiginiDogrular() {
        Driver.scrollTopJS();
        actions.doubleClick(scholl.phoneNumberBox);
        Assert.assertTrue(scholl.hataliPasswordUyariKucukHarfYokText.getText().contains("One lowercase character"));
    }

    @And("Kullanici hatali password rakam olmadıgından dolayi giris yapilamadigini dogrular")
    public void kullaniciHataliPasswordRakamOlmadıgındanDolayiGirisYapilamadiginiDogrular() {
        Driver.scrollTopJS();
        actions.doubleClick(scholl.phoneNumberBox);
        Assert.assertTrue(scholl.hataliPasswordUyariNumberYokText.getText().contains("One number"));
    }


}
