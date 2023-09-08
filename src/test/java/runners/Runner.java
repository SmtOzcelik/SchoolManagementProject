package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
        "pretty",//raporlarin daha okunakli olmasi icin
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber.xml" ,
        "rerun:target/failed_scenarios.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome=true, //raporlarin consolda okunakli sekilde cikmasi icin
        features = "./src/test/resources/features",  //features folder path
        glue = {"stepDefinitions","hooks"},//stepdefinitions path
<<<<<<< HEAD
        tags = "@US_13_TC_01",
=======

        tags = "",
>>>>>>> 664df31739208dda4531f2080d987959517d0c1a
        dryRun = true
)

public class Runner {
}
