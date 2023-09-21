package stepDefinitions.dbStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;

import static stepDefinitions.uiStepDefs.US06StepDefinition.fakeSsn;
import static stepDefinitions.uiStepDefs.US06StepDefinition.sManagement;

public class US06DbStepDefinition {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("Data Base ile baglan")
    public void data_base_ile_baglan() throws SQLException {
        connection=  DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management","select_user","43w5ijfso");
    }

    @When("vice dean bilgilerini {string} ile al")
    public void vice_dean_bilgilerini_ile_al(String string) throws SQLException {
         statement=connection.createStatement();
         resultSet= statement.executeQuery("SELECT * FROM lesson WHERE ssn = '"+fakeSsn+"';");
    }

    @Then("vice dean bilgilerini DB ile dogrula.username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}")
    public void vice_dean_bilgilerini_db_ile_dogrula_username_name_surname_birth_day_ssn_birth_place_phone_number_gender(String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender) throws SQLException {
    resultSet.next();

    String actualBirtDay=resultSet.getString("birth_day");
    String actualBirtPlace=resultSet.getString("birth_place");
    String actualGender=resultSet.getString("gender");
    String actualName=resultSet.getString("name");
    String actualPhoneNumber=resultSet.getString("phone_number");
    String actualSsn=resultSet.getString("ssn");
    String actualSurname=resultSet.getString("surname");
    String actualUsername=resultSet.getString("username");

        Assert.assertEquals(sManagement.ViceDeanDogumTarihi,actualBirtDay);





    }
}