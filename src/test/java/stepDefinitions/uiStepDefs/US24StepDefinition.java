package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US_9_10_24.BahadirPage;
import utilities.Driver;
import utilities.Methods;
import utilities.ReusableMethods;

public class US24StepDefinition {
    BahadirPage bahadir = new BahadirPage();
    Actions actions = new Actions(Driver.getDriver());
    Methods methods = new Methods();
    Faker faker = new Faker();

    @Then("Kullanici Teacher Management yazisina tiklar")
    public void kullaniciTeacherManagementYazisinaTiklar() {
        ReusableMethods.clickWithJS(bahadir.teacherManagement);
    }

    @Then("Kullanici Choose Lessons'dan herhangi bir ders secer")
    public void kullaniciChooseLessonsDanHerhangiBirDersSecer() {
        bahadir.name.sendKeys(Keys.SHIFT, Keys.TAB);
        actions.click(bahadir.selectLesson).perform();
        actions.sendKeys(Keys.ENTER).perform();
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
}
