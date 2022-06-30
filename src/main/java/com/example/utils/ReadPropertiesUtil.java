package com.example.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesUtil {


    private static Properties properties;

    public static Properties getProperties(String location, String error) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(location)) {
            properties.load(resourceStream);
        } catch (NumberFormatException | FileNotFoundException e) {
            throw new Exception(error);
        }
        return properties;
    }
}
