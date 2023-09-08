package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.US_11_12.Managementonschool_HomePage;
import pages.US_11_12.Managementonschool_LessonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class US11StepDefinition {
    Managementonschool_LessonPage managementonschoolLessonPage;
    Managementonschool_HomePage managementonschoolHomePage;

    @Given("go to <{string}>")

        public void go_to(String url) {
            Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Then("Click To <{string}>")
    public void clickTo(String string) {
        managementonschoolHomePage = new Managementonschool_HomePage();
        switch (string) {
            case "RegisterButtonInMain":
                managementonschoolHomePage.mainMenuRegister.click();
                break;
            case "login":
                managementonschoolHomePage.mainMenuLogin.click();
                break;
            case "LoginButtonInLoginMenu":
                managementonschoolHomePage.loginMenuLoginButon.click();
                break;
            case "menuButton":
                managementonschoolHomePage.menuButton.click();
                break;
            case "adminManagementMenu":
                managementonschoolHomePage.adminManagement.click();
                break;
            case "deanManagementMenu":
                managementonschoolHomePage.deanManagement.click();
                break;
            case "viceDeanManagementMenu":
                managementonschoolHomePage.viceDeanMangement.click();
                break;
            case "lessonManagementMenu":
                managementonschoolHomePage.lessonManagement.click();
                break;
            case "teacherManagementMenu":
                managementonschoolHomePage.teacherMangement.click();
                break;
            case "studentManagementMenu":
                managementonschoolHomePage.studentManagement.click();
                break;
            case "studentInfoManagementMenu":
                managementonschoolHomePage.studentInfoManagement.click();
                break;
            case "contactMenu":
                managementonschoolHomePage.contactMenu.click();
                break;
            case "guestUserMenu":
                managementonschoolHomePage.guestUserMenu.click();
                break;
            case "logOut":
                managementonschoolHomePage.logOut.click();
                break;
            case "Submit":
                managementonschoolHomePage.adminSubmit.click();
                break;
            case "Gender":
                managementonschoolHomePage.genderFemale.click();
                break;
            case "GenderRegisteryPage":
                managementonschoolHomePage.phoneNumber.sendKeys(Keys.TAB, Keys.ARROW_RIGHT, Keys.TAB);
                break;
            case "isAdvisorTeacher":
                managementonschoolHomePage.isAdvisorTeacher.click();
                break;
            case "lastPageButton":
                managementonschoolHomePage.lastPageButton.click();
                break;
            case "registerButton":
                managementonschoolHomePage.registerButton.click();
                break;
            case "lastPageButton2":
                ReusableMethods.waitFor(1);
                managementonschoolHomePage.lastPageButton2.click();
                break;
            case "submitInEdit":
                ReusableMethods.waitFor(1);
                managementonschoolHomePage.submitInEdit.click();
                break;
        }
        ReusableMethods.waitFor(2);
    }


    @Then("Enter<{string}> UserName")
    public void enterUserName(String string) {
        managementonschoolHomePage.userName.sendKeys(ConfigReader.getProperty(string));
    }

    @And("Enter<{string}> PassWord")
    public void enterPassWord(String string) {
        managementonschoolHomePage.password.sendKeys(ConfigReader.getProperty(string));
    }

    @And("Click_To_Lesson_Program")
    public void click_to_lesson_program() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        managementonschoolLessonPage.lessonProgram.click();
    }

    @And("Lesson is Display")
    public void lessonIsDisplay() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        ReusableMethods.jsScroll(managementonschoolLessonPage.submitButtonAddLessonProgram);
        assertTrue(managementonschoolLessonPage.lessonText.isDisplayed());
    }

    @Then("Day is Display")
    public void dayIsDisplay() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        assertTrue(managementonschoolLessonPage.dayText.isDisplayed());
    }

    @Then("Start Time is Display")
    public void startTimeIsDisplay() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        assertTrue(managementonschoolLessonPage.startTimeText.isDisplayed());
    }

    @And("Stop Time is Display")
    public void stopTimeIsDisplay() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        assertTrue(managementonschoolLessonPage.stopTimeText.isDisplayed());
    }

    @And("Close Driver")
    public void closeDriver() {
        Driver.getDriver().close();



    }

    @Then("Vice Dean can not {string}")
    public void viceDeanCanNot(String arg0) throws IOException {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        ReusableMethods.jsScroll(managementonschoolLessonPage.submitButtonAddLessonProgram);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("ViceDean");
    }
}
