package main.java.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private Properties properties;

    private Configuration(Properties properties) {
        this.properties = properties;
    }

    public static Configuration load(String configFilePath) throws IOException {
        Properties properties = new Properties();
        if (configFilePath != null) {
            try (FileInputStream fis = new FileInputStream(configFilePath)) {
                properties.load(fis);
            }
        }
        return new Configuration(properties);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Add methods to get specific configuration settings as needed
}

