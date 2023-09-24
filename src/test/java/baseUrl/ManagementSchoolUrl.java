package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.Authentication;
import utilities.ConfigReader;


public class ManagementSchoolUrl extends Authentication {

    public static RequestSpecification spec;
    public RequestSpecification spec2;


    public static void adminSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("password"), ConfigReader.getProperty("usernameAdmin"))).
                setBaseUri("https://managementonschools.com/app").build();
    } //setContentType() kismi post isleminin duzgun calismasi icin

    public static void deanSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("password"), ConfigReader.getProperty("usernameDean"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void vicedeanSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("password"), ConfigReader.getProperty("usernameViceDean"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void teacherSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("password"), ConfigReader.getProperty("usernameTeacher"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void studentSetup() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("password"), ConfigReader.getProperty("usernameStudent"))).
                setBaseUri("https://managementonschools.com/app").build();
    }

    public static void guestSetup() {
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", generateToken(ConfigReader.getProperty("password"), ConfigReader.getProperty("GuestAdmin"))).
                setBaseUri("https://managementonschools.com/app").build();
    }
    public void setUpViceDean() {

        spec2 = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization",generateTokenViceDean())
                .build();

    }

}

