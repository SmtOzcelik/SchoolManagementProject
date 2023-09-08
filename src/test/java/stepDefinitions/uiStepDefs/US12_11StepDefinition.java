package stepDefinitions.uiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.US_11_12.Managementonschool_LessonPage;
import utilities.ReusableMethods;

public class US12_11StepDefinition {
    Managementonschool_LessonPage managementonschoolLessonPage;
    @And("Click_To_Lesson_Programs")
    public void click_to_lesson_programs() {
        managementonschoolLessonPage = new Managementonschool_LessonPage();
        managementonschoolLessonPage.lessonProgram.click();

    }
    public static String expectedLesson="Java";
    @Then("Choose a lesson {string} as Vice Dean in Lesson Program")
    public void chooseALessonAsViceDeanInLessonProgram(String arg0) {

        managementonschoolLessonPage=new Managementonschool_LessonPage();
        managementonschoolLessonPage.chooseLessonsInLessonProgramasViceDean.sendKeys(expectedLesson, Keys.ENTER);
    }

    @Then("Choose a education term as Vice Dean in Lesson Program")
    public void chooseAEducationTermAsViceDeanInLessonProgram() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        managementonschoolLessonPage.chooseEducationTermInLessonProgramasViceDean.click();
        managementonschoolLessonPage.chooseSPRING_SEMESTERInEducationTermInLessonProgramasViceDean.click();
    }

    @Then("Choose a day as Vice Dean in Lesson Program")
    public void chooseADayAsViceDeanInLessonProgram() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        managementonschoolLessonPage.chooseDayInLessonProgramasViceDean.click();
        managementonschoolLessonPage.chooseMondayInLessonProgramasViceDean.click();
    }
    public static String expectedDataStartTime="07:50";
    @Then("Choose a start time {string} in Lesson Program")
    public void chooseAStartTimeInLessonProgram(String arg0) {

        managementonschoolLessonPage=new Managementonschool_LessonPage();
        ReusableMethods.waitFor(2);
        managementonschoolLessonPage.chooseStartTimeInLessonProgramasViceDean.sendKeys(expectedDataStartTime);
    }
    public static String expectedDataStopTime="10:00";
    @Then("Choose a Stop Time {string} in Lesson Program")
    public void chooseAStopTimeInLessonProgram(String arg0) {


        managementonschoolLessonPage=new Managementonschool_LessonPage();
        ReusableMethods.waitFor(2);
        managementonschoolLessonPage.chooseStopTimeInLessonProgramasViceDean.sendKeys(expectedDataStopTime);

    }

    @Then("submit in add lesson program")
    public void submitInAddLessonProgram() {
        managementonschoolLessonPage =new Managementonschool_LessonPage();
        ReusableMethods.waitFor(3);
        managementonschoolLessonPage.submitButtonAddLessonProgram.click();
        //ReusableMethods.jsExecutorClick(managementonschoolLessonPage.submitButtonAddLessonProgram);
    }

    @Then("Lesson Created Alert ini gorur")
    public void lessonCreatedAlertIniGorur() {

        managementonschoolLessonPage=new Managementonschool_LessonPage();
        ReusableMethods.waitFor(3);
        assert managementonschoolLessonPage.lessonCeratedAlert.isDisplayed();



    }

    @Then("Vice Dean select a lesson")
    public void viceDeanSelectALesson() {
        //managementonschoolLessonPage=new Managementonschool_LessonPage();
        //ReusableMethods.jsScroll(managementonschoolLessonPage.selectALessonInLessonProgramAssign);
        //ReusableMethods.waitFor(2);
        //managementonschoolLessonPage.selectALessonInLessonProgramAssign.click();
        ReusableMethods.clickElementByJS(managementonschoolLessonPage.selectALessonInLessonProgramAssign);
    }

    @Then("Vice Dean asign a teacher")
    public void viceDeanAsignATeacher() {
        managementonschoolLessonPage=new Managementonschool_LessonPage();
        ReusableMethods.clickElementByJS(managementonschoolLessonPage.chooseTeacherDDM);
        //managementonschoolLessonPage.chooseTeacherDDM.click();
        //ReusableMethods.waitFor(2);
        //managementonschoolLessonPage.chooseTeacherMuratInLessonProgramasViceDean.click();
        ReusableMethods.clickElementByJS(managementonschoolLessonPage.chooseTeacherMuratInLessonProgramasViceDean);
    }
}
