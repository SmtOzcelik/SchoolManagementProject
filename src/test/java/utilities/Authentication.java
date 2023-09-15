package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

        public static String generateToken (String passWord, String userName ){
            String urlswagger = "https://managementonschools.com/app/auth/login";
            Map<String, String> token = new HashMap<>();
            token.put("password", passWord);
            token.put("username", userName);

            Response response = given().contentType(ContentType.JSON).body(token).when().post(urlswagger);
            //response.prettyPrint();

            return response.jsonPath().getString("token");
        }


}