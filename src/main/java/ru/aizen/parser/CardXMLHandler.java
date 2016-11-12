package ru.aizen.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.aizen.cards.*;
import ru.aizen.config.AppConfig;
import ru.aizen.config.ConfigUtils;
import ru.aizen.enums.CardType;
import ru.aizen.error.CardParserError;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CardXMLHandler {
    private Stats stats = new Stats();

    public static List<Card> cards = new ArrayList<>();
    public static List<Hero> heroes = new ArrayList<>();
    public static Map<String, Heropower> heropowers = new HashMap<>();

    private List<String> mechanics = new ArrayList<>();
    private List<String> entourages = new ArrayList<>();

    private final Properties textures = ConfigUtils.getResource(AppConfig.textureLocation);
    private final Properties hpDependencies = ConfigUtils.getResource("HEROPOWERS");

    public CardXMLHandler() throws IOException {
    }

    void doProcess(String xml){
        try {
            Document doc = ParserUtils.createXmlDocument(xml);
            parseXmlCard(doc);
            createCard();
        } catch (CardParserError cardParserError) {
            cardParserError.printStackTrace();
        }
    }

    /**
     * Parsing '<card>' attributes and stats (children nodes)
     * @param document card node
     */
    private void parseXmlCard(Document document){
        NodeList nodeList = document.getElementsByTagName("Card");
        Node node = nodeList.item(0);
        Element card = (Element) node;
        stats.fillMetaData(
                card.getAttribute(Stats.ID),
                card.getAttribute(Stats.TYPE),
                card.getAttribute(Stats.COLLECTIBLE));
        stats.put(Stats.TEXTURE, textures.getProperty(stats.get(Stats.ID)));
        parseStats(node);
    }

    /**
     * Parsing card node child nodes
     * @param card card nodes
     */
    private void parseStats(Node card){
        List<Element> cardStats = ParserUtils.getNodeList(card);
        for(Element element: cardStats){
            String name = element.getNodeName();
            String value = element.getTextContent();
            stats.fillStats(name, value);
            if (name.equals("Mechanics"))
                mechanics = parseNodeOccurrences(element, "value");
            if (name.equals("EntourageCards"))
                entourages = parseNodeOccurrences(element, "id");
        }
    }

    private List<String> parseNodeOccurrences(Node node, String attrName){
        List<String> list = new ArrayList<>();
        list.addAll(
                ParserUtils.getNodeList(node)
                        .stream()
                        .map(e -> e.getAttribute(attrName)).collect(Collectors.toList()));
        return list;
    }

    /**
     * Create a card, hero or heropower, set stats and put it to list
     * @throws CardParserError if can`t calculate dust by rarity
     */
    private void createCard() throws CardParserError {
        CardType type = CardType.valueOf(stats.get(Stats.TYPE));
        Card card = null;
        switch (type){
            case MINION:
                card = new Card.Minion(stats).create();
                break;
            case SPELL:
                card = new Card.Spell(stats).create();
                break;
            case WEAPON:
                card = new Card.Weapon(stats).create();
                break;
            case HERO:
                Hero hero = new Hero(stats);
                hero.initGeneralStats(stats);
                heroes.add(hero);
                break;
            case HEROPOWER:
                Heropower heropower = new Heropower(stats);
                heropower.initGeneralStats(stats);
                heropower.setCost(stats.get("Cost"));
                heropower.setUse(mechanics.contains("TRIGGER"));
                heropower.setAutoUse(mechanics.contains("AI_AUTOPLAY"));
                heropowers.put(heropower.getId(), heropower);
                break;
        }
        if (card != null){
            card.initGeneralStats(stats);
            card.initStats(stats);
            card.setMechanics(mechanics);
            card.setEntourageCards(entourages);
        }
            cards.add(card);
        stats.clear();
    }


    /**
     * Binding heropowers to all heroes
     * @throws CardParserError throw NullPointerException when hero heropower is "null"
     */
    public void bindHeropowersToHeroes() throws CardParserError {
        for(Hero h : heroes){
            try {
                h.setHeropowers(hpDependencies.getProperty(h.getId()));
            } catch (NullPointerException e){
                throw new CardParserError("There are no dependencies of hero and heropower yet. Please wait for update");
            }
        }
    }


}
