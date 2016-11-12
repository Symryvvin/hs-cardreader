package ru.aizen.config;

import java.io.IOException;
import java.util.Properties;

public final class Configurator {
    private static final String gamePath = "game.path";
    private static final String cardsXmlFolder = "cards.xml.folder";
    private static final String transformXsl = "transform.xsl.path";
    private static final String outputXmlPath = "output.xml.path";
    private static final String outputJsonPath = "output.json.path";
    private static final String textureLocation = "texture.location";

    private Configurator() {
        throw new AssertionError();
   }

   public static void init() throws IOException {
       Properties properties = ConfigUtils.getConfig();
       AppConfig.gamePath = properties.getProperty(gamePath);
       AppConfig.cardsXmlFolder = properties.getProperty(cardsXmlFolder);
       AppConfig.outputJsonPath = properties.getProperty(outputJsonPath);
       AppConfig.transformXsl = properties.getProperty(transformXsl);
       AppConfig.outputXmlPath = properties.getProperty(outputXmlPath);
       AppConfig.textureLocation = properties.getProperty(textureLocation);
   }
}
