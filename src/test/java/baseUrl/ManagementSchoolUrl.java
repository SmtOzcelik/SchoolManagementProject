package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authentication;
import utilities.ConfigReader;


public class ManagementSchoolUrl extends Authentication {

    public static RequestSpecification spec;

    public static void adminSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("Password"), ConfigReader.getProperty("UsernameAdmin"))).
                setBaseUri("https://managementonschools.com/app").build();
    } //setContentType() kismi post isleminin duzgun calismasi icin

    public static void deanSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("Password"), ConfigReader.getProperty("usernameDean"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void vicedeanSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("Password"), ConfigReader.getProperty("usernameViceDean"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void teacherSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("Password"), ConfigReader.getProperty("UsernameTeacher"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void studentSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("Password"), ConfigReader.getProperty("UsernameStudent"))).
                setBaseUri("https://managementonschools.com/app").build();
    }
}

