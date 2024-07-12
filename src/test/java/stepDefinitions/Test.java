package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test {

    @org.junit.Test
    public void test(){
        Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody().prettyPrint());
    }
}
