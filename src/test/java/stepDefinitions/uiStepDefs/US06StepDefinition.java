package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.US05_06.SalihPages;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.io.IOException;

public class US06StepDefinition {
   public static SalihPages sManagement=new SalihPages();
    Faker faker=new Faker();
    public static String fakeSsn;

    @And("Kullanici username alanina tiklar ve {string} girer")
    public void kullaniciUsernameAlaninaTiklarVeGirer(String deanUserName) {
        sManagement.username.sendKeys(ConfigReader.getProperty(deanUserName));


    }

    @Then("Kullanici {string} {string} {string} {string} {string} {string} girer")
    public void kullaniciGirer(String name, String surname, String birthPlace, String gender, String birthDay, String Phone) {
        sManagement.ViceDeanName.sendKeys(faker.name().firstName(),Keys.TAB,faker.name().lastName()
        ,Keys.TAB,"Ankara",Keys.TAB);
        sManagement.ViceDeanGender.click();
        sManagement.ViceDeanDogumTarihi.sendKeys("01/02/2000",Keys.TAB,
                faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999),Keys.TAB);
        ReusableMethods.waitFor(5);

    }

    @And("Kullanici {string} girer. SSN; ucuncu ve besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.")
    public void kullaniciGirerSSNUcuncuVeBesinciRakamdanSonraIcermeliVeDokuzRakamdanOlusmalidir(String ViceDeanSSNnNo) {
         fakeSsn = faker.idNumber().ssnValid();
        sManagement.ViceDeanSSNnNo.sendKeys(fakeSsn,Keys.TAB);

    }


    @And("kullanici {string} girer")
    public void kullaniciGirer(String ViceDeanUserName) {
        sManagement.ViceDeanUserName.sendKeys(faker.name().username(),Keys.TAB);
    }

    @And("kullanici {string} girer.Password en az sekiz karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.")
    public void kullaniciGirerPasswordEnAzSekizKarakterdenOlusmalidirBuyukHarfKucukHarfVeBirRakamIcermelidir(String ViceDeanPassword) {
        sManagement.ViceDeanPassword.sendKeys(ConfigReader.getProperty("ViceDeanPassword"),Keys.TAB);

    }

    @And("Kullanici submit butona tiklar")
    public void kullaniciSubmitButonaTiklar() {
        ReusableMethods.clickElementByJS(sManagement.submitButton);
        ReusableMethods.waitFor(1);
    }

    @Then("Kullanici ekleme isleminin basarili olugunu dogrular")
    public void kullaniciEklemeIslemininBasariliOlugunuDogrular() {
        Assert.assertTrue(sManagement.alertMessage.getText().contains("Vice dean Saved"));

    }


    @Then("Kullanici Name Surname Birth Place Cinsiyet Dogum tarihi Tel No bos birakarak girer")
    public void kullaniciNameSurnameBirthPlaceCinsiyetDogumTarihiTelNoBosBirakarakGirer() {
        sManagement.ViceDeanName.sendKeys("",Keys.TAB,"",Keys.TAB,"",Keys.TAB,"",Keys.TAB,"",Keys.TAB,"",Keys.TAB);
    }

    @And("Kullanici ViceDeanSSNnNo  bos birakarak girer.")
    public void kullaniciViceDeanSSNnNoBosBirakarakGirer() {
        sManagement.ViceDeanSSNnNo.sendKeys("",Keys.TAB);
    }

    @And("kullanici ViceDeanUserName  bos birakarak girer")
    public void kullaniciViceDeanUserNameBosBirakarakGirer() {
        sManagement.ViceDeanUserName.sendKeys("",Keys.TAB);
    }

    @And("kullanici ViceDeanPassword  bos birakarak girer.")
    public void kullaniciViceDeanPasswordBosBirakarakGirer() {
        sManagement.ViceDeanPassword.sendKeys("");
    }

    @Then("Kullanici hata mesajinin ekran goruntusunu alir.")
    public void kullaniciHataMesajininEkranGoruntusunuAlir() throws IOException {
        ReusableMethods.jsExecutorScrool(sManagement.adminManagementDogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("sManagement.adminManagementDogrulama");

    }

    @Then("Kullanici hata aldigini dogrular ve ekran goruntusunu alir.")
    public void kullaniciHataAldiginiDogrularVeEkranGoruntusunuAlir() throws IOException {
        Assert.assertTrue(sManagement.ssnRequiredYazisi.isDisplayed());
        ReusableMethods.jsExecutorScrool(sManagement.adminManagementDogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("sManagement.adminManagementDogrulama");

    }

    @And("Kullanici {string} girer. SSN; ucuncu rakamdan sonra - icermeli besinci rakamdan sonra - icermemeli ve dokuz rakamdan olusmalidir.")
    public void kullaniciGirerSSNUcuncuRakamdanSonraIcermeliBesinciRakamdanSonraIcermemeliVeDokuzRakamdanOlusmalidir(String ViceDeanSSNnNo2) {
        sManagement.ViceDeanSSNnNo.sendKeys(ConfigReader.getProperty("ViceDeanSSNnNo2"));
    }

    @And("Kullanici {string} girer. SSN; ucuncu rakamdan sonra - icermemeli besinci rakamdan sonra - icermeli ve dokuz rakamdan olusmalidir.")
    public void kullaniciGirerSSNUcuncuRakamdanSonraIcermemeliBesinciRakamdanSonraIcermeliVeDokuzRakamdanOlusmalidir(String ViceDeanSSNnNo3) {
        sManagement.ViceDeanSSNnNo.sendKeys(ConfigReader.getProperty("ViceDeanSSNnNo3"));
    }

    @And("kullanici {string} girer.Password en az yedi karakterden olusmalidir,buyuk harf, kucuk harf ve bir rakam icermelidir.")
    public void kullaniciGirerPasswordEnAzYediKarakterdenOlusmalidirBuyukHarfKucukHarfVeBirRakamIcermelidir(String ViceDeanPasswordYedi) {
        sManagement.ViceDeanPassword.sendKeys(ConfigReader.getProperty("ViceDeanPasswordYedi"));
    }

    @Then("Kullanici at least eight yazisini gordugunu dogrular ve ekran goruntusunu alir.")
    public void kullaniciAtLeastEightYazisiniGordugunuDogrularVeEkranGoruntusunuAlir() throws IOException {
        Assert.assertTrue(sManagement.atLeastEightCharacters.isDisplayed());
        ReusableMethods.jsExecutorScrool(sManagement.adminManagementDogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("sManagement.adminManagementDogrulama");

    }

    @And("kullanici {string} girer.Password en az sekiz karakterden olusmalidir,buyuk harf icermemeli, kucuk harf ve bir rakam icermelidir.")
    public void kullaniciGirerPasswordEnAzSekizKarakterdenOlusmalidirBuyukHarfIcermemeliKucukHarfVeBirRakamIcermelidir(String ViceDeanPasswordBuyukHarfYok) {
        sManagement.ViceDeanPassword.sendKeys(ConfigReader.getProperty("ViceDeanPasswordBuyukHarfYok"));
    }

    @Then("Kullanici One uppercase character yazisini gordugunu dogrular ve ekran goruntusunu alir.")
    public void kullaniciOneUppercaseCharacterYazisiniGordugunuDogrularVeEkranGoruntusunuAlir() throws IOException {
        Assert.assertTrue(sManagement.atLeastEightCharacters.isDisplayed());
        ReusableMethods.jsExecutorScrool(sManagement.adminManagementDogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("sManagement.One uppercase character");
    }

    @And("kullanici {string} girer.Password en az sekiz karakterden olusmalidir,buyuk harf ve bir rakam icermelidir.kucuk harf icermemeli")
    public void kullaniciGirerPasswordEnAzSekizKarakterdenOlusmalidirBuyukHarfVeBirRakamIcermelidirKucukHarfIcermemeli(String ViceDeanPasswordKucukHarfYok) {
        sManagement.ViceDeanPassword.sendKeys(ConfigReader.getProperty("ViceDeanPasswordKucukHarfYok"));
    }

    @Then("Kullanici One lowercase character yazisini gordugunu dogrular ve ekran goruntusunu alir.")
    public void kullaniciOneLowercaseCharacterYazisiniGordugunuDogrularVeEkranGoruntusunuAlir() throws IOException {
        Assert.assertTrue(sManagement.atLeastEightCharacters.isDisplayed());
        ReusableMethods.jsExecutorScrool(sManagement.adminManagementDogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("sManagement.One lowercase character");
    }

    @And("kullanici {string} girer.Password en az sekiz karakterden olusmalidir,buyuk harf ve kucuk harf icermeli rakam icermemelidir.")
    public void kullaniciGirerPasswordEnAzSekizKarakterdenOlusmalidirBuyukHarfVeKucukHarfIcermeliRakamIcermemelidir(String ViceDeanPasswordRakamYok) {
        sManagement.ViceDeanPassword.sendKeys(ConfigReader.getProperty("ViceDeanPasswordRakamYok"));
    }

    @Then("Kullanici One number yazisini gordugunu dogrular ve ekran goruntusunu alir.")
    public void kullaniciOneNumberYazisiniGordugunuDogrularVeEkranGoruntusunuAlir() throws IOException {
        Assert.assertTrue(sManagement.atLeastEightCharacters.isDisplayed());
        ReusableMethods.jsExecutorScrool(sManagement.adminManagementDogrulama);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("sManagement.One Number");

    }
}
