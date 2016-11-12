package ru.aizen.parser;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.aizen.error.CardParserError;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public final class ParserUtils {

    private ParserUtils(){
        throw new AssertionError();
    }

    public static void parseCardXML(File file, CardXMLSplitter splitter) throws CardParserError {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, splitter);
        } catch (ParserConfigurationException e) {
            throw new CardParserError("Error. Can`t create document builder", e);
        } catch (SAXException e) {
            throw new CardParserError("Error, while parsing file. ", e);
        } catch (IOException e) {
            throw new CardParserError("Error. XML file not found. ", e);
        }

    }

    /**
     * Create document from execute file
     * @return document
     * @throws CardParserError errors
     */
    public static Document createXmlDocument(String xml) throws CardParserError {
        Document doc;
        DocumentBuilder builder;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
            return doc;
        } catch (ParserConfigurationException e) {
            throw new CardParserError("Error. Can`t create document builder", e);
        } catch (SAXException e) {
            throw new CardParserError("Error, while parsing file.", e);
        } catch (IOException e) {
            throw new CardParserError("Error. XML file not found. ", e);
        }
    }

    /**
     * Get boolean if type of node is ELEMENT_NODE
     * @param node node
     * @return true if type ELEMENT_NODE
     */
    public static boolean isNodeType(Node node){
        return node.getNodeType() == Node.ELEMENT_NODE;
    }


    /**
     * Get boolean if parameter name equals node name
     * @param node node
     * @param name name
     * @return true if parameter name equals node name
     */
    public static boolean isNodeName(Node node, String name){
        return isNodeType(node) && node.getNodeName().equals(name);
    }

    /**
     * Get list of elements with type ELEMENT_NODE
     * @param node parent node
     * @return list of element (child of node)
     */
    public static List<Element> getNodeList(Node node){
        List<Element> elements = new ArrayList<>();
        NodeList nodes = node.getChildNodes();
        int count = nodes.getLength();
        for (int i = 0; i < count; i++){
            Node child = nodes.item(i);
            if (isNodeType(child)){
                elements.add((Element)child);
            }
        }
        return elements;
    }
}
