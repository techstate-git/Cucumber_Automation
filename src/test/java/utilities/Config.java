package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;

    // static block
    // STATIC BLOCKs are loaded first
    static{
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("/Users/zhanarbek/IdeaProjects/fullstack/CucumberBatch1/ui/src/test/resources/application.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Configuration file is not found!");
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }





}