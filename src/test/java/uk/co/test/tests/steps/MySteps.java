package uk.co.test.tests.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.java.en.Given;
import org.junit.Test;
import uk.co.test.tests.config.YAMLConfig;
import uk.co.test.tests.utils.RequestBuilder;

import java.io.IOException;


public class MySteps {

    private RequestBuilder requestbuilder;
    private ObjectMapper objectMapper;
    private YAMLConfig config;
    private ObjectNode weatherResponse;

    public MySteps(YAMLConfig config){
        this.config=config;
        objectMapper=new ObjectMapper();
        requestbuilder=new RequestBuilder(config);

    }

    @Given("I have multiple collectable items in my basket")
    public void i_have_multiple_collectable_items_in_my_basket() {
        // Write code here that turns the phrase above into concrete actions

        requestbuilder.getWeather();
      /*  try{
            System.out.println("Hello World");}
        catch(Exception e)
        {
            e.printStackTrace();
        }*/

        try {
            weatherResponse=objectMapper.readValue(requestbuilder.getWeather().getBody().asInputStream(), ObjectNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
