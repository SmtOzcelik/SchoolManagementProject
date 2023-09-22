package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {



   public static void main(String[] args) {

       String guncelToken = generateToken();
       System.out.println("guncelToken = "+guncelToken);
   }

 

    public static String generateToken() {



            String body = "{ \"password\": \"Ab142790\", " +
                    "\"username\": \"AdminSamet\" }";

            Response response = given()
                    .body(body)
                    .contentType(ContentType.JSON)
                    .post("https://managementonschools.com/app/auth/login");
            //response.prettyPrint();
            return response.jsonPath().getString("token");
        }
    public static String generateTokenViceDean() {
        Response response =  given().contentType(ContentType.JSON).accept("application/json").accept("*/*").body("{\"password\": \"12345678\",\"username\": \"mrsnice\"}").post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }


}