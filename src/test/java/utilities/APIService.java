package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIService {
    private RequestSpecification requestSpec;

    public APIService(String baseURI){
        RestAssured.baseURI = baseURI;
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Accept","application/json")
                .build();
    }

    public Response get(String endpoint){
        return RestAssured.given()
                .spec(requestSpec)
                .get(endpoint);
    }


    public Response post(String endpoint, Object body){
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .post(endpoint);
    }

    public Response put(String endpoint, Object body){
        return RestAssured.given()
                .spec(requestSpec)
                .body(body)
                .put(endpoint);
    }

    public Response delete(String endpoint){
        return RestAssured.given()
                .spec(requestSpec)
                .delete(endpoint);
    }


}
