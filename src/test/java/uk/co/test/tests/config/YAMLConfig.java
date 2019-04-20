package uk.co.test.tests.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YAMLConfig {
    @Getter
    @Setter
    private ObjectMapper objectMapper;

    @Getter
    private String weatherPath;

    @Getter
    private String host;

    public YAMLConfig(){
        objectMapper=new ObjectMapper();
        setEnvironment();

    }

    private void setEnvironment() {
        Yaml yaml=new Yaml();
        try {
            InputStream inputStream = new FileInputStream(new File("src/test/resources/application.yml"));
            Map<String,Object> config=yaml.load(inputStream);
            Map<String,String> paths=(Map<String, String>)config.get("path");
            weatherPath=paths.get("weather");

            Map<String,String> uri=(Map<String, String>)config.get("uri");
            host=uri.get("host");

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
