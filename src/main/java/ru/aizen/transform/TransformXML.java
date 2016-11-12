package ru.aizen.transform;

import ru.aizen.config.AppConfig;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformXML {
    private TransformerFactory factory;
    private String pattern;
    private String input;
    private String output;

    public TransformXML(){
        factory = TransformerFactory.newInstance();
        pattern = AppConfig.transformXsl;
        input = AppConfig.cardsXmlFolder + "/ruRu.xml";
        output = AppConfig.outputXmlPath;
    }

    public void execute() throws TransformerException {
        Transformer transformer = factory.newTransformer(new StreamSource(pattern));
    //    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    //    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    //    transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "5");
        StreamResult result = new StreamResult(output);
        StreamSource source = new StreamSource(input);
        transformer.transform(source, result);
    }
}
