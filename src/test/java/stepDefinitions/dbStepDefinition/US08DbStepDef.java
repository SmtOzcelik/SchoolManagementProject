package stepDefinitions.dbStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US08DbStepDef {
    Connection connection;
    ResultSet resultSet;
    Statement statement;;
    @Given("Take lesson that name is {string}")
    public void takeLessonThatNameIs(String lessonName) throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM lesson WHERE lesson_name = '"+lessonName+"';");
        resultSet.next();
    }

    @Then("Verify the lesson : lessonId={string}, lessonName={string}, creditScore={string},  compulsory={string}")
    public void verifyTheLessonLessonIdLessonNameCreditScoreCompulsory(String lessonId, String lessonName, String creditScore, String compulsory) throws SQLException {
        assertEquals(lessonId, resultSet.getString("lesson_id"));
        assertEquals(lessonName, resultSet.getString("lesson_name"));
        assertEquals(creditScore, resultSet.getString("credit_score"));
        assertEquals(compulsory, resultSet.getString("is_compulsory"));

    }
}
