package stepDefinitions.api;

import io.restassured.response.Response;
import models.Universal;
import utilities.APIService;
import utilities.Config;

public class TestActivities {
    private APIService apiService;

    public TestActivities(){
        String baseURI = Config.getValue("base.uri");
        apiService = new APIService(baseURI);
    }


    @org.junit.Test
    public void getActivities(){
        String path = "/api/v1/Activities";
        Response response = apiService.get(path);
        System.out.println(response.getBody().print());
    }

    @org.junit.Test
    public void getSingleActivity(){
        String path = "/api/v1/Activities/2";
        Response response = apiService.get(path);
        System.out.println(response.getBody().print());
    }

    @org.junit.Test
    public void postActivity(){
        String path = "/api/v1/Activities";
        Universal requestBody = new Universal();
        requestBody.setId(1);
        requestBody.setTitle("My Activity");
        requestBody.setDueDate("2024-07-13T01:07:02.803Z");
        requestBody.setCompleted(true);
        Response response = apiService.post(path, requestBody);
        System.out.println(response.getBody().print());
    }

    @org.junit.Test
    public void putActivity(){
        String path = "/api/v1/Activities/4";
        Universal requestBody = new Universal();
        requestBody.setId(1);
        requestBody.setTitle("My Activity");
        requestBody.setDueDate("2024-07-13T01:07:02.803Z");
        requestBody.setCompleted(true);
        Response response = apiService.put(path, requestBody);
        System.out.println(response.getBody().print());
    }

    @org.junit.Test
    public void deleteActivity(){
        String path = "/api/v1/Activities/4";
        Response response = apiService.delete(path);
        System.out.println(response.statusCode());
    }





}
