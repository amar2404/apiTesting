package uk.co.test.tests.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import uk.co.test.tests.config.YAMLConfig;

public class RequestBuilder extends YAMLConfig {

    private ObjectMapper objectMapper;
    private YAMLConfig config;

    public RequestBuilder(YAMLConfig config){
        this.config=config;
        objectMapper=new ObjectMapper();
        RestAssured.baseURI=config.getHost();
    }

    public Response getWeather()
    {
        Response response=RestAssured.given()
                .basePath(config.getWeatherPath())
                .header("X-RapidAPI-Host","community-open-weather-map.p.rapidapi.com")
                .header("X-RapidAPI-Key","421f928bb1msh382d1b6661cf88cp161905jsnd3bd6473a8f0")
                .param("id","2172797")
                .get();

        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusCode());
        response.getBody().prettyPrint();
        return response;
    }

}
