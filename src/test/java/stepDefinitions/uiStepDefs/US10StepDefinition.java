package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.US_9_10_24.BahadirPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US10StepDefinition {
    Select select;
    Actions actions = new Actions(Driver.getDriver());
    BahadirPage bahadir = new BahadirPage();

    @Given("Kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("Kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int saniye) {
        ReusableMethods.waitFor(saniye);
    }

    @Then("Kullanici Login yazisina tiklar")
    public void kullaniciLoginYazisinaTiklar() {
        bahadir.login.click();
    }


    @Then("Kullanici User Name alanina {string} password alanina {string} degerini girip giris yapar")
    public void kullaniciUserNameAlaninaPasswordAlaninaDegeriniGiripGirisYapar(String username, String password) {
        bahadir.username.sendKeys(ConfigReader.getProperty(username), Keys.TAB,
                ConfigReader.getProperty(password), Keys.TAB, Keys.ENTER);
    }

    @Then("Kullanici acilan ekranda Lesson Program bolumune tiklar")
    public void kullaniciAcilanEkrandaLessonProgramBolumuneTiklar() {
        bahadir.lessonProgram.click();
    }


    @Then("Kullanici Add Lesson Program alanindaki Select Lesson menusunun erisilebilir oldugunu dogrular")
    public void kullaniciAddLessonProgramAlanindakiSelectLessonMenusununErisilebilirOldugunuDogrular() {
        assertTrue(bahadir.selectLesson.isEnabled());
    }


    @Then("Kullanici Add Lesson Program alanindaki Select Lesson menusunden en ustteki dersi secer")
    public void kullaniciAddLessonProgramAlanindakiSelectLessonMenusundenEnUsttekiDersiSecer() {
        bahadir.chooseEducationTerm.sendKeys(Keys.SHIFT, Keys.TAB, Keys.DOWN, Keys.ENTER);
    }

    @Then("Kullanici Add Lesson Program alanindaki Choose Education Term menusunun erisilebilir oldugunu dogrular")
    public void kullaniciAddLessonProgramAlanindakiChooseEducationTermMenusununErisilebilirOldugunuDogrular() {
        assertTrue(bahadir.chooseDayDDmenu.isEnabled());
    }

    @Then("Kullanici Add Lesson Program alanindaki Choose Education Term menusunden {string} secer")
    public void kullaniciAddLessonProgramAlanindakiChooseEducationTermMenusundenSecer(String str) {
        select = new Select(bahadir.chooseEducationTermDDMenu);
        select.selectByVisibleText(str);
    }

    @Then("Kullanici Add Lesson Program alanindaki Choose Day menusunun erisilebilir oldugunu dogrular")
    public void kullaniciAddLessonProgramAlanindakiChooseDayMenusununErisilebilirOldugunuDogrular() {
        assertTrue(bahadir.chooseEducationTermDDMenu.isEnabled());
    }

    @Then("Kullanici Add Lesson Program alanindaki Choose Day menusunden {string} secer")
    public void kullaniciAddLessonProgramAlanindakiChooseDayMenusundenSecer(String str) {
        select = new Select(bahadir.chooseDayDDmenu);
        select.selectByVisibleText(str);
    }

    @Then("Kullanici Add Lesson Program alanindaki Start Time bolumune {string} degerini girer")
    public void kullaniciAddLessonProgramAlanindakiStartTimeBolumuneDegeriniGirer(String str) {
        bahadir.startTime.sendKeys(str);
    }

    @Then("Kullanici Add Lesson Program alanindaki Stop Time bolumune {string} degerini girer")
    public void kullaniciAddLessonProgramAlanindakiStopTimeBolumuneDegeriniGirer(String str) {
        bahadir.stopTime.sendKeys(str);
    }

    @Then("Kullanici Submit Butonuna tiklar")
    public void kullaniciSubmitButonunaTiklar() {
        ReusableMethods.clickElementByJS(bahadir.submitButton);
    }


    @Then("Kullanici Required alanlarinin gorunurlugunu dogrular")
    public void kullaniciRequiredAlanlarininGorunurlugunuDogrular() {
        Assert.assertTrue(bahadir.requiredYazisi.isDisplayed());
    }

    @Then("Kullanici {string} yazisinin gorunurlugunu dogrular")
    public void kullaniciYazisininGorunurlugunuDogrular(String str) {
        Assert.assertEquals(bahadir.alertMessage.getText(), str);

    }

    @Then("Kullanici hata mesajinin ekran goruntusunu alir")
    public void kullaniciHataMesajininEkranGoruntusunuAlir() {
        try {
            ReusableMethods.getScreenshotWebElement("ScreenShot", bahadir.alertMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
