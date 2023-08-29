package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SametPage;
import utilities.ConfigReader;
import utilities.Driver;


public class US01StepDefinition {

    SametPage school=new SametPage();

    @Given("Kullanici url'e girer")
    public void kullaniciUrlEGirer() {
        Driver.getDriver().get("https://managementonschools.com/");
    }

    @When("Kullanici register simgesine tıklar")
    public void kullaniciRegisterSimgesineTıklar() {
        school.register.click();

    }
}
