package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import pages.US_01_02.AlperPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US01StepDefinition {

    AlperPages alpg = new AlperPages();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    static Faker faker = new Faker();
    static String fakeUserName;

    @Given("Kisi {string} adresine gider")
    public void kisi_adresine_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }


    @Then("Aday ogrenci Register ikonuna tiklar")
    public void aday_ogrenci_register_ikonuna_tiklar() {
        alpg.registerAnaSayfa.click();
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici {string} alaninda tab tusuna basar")
    public void kullaniciNameAlanindaTabTusunaBasar(String arg0) {
        alpg.name.sendKeys(Keys.TAB);
    }
    @Then("Kullanici Name kutusuna {string} girer")
    public void kullanici_name_kutusuna_girer(String name) {
        alpg.name.sendKeys(name);
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici at least iki character uyarisini goruntulemez")
    public void kullanici_at_least_iki_character_uyarisini_goruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error Toastify__toast--close-on-click']")).size()<1);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici name disindaki tum alanlara valid deger girer")
    public void kullaniciNameDisindakiTumAlanlaraValidDegerGirer() {
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.pageDown();
        alpg.male.click();
        ReusableMethods.bekle(1);
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Ab123456",Keys.TAB);
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici at least iki character uyarisini goruntuler")
    public void kullanici_at_least_iki_character_uyarisini_goruntuler() {
        assertTrue(alpg.atleast2char.isDisplayed());
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici Surname kutusuna {string} girer")
    public void kullaniciSurnameKutusunaGirer(String surname) {
        alpg.surname.sendKeys(surname);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici surname disindaki tum alanlara valid deger girer")
    public void kullaniciSurnameDisindakiTumAlanlaraValidDegerGirer() {
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        //ReusableMethods.arrowDown();
        ReusableMethods.pageDown();
        alpg.female.click();
        ReusableMethods.bekle(1);
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Ab123456");
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici Birth place kutusuna {string} girer")
    public void kullaniciBirthPlaceKutusunaGirer(String birthplace) {
        alpg.birthPlace.sendKeys(birthplace);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici birth place disindaki tum alanlara valid deger girer")
    public void kullaniciBirthPlaceDisindakiTumAlanlaraValidDegerGirer() {
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        alpg.female.click();
        ReusableMethods.bekle(1);
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Ab123456",Keys.TAB);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici Phone Number kutusuna {string} girer")
    public void kullaniciPhoneNumberKutusunaGirer(String phone) {
        alpg.phoneNumber.sendKeys(phone);
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici enter valid phone number uyarisini goruntulemez")
    public void kullaniciEnterValidPhoneNumberUyarisiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Please enter valid phone number')]")).size()<1);
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici minumum 12 character uyarisini goruntuler")
    public void kullaniciMinumum12CharacterUyarisiniGoruntuler() {
        assertTrue(alpg.min12char.isDisplayed());
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici phone number disindaki tum alanlara valid deger girer")
    public void kullaniciPhoneNumberDisindakiTumAlanlaraValidDegerGirer() {
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.pageDown();
        alpg.male.click();
        ReusableMethods.bekle(1);
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Ab123456",Keys.TAB);
        ReusableMethods.bekle(1);

    }
    @Then("Kullanici exact oniki character uyarisini goruntuler")
    public void kullaniciExactOnikiCharacterUyarisiniGoruntuler() {
        assertTrue(alpg.exact12char.isDisplayed());
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici Gender radio butonlarindan gender secer")
    public void kullaniciGenderRadioButonlarindanGenderSecer() {
        ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        ReusableMethods.clickElementByJS(alpg.male);
        ReusableMethods.bekle(3);
    }
    @Given("Kullanici Date Of Birth kutusuna {string} girer")
    public void kullaniciDateOfBirthKutusunaGirer(String dateOfBirth) {
        alpg.dateOfBirth.sendKeys(dateOfBirth);
        ReusableMethods.bekle(1);
    }
    @Then("kullanici gecmis tarih olmali uyarisini goruntulemez")
    public void kullaniciGecmisTarihOlmaliUyarisiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'geçmiş bir tarih olmalı')]")).size()<1);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici date of birth disindaki tum alanlara valid deger girer")
    public void kullaniciDateOfBirthDisindakiTumAlanlaraValidDegerGirer() {
        ReusableMethods.bekle(1);
        ReusableMethods.pageUp();
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        //ReusableMethods.pageDown();
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        alpg.male.click();
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Ab123456");
        ReusableMethods.bekle(1);
    }
    @Then("kullanici gecmis tarih olmali uyarisini goruntuler")
    public void kullaniciGecmisTarihOlmaliUyarisiniGoruntuler() {
        ReusableMethods.bekle(1);
        assertTrue(alpg.gecmisBirTarihOlmali.isDisplayed());
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici SSN kutusuna {string} girer")
    public void kullaniciSSNKutusunaGirer(String ssn) {
        alpg.ssn.sendKeys(ssn);
        ReusableMethods.bekle(2);
    }

    @Then("Kullanici enter valid SSN number alertini goruntulemez")
    public void kullaniciEnterValidSSNNumberAlertiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'enter valid ssn number')]")).size()<1);
        ReusableMethods.bekle(1);
    }

    @Then("Kullanici please enter valid SSN number alertini goruntuler")
    public void kullaniciPleaseEnterValidSSNNumberAlertiniGoruntuler() {
        ReusableMethods.bekle(3);
        assertTrue(alpg.pleaseEnterValidSsnNumber.isDisplayed());
        ReusableMethods.bekle(3);
    }

    @Then("Kullanici minimum onbir character alertini goruntuler")
    public void kullaniciMinimumOnbirCharacterAlertiniGoruntuler() {
        ReusableMethods.bekle(1);
        assertTrue(alpg.min11char.isDisplayed());
        ReusableMethods.bekle(1);
    }

    @Given("Kullanici SSN disindaki tum alanlara valid deger girer")
    public void kullaniciSSNDisindakiTumAlanlaraValidDegerGirer() {
        ReusableMethods.bekle(1);
        ReusableMethods.pageUp();
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        alpg.male.click();
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Mg123456",Keys.TAB);
        ReusableMethods.bekle(1);

    }

    @Given("Kullanici User Name kutusuna {string} girer")
    public void kullaniciUserNameKutusunaGirer(String userName) {
        alpg.username.sendKeys(userName);
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici at least dort character uyarisini goruntulemez")
    public void kullaniciAtLeastDortCharacterUyarisiniGoruntulemez() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Your username should be at least 4 characters')]")).size()<1);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici user name disindaki alanlar icin valid deger girer")
    public void kullaniciUserNameDisindakiAlanlarIcinValidDegerGirer() {
        ReusableMethods.bekle(1);
        ReusableMethods.pageUp();
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        alpg.male.click();
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        alpg.passwordp.sendKeys("Ab123456",Keys.TAB);
        ReusableMethods.bekle(1);

    }
    @Then("Kullanici at least dort character uyarisini goruntuler")
    public void kullaniciAtLeastDortCharacterUyarisiniGoruntuler() {
        ReusableMethods.bekle(1);
        assertTrue(alpg.atleast4char.isDisplayed());
        ReusableMethods.bekle(1);
    }
    @And("Kullanici Password kutusuna {string} girer")
    public void kullaniciPasswordKutusunaGirer(String password) {
        alpg.password.sendKeys(password);
        ReusableMethods.bekle(1);
    }
    @Given("Kullanici password disindaki alanlar icin valid deger girer")
    public void kullaniciPasswordDisindakiAlanlarIcinValidDegerGirer() {
        ReusableMethods.bekle(1);
        ReusableMethods.pageUp();
        alpg.name.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(1);
        alpg.surname.sendKeys(faker.name().lastName());
        ReusableMethods.bekle(1);
        alpg.birthPlace.sendKeys(faker.address().city());
        ReusableMethods.bekle(1);
        alpg.phoneNumber.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        ReusableMethods.pageDown();
        alpg.male.click();
        ReusableMethods.bekle(1);
        alpg.dateOfBirth.sendKeys("10/10/2000");
        ReusableMethods.bekle(1);
        alpg.ssn.sendKeys(faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999));
        ReusableMethods.bekle(1);
        fakeUserName = faker.name().firstName();
        alpg.usernamep.sendKeys(fakeUserName,Keys.TAB,Keys.TAB);
        ReusableMethods.bekle(1);
    }

    @Then("Kullanici username icin valid deger girer")
    public void usernameIcinValidDegerGirer() {
        do {
            fakeUserName = faker.name().firstName();
        } while (fakeUserName.length() < 4 || fakeUserName.length() > 8);
        alpg.usernamep.sendKeys(fakeUserName);
        ReusableMethods.bekle(1);
    }


    @And("Kullanici guest user registered mesajini gorerek basarili kayit yapabildigini dogrular")
    public void kullaniciGuestUserRegisteredMesajiniGorerekBasariliKayitYapabildiginiDogrular() {
        //ReusableMethods.bekle(1);
        assertTrue(alpg.guestUserRegistered.isDisplayed());
        ReusableMethods.bekle(3);
    }
    @And("Kullanici guest user registered mesajini gormeyerek basarili kayit yapamadigini dogrular")
    public void kullaniciGuestUserRegisteredMesajiniGormeyerekBasariliKayitYapamadiginiDogrular() {
        assertTrue(Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Guest User registered.')]")).size()<1);
        ReusableMethods.bekle(1);
    }
    @Then("Kullanici register butonuna tiklar")
    public void kullaniciRegisterButonunaTiklar() {
        alpg.register.click();
        ReusableMethods.bekle(2);
    }



    @Then("Kullanici {string} icin required uyarisini goruntuler")
    public void kullaniciIcinRequiredUyarisiniGoruntuler(String kutucuk) {
        switch (kutucuk){
            case "name":
                assertTrue(alpg.requiredMessageName.isDisplayed());
                break;

            case "surname":
                assertTrue(alpg.requiredMessageSurname.isDisplayed());
                break;

            case "birth place":
                assertTrue(alpg.requiredMessageBirthPlace.isDisplayed());
                break;

            case "date of birth":
                assertTrue(alpg.requiredMessageDateOfBirth.isDisplayed());
                break;

            case "phone":
                assertTrue(alpg.requiredMessagePhone.isDisplayed());
                break;

            case "SSN":
                assertTrue(alpg.requiredMessageSsn.isDisplayed());
                break;

            case "username":
                assertTrue(alpg.requiredMessageUserName.isDisplayed());
                break;

            case "pasword":
                assertTrue(alpg.EnterYourPasswordMessage.isDisplayed());
                break;
        }
        ReusableMethods.bekle(1);
    }

    @Then("Kullanici minimum sekiz karakter uyarisini goruntuler")
    public void kullaniciMinimumSekizKarakterUyarisiniGoruntuler() {
        assertTrue(alpg.minimum8.isDisplayed());
    }

    @Given("Kullanici {string}  alaninda tab tusuna basar")
    public void kullaniciSurnameAlanindaTabTusunaBasar(String arg0) {
        alpg.surname.sendKeys(Keys.TAB);
    }

    @Given("Kullanici {string}   alaninda tab tusuna basar")
    public void kullanicibirthplaceAlanindaTabTusunaBasar(String arg0) {
        alpg.birthPlace.sendKeys(Keys.TAB);
    }

    @Given("Kullanici  {string} alaninda tab tusuna basar")
    public void kullaniciSsnAlanindaTabTusunaBasar(String arg0) {
        alpg.ssn.sendKeys(Keys.TAB);
    }

    @Given("Kullanici   {string} alaninda tab tusuna basar")
    public void kullaniciUsernameAlanindaTabTusunaBasar(String arg0) {
        alpg.username.sendKeys(Keys.TAB);
    }

    @Given("Kullanici{string} alaninda tab tusuna basar")
    public void kullaniciPasswordAlanindaTabTusunaBasar(String arg0) {
        alpg.password.sendKeys(Keys.TAB);
    }

}
