package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.US05_06.SalihPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US05StepDefinition {
    SalihPages schoolManagement=new SalihPages();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Kullanici {string} sayfasina gider.")
    public void kullaniciSayfasinaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));



    }

    @Then("kullanici logine tiklar")
    public void kullaniciLogineTiklar() {
        schoolManagement.login.click();

    }

    @And("username alanina tiklar ve {string} girer")
    public void usernameAlaninaTiklarVeGirer(String username) {
        schoolManagement.username.sendKeys(ConfigReader.getProperty("username"));

    }

    @And("{string} girer")
    public void girer(String password) {
        schoolManagement.password.sendKeys(ConfigReader.getProperty("password"), Keys.TAB,Keys.ENTER);

    }

    @And("login butona tiklar ve sayfaya giris yaptigini dogrular")
    public void loginButonaTiklarVeSayfayaGirisYaptiginiDogrular() {
       Assert.assertTrue(schoolManagement.adminManagementDogrulama.isDisplayed());

    }

    @And("menu butonuna tiklar")
    public void menuButonunaTiklar() {
        schoolManagement.menuButton.click();

    }

    @And("main menuden dean managemente tiklar ve dogrular")
    public void mainMenudenDeanManagementeTiklarVeDogrular() {
        schoolManagement.DeanManagementMenuButton.click();

    }

    @And("Dean'lerin Name, Gender, Phone Number, SSN, User Name bilgilerini gorebilmeli")
    public void deanLerinNameGenderPhoneNumberSSNUserNameBilgileriniGorebilmeli() {
        Assert.assertTrue(schoolManagement.deanTablo.isDisplayed());

    }



    @And("dean'leri guncelleyebilmeli ve guncellendigini dogrulamali")
    public void deanLeriGuncelleyebilmeliVeGuncellendiginiDogrulamali() {
    ReusableMethods.clickElementByJS(schoolManagement.deanListYazisi);


    @And("dean'leri silebilmeli ve silindigini dogrulamali")
    public void deanLeriSilebilmeliVeSilindiginiDogrulamali() throws IOException {
       //ReusableMethods.jsExecutorScrool(schoolManagement.deanTeam11Edit);
       ReusableMethods.getScreenshot("schoolManagement.deanTablo");


    }

    @And("dean'leri guncelleyebilmeli ve guncellendigini dogrulamali")
    public void deanLeriGuncelleyebilmeliVeGuncellendiginiDogrulamali() {

       actions.moveToElement(schoolManagement.deanTeam11Edit).perform();



    }



}
