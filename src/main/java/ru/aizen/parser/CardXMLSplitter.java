package ru.aizen.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;

/**
 * Parser split large XML to small and handle them
 */
public class CardXMLSplitter extends DefaultHandler{
    private final String delimiterTag = "Card";
    private CardXMLHandler handler;
    private boolean flag;
    private XMLStreamWriter xmlWriter;
    private StringWriter result;

    private Long startTime;
    private Long endTime;
    private int partsCount = 0;

    public CardXMLSplitter(CardXMLHandler handler) throws XMLStreamException {
        this.handler = handler;
    }

    public String getTime(){
        String timeElapse = (endTime - startTime) + " ms";
        System.out.println(timeElapse);
        return timeElapse;
    }

    @Override
    public void startDocument() throws SAXException {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void endDocument() throws SAXException {
        endTime = System.currentTimeMillis();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equalsIgnoreCase(delimiterTag)) {
                result = new StringWriter();
                XMLOutputFactory factory = XMLOutputFactory.newFactory();
                xmlWriter = factory.createXMLStreamWriter(result);
                flag = true;
                xmlWriter.writeStartDocument("UTF-8", "1.0");
                xmlWriter.writeStartElement("Root");
            }
            if (flag){
                xmlWriter.writeStartElement(qName);
                if (attributes != null){
                    for (int i = 0; i < attributes.getLength(); i++){
                        xmlWriter.writeAttribute(attributes.getLocalName(i), attributes.getValue(i));
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println("An error occurred while create XML [CardXMLSplitter]\n" + e);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try {
            if (flag) {
                xmlWriter.writeEndElement();
            }
            if (qName.equalsIgnoreCase(delimiterTag)) {
                flag = false;
                xmlWriter.writeEndElement();
                xmlWriter.writeEndDocument();
                handler.doProcess(result.toString());
                result.flush();
                xmlWriter.flush();
                partsCount++;
            }
        } catch (XMLStreamException e) {
            System.out.println("An error occurred while create XML [CardXMLSplitter]\n" + e);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        try {
            if (flag){
               xmlWriter.writeCharacters(ch, start, length);
            }
        } catch (XMLStreamException e) {
            System.out.println("An error occurred while create XML [CardXMLSplitter]\n" + e);
        }

    }
}
