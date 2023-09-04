package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.US07_08.ErolPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US07StepDefinition {

    ErolPages erol = new ErolPages();

    @Given("User goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Then("User clicks to login button")
    public void userClicksToLoginButton() {
        erol.login.click();
    }
    @Then("User enters an username, password and then is logged in.")
    public void userEntersAnUsernamePasswordAndThenIsLoggedIn() {
        erol.username.sendKeys(ConfigReader.getProperty("deanUserName"), Keys.TAB, ConfigReader.getProperty("password"),
                Keys.TAB, Keys.ENTER);
    }

    @Then("User waits {int} seconds")
    public void userWaitsSeconds(int seconds) {
        ReusableMethods.waitFor(seconds);
    }


    @Then("User clicks login button")
    public void userClicksLoginButton() {
        erol.login.click();
    }

    @And("User clicks to menu button")
    public void userClickToMenuButton() {
        erol.menuButton.click();
    }

    @And("User clicks to Contact get all button")
    public void userClickToButton() {
        erol.contactGetAllButton.click();


    }


    @And("User closes driver")
    public void userClosesDriver() {
        Driver.closeDriver();
    }



}



