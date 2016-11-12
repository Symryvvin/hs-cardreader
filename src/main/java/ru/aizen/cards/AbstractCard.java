package ru.aizen.cards;

import ru.aizen.enums.CardSet;
import ru.aizen.enums.CardType;

import java.util.Map;

public abstract class AbstractCard {
    protected String id;
    protected String name;
    protected String texture;
    protected CardSet set;
    protected CardType type;
    protected boolean collectible;
    protected String description;

    public AbstractCard() {

    }

    public void initGeneralStats(Stats stats){
        this.id = stats.get(Stats.ID);
        this.name = stats.get(Stats.NAME);
        this.texture = stats.get(Stats.TEXTURE);
        this.set = parseSet(stats.get(Stats.SET));
        this.collectible = parseCollectible(stats.get(Stats.COLLECTIBLE));
        this.description = stats.get(Stats.DESCRIPTION);
    }

    private boolean parseCollectible(String value){
        return Boolean.getBoolean(value);
    }

    private CardSet parseSet(String value){
        return CardSet.valueOf(value);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTexture() {
        return texture;
    }

    public CardSet getSet() {
        return set;
    }

    public CardType getType() {
        return type;
    }

    public boolean isCollectible() {
        return collectible;
    }

    public String getDescription() {
        return description;
    }
}
