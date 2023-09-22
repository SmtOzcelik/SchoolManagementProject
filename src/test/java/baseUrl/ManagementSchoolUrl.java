package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authentication;


public class ManagementSchoolUrl extends Authentication {

    public static RequestSpecification spec;
    public RequestSpecification spec2;


    @Before
    public static void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app/")
                .addHeader("Authorization", generateToken())
                .setContentType(ContentType.JSON)
                .build();
    }
    public void setUpViceDean() {

        spec2 = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://managementonschools.com/app")
                .addHeader("Authorization",generateTokenViceDean())
                .build();

    }

}
