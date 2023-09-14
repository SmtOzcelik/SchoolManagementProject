package stepDefinitions.dbStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class US07DbStepDef {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("Take a message with {string} information")
    public void takeAMessageWithInformation(String email) throws SQLException {
            connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM contact_message WHERE email = '" + email + "';");
            resultSet.next();
        }


    @Then("Verify message information : name={string}, email={string}, subject={string}, message={string}, date={string}")
    public void verifyMessageInformationNameEmailSubjectMessageDate(String name, String email, String subject, String message, String date) throws SQLException  {
        String actName = resultSet.getString("name");
        String actEmail = resultSet.getString("email");
        String actSubject = resultSet.getString("subject");
        String actMessage = resultSet.getString("message");
        String actDate = resultSet.getString("date");

        assertEquals(actName,name);
        assertEquals(actEmail,email);
        assertEquals(actSubject,subject);
        assertEquals(actMessage,message);
        assertEquals(actDate,date);
    }
}

