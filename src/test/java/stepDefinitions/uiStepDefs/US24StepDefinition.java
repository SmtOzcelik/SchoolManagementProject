package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.US_9_10_24.BahadirPage;
import utilities.Driver;
import utilities.Methods;
import utilities.ReusableMethods;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class US24StepDefinition {
    BahadirPage bahadir = new BahadirPage();
    Actions actions = new Actions(Driver.getDriver());
    Methods methods = new Methods();
    Faker faker = new Faker();
    SoftAssert softAssert = new SoftAssert();

    @Then("Kullanici Teacher Management yazisina tiklar")
    public void kullaniciTeacherManagementYazisinaTiklar() {
        ReusableMethods.clickWithJS(bahadir.teacherManagement);
        ReusableMethods.waitFor(3);
    }

    @Then("Kullanici Choose Lessons'dan herhangi bir ders secer")
    public void kullaniciChooseLessonsDanHerhangiBirDersSecer() {
        bahadir.name.sendKeys(Keys.SHIFT, Keys.TAB);
        actions.click(bahadir.selectLesson).perform();
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
    }

    @Then("kullanici Add Teacher formu doldurur")
    public void kullaniciAddTeacherFormuDoldurur() {
        methods.teacheradd(faker.name().name(),
                faker.name().lastName(), faker.address().city(),
                faker.internet().emailAddress(),
                faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}"),
                faker.demographic().sex(),
                "15.06.2015",
                faker.regexify("[0-9]{3}-[0-9]{2}-[0-9]{4}"),
                faker.name().username(),
                faker.regexify("[A-Z][a-z]{1}[0-9]{6}"));
    }


    @And("kullanici {string} {string} {string} {string}{string} {string} {string} {string} {string} {string} bilgilerini girer")
    public void kullaniciBilgileriniGirer(String name, String surname, String birthPlace, String email, String phone, String gender, String dateOfBirth, String ssn, String userName, String password) {
        bahadir.name.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB,
                email, Keys.TAB, phone, Keys.TAB, Keys.TAB, gender, Keys.TAB,
                dateOfBirth, Keys.TAB, ssn, Keys.TAB, userName, Keys.TAB, password);
        ReusableMethods.clickElementByJS(bahadir.male);
        bahadir.birthday.sendKeys(dateOfBirth, Keys.TAB, ssn, Keys.TAB, userName, Keys.TAB, password);
    }


    @And("kullanici  bos birakilan Surname alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanSurnameAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.surnameRequired.getText());
    }


    @And("kullanici  bos birakilan Birth Place alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanBirthPlaceAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.birtPlaceRequired.getText());
    }


    @And("kullanici  bos birakilan Email alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanEmailAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.emailRequired.getText());
    }

    @And("kullanici  bos birakilan Phone Number alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanPhoneNumberAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.phoneRequired.getText());
    }

    @And("kullanici  bos birakilan Date Of Birth alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanDateOfBirthAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.dateBirthRequired.getText());

    }

    @And("kullanici  bos birakilan SSN alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanSSNAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.ssnRequired.getText());
    }

    @And("kullanici  bos birakilan name alaninda Required uyari yazisi geldigini dogrular")
    public void kullaniciBosBirakilanNameAlanindaRequiredUyariYazisiGeldiginiDogrular() {
        Assert.assertEquals("Required", bahadir.nameRequired.getText());

    }

    @Then("Kullanici LogOut'a tiklar")
    public void kullaniciLogOutATiklar() {
        ReusableMethods.clickElementByJS(bahadir.logOut);
    }

    @Then("Kullanici Yes'e tiklar ve cikis yapar")
    public void kullaniciYesETiklarVeCikisYapar() {
        ReusableMethods.clickElementByJS(bahadir.yesButton);
    }

    @Then("Required yazisini dogrula \\(Name)")
    public void requiredYazisiniDogrulaName() {
        assertTrue(bahadir.nameRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(Surname)")
    public void requiredYazisiniDogrulaSurname() {
        assertTrue(bahadir.surnameRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(Birth Place)")
    public void requiredYazisiniDogrulaBirthPlace() {
        assertTrue(bahadir.birtPlaceRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(Email )")
    public void requiredYazisiniDogrulaEmail() {
        assertTrue(bahadir.emailRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(Phone Number)")
    public void requiredYazisiniDogrulaPhoneNumber() {
        assertTrue(bahadir.phoneRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(Date Of Birth)")
    public void requiredYazisiniDogrulaDateOfBirth() {
        assertTrue(bahadir.dateBirthRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(Ssn )")
    public void requiredYazisiniDogrulaSsn() {
        assertTrue(bahadir.ssnRequired.isDisplayed());
    }

    @Then("Required yazisini dogrula \\(UserName)")
    public void requiredYazisiniDogrulaUserName() {
        assertTrue(bahadir.userNameRequired.isDisplayed());
    }

    @Then("Enter your password yazisini dogrula")
    public void enterYourPasswordYazisiniDogrula() {
        assertTrue(bahadir.passwordemassege.isDisplayed());
    }

    @Then("Name girilir.")
    public void nameGirilir() {
        bahadir.name.sendKeys("ayda");
        ReusableMethods.waitFor(2);
    }

    @Then("Surname girilir.")
    public void surnameGirilir() {
        bahadir.surname.sendKeys("hilal");
        ReusableMethods.waitFor(2);
    }

    @Then("Birth place girilir.")
    public void birthPlaceGirilir() {
        bahadir.birthPlace.sendKeys("NewYork");
        ReusableMethods.waitFor(2);
    }

    @Then("Geçerli telefon numarası girilir.")
    public void geçerliTelefonNumarasıGirilir() {
        bahadir.phone.sendKeys("124-980-6000");
        ReusableMethods.waitFor(2);
    }

    @Then("Cinsiyet seçilmez.")
    public void cinsiyetSeçilmez() {
        assertFalse(bahadir.female.isSelected());
        ReusableMethods.waitFor(2);
    }

    @Then("Doğum tarihi girilir.")
    public void doğumTarihiGirilir() {
        bahadir.birthday.sendKeys("12.12.2000");
        ReusableMethods.waitFor(2);
    }

    @Then("Geçerli SSN girilir.")
    public void geçerliSSNGirilir() {
        bahadir.ssn.sendKeys("287-21-2139");
        ReusableMethods.waitFor(2);
    }

    @Then("Username girilir.")
    public void usernameGirilir() {
        bahadir.username.sendKeys("denemeUsername");
        ReusableMethods.waitFor(2);
    }

    @Then("Geçerli password girilir.")
    public void geçerliPasswordGirilir() {
        bahadir.password.sendKeys("Aa123456");
        ReusableMethods.waitFor(2);
    }


    @Then("Geçerli e-mail girilir.")
    public void geçerliEMailGirilir() {
        bahadir.email.sendKeys("deneme123@gmail.com");
        ReusableMethods.waitFor(2);
    }

    @Then("ogretmenin danismanligi Is Advisor Teacher a tiklanarak secilir.")
    public void ogretmeninDanismanligiIsAdvisorTeacherATiklanarakSecilir() {
        bahadir.isAdvicerTeacherCheckbox.click();
        ReusableMethods.waitFor(2);
    }

    @Then("Kullanici cinsiyet girer")
    public void kullaniciCinsiyetGirer() {
        bahadir.female.click();
    }

    @Then("Gecersiz bir SSN degeri girer")
    public void gecersizBirSSNDegeriGirer() {
        Methods.validateSSN(bahadir.ssn.getText());
    }

    @Then("Kullanici {string} SSN degeri girer")
    public void kullaniciSSNDegeriGirer(String str) {
        bahadir.ssn.sendKeys(str);
    }

    @Then("Kullanici SSN uyari mesajinin gorunurlugunu dogrular")
    public void kullaniciSSNUyariMesajininGorunurlugunuDogrular() {
        assertTrue(bahadir.ssnmissingmessage.isDisplayed());
    }

    @Then("Kullanici {string} password girer")
    public void kullaniciPasswordGirer(String str) {
        bahadir.password.sendKeys(str);
    }

    @Then("Kullanici {string} telefon numarasi girer.")
    public void kullaniciTelefonNumarasiGirer(String str) {
        bahadir.phone.sendKeys(str);
    }

    @Then("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        bahadir.menuButton.click();
        ReusableMethods.waitFor(1);
        bahadir.logOut.click();
    }
}

