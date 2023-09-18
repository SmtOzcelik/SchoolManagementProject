package stepDefinitions.apiStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import org.junit.Assert;
import pojos.US04Pojo.US04PostPojo;
import pojos.US04Pojo.US04ResponsePojo;

import io.restassured.specification.RequestSpecification;

import utilities.ConfigReader;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static baseUrl.ManagementSchoolUrl.spec;

public class US04StepDefinitionApi {

    Faker faker=new Faker();
    Response response;
    US04PostPojo expectedData=new US04PostPojo();
    US04ResponsePojo actualDate;







}
