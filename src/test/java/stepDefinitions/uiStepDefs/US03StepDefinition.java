package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SametPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US03StepDefinition {

    SametPage school=new SametPage();

    @Given("Kullanici anasayfaya girer")
    public void kullaniciUrlEGirer() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(1);
    }

    @When("Kullanici Contact butonuna tıklar")
    public void kullaniciContactButonunaTıklar() {
        school.contactButon.click();
    }

    @And("Kullanici Your name kutucuguna gecerli name {string} girer")
    public void kullaniciYourNameKutucugunaGecerliNameGirer(String arg0) {
        ReusableMethods.jsExecutorScrool(school.yourNameBox);
        school.yourNameBox.sendKeys(arg0);
        
    }

    @And("Kullanici Your email kutucuguna gecerli mail {string} girer")
    public void kullaniciYourEmailKutucugunaGecerliMailGirer(String arg0) {
        school.yourEmailBox.sendKeys(arg0);
        
    }

    @And("Kullanici Subject kutucuguna gecerli ders {string} girer")
    public void kullaniciSubjectKutucugunaGecerliDersGirer(String arg0) {
        school.subjectBox.sendKeys(arg0);
        
    }
    @And("Kullanici Message kutucuguna gecerli mesaj {string} girer")
    public void kullaniciMessageKutucugunaGecerliMesajGirer(String arg0) {
        school.messageBox.sendKeys(arg0);
    }

    @And("Kullanici Send Message butonuna tiklar")
    public void kullaniciSendMessageButonunaTiklar() {
        school.sendMessageButon.click();
    }

    @And("Kullanici Contact Message Created Successfully uyarisini gorunurlugunu test eder")
    public void kullaniciContactMessageCreatedSuccessfullyUyarisiniGorunurlugunuTestEder() {
        school.successfullyText.isDisplayed();
    }



}
