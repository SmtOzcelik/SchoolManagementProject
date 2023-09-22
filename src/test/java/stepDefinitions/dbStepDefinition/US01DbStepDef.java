package stepDefinitions.dbStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static utilities.JDBCUtils.executeQuery;


public class US01DbStepDef {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("{string} ile guest useri cagir")
    public void ile_guest_useri_cagir(String username) throws SQLException {
        //connection ve statement olustur
        JDBCUtils.connectToDatabase();
        JDBCUtils.createStatement();

        //Query'yi çalıştır
        String query = "SELECT * FROM guest_user WHERE username = '"+username+"'";
        resultSet = executeQuery(query);
        //resultSet = statement.executeQuery(query);

    }

    @Then("body sunlari icermeli: {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void body_sunlari_icermeli(String name, String surname, String birthplace, String phone, String gender, String dateOfBirth, String ssn , String username) throws SQLException {

        resultSet.next();//Pointer varsayılan olarak sütun isimlerini gösterir. Next methodu ile table üzerine alınarak data okunabilir.

        String actUsername = resultSet.getString("username");
        String actName = resultSet.getString("name");
        String actSurname = resultSet.getString("surname");
        String actBirthPlace = resultSet.getString("birth_place");
        String actPhone = resultSet.getString("phone_number");
        String actGender = resultSet.getString("gender");
        String actDateOfBirth = resultSet.getString("birth_day");
        String actSsn = resultSet.getString("ssn");

        assertEquals(username,actUsername);
        assertEquals(name,actName);
        assertEquals(surname,actSurname);
        assertEquals(birthplace,actBirthPlace);
        assertEquals(phone,actPhone);
        assertEquals(gender,actGender);
        assertEquals(dateOfBirth,actDateOfBirth);
        assertEquals(ssn,actSsn);

    }

    @Given("silinen {string} ile guest useri cagir")
    public void silinenIleGuestUseriCagir(String username) {

        String query = "SELECT * FROM guest_user WHERE username = '"+username+"'";
        resultSet = executeQuery(query);

    }

    @Then("tablein bos oldugunu dogrula")
    public void tableinBosOldugunuDogrula() throws SQLException {

        assertFalse(resultSet.next());

    }
}
//1371