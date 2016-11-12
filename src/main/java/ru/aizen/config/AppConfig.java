package ru.aizen.config;

import java.io.IOException;

public final class AppConfig {
    public static String gamePath;
    public static String cardsXmlFolder;
    public static String transformXsl;
    public static String outputXmlPath;
    public static String outputJsonPath;
    public static String textureLocation;

    private AppConfig(){
        throw new AssertionError();
    }
}
