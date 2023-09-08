package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pages.US_9_10_24.BahadirPage;
import utilities.ReusableMethods;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class US09StepDefinition {
    SoftAssert softAssert = new SoftAssert();
    BahadirPage bahadir = new BahadirPage();

    @Then("Kullanici acilan ekranda Lessons bolumune tiklar")
    public void kullaniciAcilanEkrandaLessonsBolumuneTiklar() {
        bahadir.lessonsButton.click();
    }

    @Then("Kullanici Lesson Name,Compulsory ve Credit Score gorundugunu dogrular")
    public void kullaniciLessonNameCompulsoryVeCreditScoreGorundugunuDogrular() {
        softAssert.assertTrue(bahadir.lessonList.isDisplayed());
    }

    @Then("Kullanici Ders Listesinin ekran goruntusunu alir")
    public void kullaniciDersListesininEkranGoruntusunuAlir() {
        try {
            ReusableMethods.getScreenshotWebElement("ScreenShot", bahadir.lessonList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("Kullanici Java dersinin yanindaki silme butonuna tiklar")
    public void kullaniciJavaDersininYanindakiSilmeButonunaTiklar() {
        ReusableMethods.jsExecutorClick(bahadir.javaDeleteButton);
    }

    @Then("Kullanici Java dersinin silinmedigini dogrular")
    public void kullaniciJavaDersininSilinmediginiDogrular() {
        softAssert.assertTrue(bahadir.javaYazisi.isDisplayed());
    }
}
