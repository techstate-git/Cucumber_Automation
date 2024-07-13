package stepDefinitions.api;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import models.Universal;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIService;
import utilities.Config;

public class TestBooks {

    private APIService apiService;

    public TestBooks(){
        String baseURI = Config.getValue("base.uri2");
        apiService = new APIService(baseURI);
    }

    @Test
    public void validateSuccessfulGetBookings() throws JsonProcessingException {
        String path = "/booking";
        Response response = apiService.get(path);
        String jsonResponse = response.getBody().asString();

        ObjectMapper objectMapper = new ObjectMapper();
        Universal[] universals = objectMapper.readValue(jsonResponse, Universal[].class);

        Assert.assertTrue(universals.length>0);
        for (Universal universal : universals) {
            Assert.assertTrue(universal.getBookingId()>=0);
        }
    }


}
