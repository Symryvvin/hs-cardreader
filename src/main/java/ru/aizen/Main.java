package ru.aizen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.aizen.cards.Card;
import ru.aizen.config.AppConfig;
import ru.aizen.config.Configurator;
import ru.aizen.parser.CardXMLHandler;
import ru.aizen.parser.CardXMLSplitter;
import ru.aizen.parser.ParserUtils;
import ru.aizen.transform.TransformXML;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws Exception {
        Configurator.init();

        TransformXML transformXML = new TransformXML();
        transformXML.execute();

        CardXMLHandler handler = new CardXMLHandler();
        CardXMLSplitter splitter = new CardXMLSplitter(handler);
        ParserUtils.parseCardXML(new File(AppConfig.outputXmlPath), splitter);
        splitter.getTime();
        handler.bindHeropowersToHeroes();

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        Type type = new TypeToken<List<Card>>() {}.getType();
        String json = gson.toJson(CardXMLHandler.cards);
        try {
            FileWriter writer = new FileWriter(AppConfig.outputJsonPath, false);
            try{
                writer.write(json);
            }
            finally {
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
