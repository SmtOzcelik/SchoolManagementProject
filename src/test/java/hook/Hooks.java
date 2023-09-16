package hook;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import static baseUrl.ManagementSchoolUrl.*;



public class Hooks {
    @Before
    public void setUp() throws Exception {
        System.out.println("Scenariolar calismaya basladi");
    }
    @Before("@admin")// @Before("@TC01_Api") boyle yazarsak sadece bir test case calisir
    public void beforeApiAdmin() {

        System.out.println("Before Method for admin");

        adminSetup();
    }
    @Before("@dean")// @Before("@TC01_Api") boyle yazarsak sadece bir test case calisir
    public void beforeApiDean() {

        System.out.println("Before Method for admin");

        deanSetup();
    }
    @Before("@vicedean")// @Before("@TC01_Api") boyle yazarsak sadece bir test case calisir
    public void beforeApiViceDean() {

        System.out.println("Before Method for admin");

        vicedeanSetup();
    }
    @Before("@teacher")// @Before("@TC01_Api") boyle yazarsak sadece bir test case calisir
    public void beforeApiTeacher() {

        System.out.println("Before Method for admin");

        teacherSetup();
    }
    @Before("@student")
    public void beforeApiStudent(){

        System.out.println("Before method for student");
        studentSetup();
    }




    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg", "scenario_" + scenario.getName());
            //Driver.closeDriver();
        }
        Driver.closeDriver();


    }

}