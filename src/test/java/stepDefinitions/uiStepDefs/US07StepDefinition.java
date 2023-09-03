package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.US07_08.ErolPages;
import utilities.ConfigReader;
import utilities.Driver;

public class US07StepDefinition {

    ErolPages erol = new ErolPages();

    @Given("User goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("User clicks to login button")
    public void userClicksToLoginButton() {
        erol.login.click();
    }

    @When("User enters an Username as {string}")
    public void userEntersAnUsernameAs(String username) {
        erol.username.sendKeys();
    }

    @When("User enters a {string}")
    public void userEntersA(String arg0) {
    }

    @When("User waits {int} seconds")
    public void userWaitsSeconds(int arg0) {
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
    }

    @And("User click to menu button")
    public void userClickToMenuButton() {
    }

    @And("User click to {string} button")
    public void userClickToButton(String arg0) {
    }

    @And("User tests the visibility of {string} column")
    public void userTestsTheVisibilityOfColumn(String arg0) {
    }

    @And("User tests the visibility of {string} button")
    public void userTestsTheVisibilityOfButton(String arg0) {
    }

    @And("User clicks to {string} button")
    public void userClicksToButton(String arg0) {
    }

    @And("User tests if the message has been deleted")
    public void userTestsIfTheMessageHasBeenDeleted() {
    }

    @And("User closes driver")
    public void userClosesDriver() {
    }
}
