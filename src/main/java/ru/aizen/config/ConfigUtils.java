package ru.aizen.config;

import java.io.*;
import java.util.Properties;

public final class ConfigUtils {

    private ConfigUtils() {
        throw new AssertionError();
    }

    public static Properties getResource(String resourceName) throws IOException {
        Properties properties = new Properties();
        InputStream is = ConfigUtils.class.getClassLoader().getResourceAsStream(resourceName + ".dat");
        properties.load(is);
        is.close();
        return properties;
    }

    public static Properties getConfig() throws IOException {
        Properties properties = new Properties();
        File configFile = new File("config.ini");
        FileInputStream fis = new FileInputStream(configFile);
        properties.load(fis);
        return properties;
    }
}
