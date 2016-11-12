package ru.aizen.cards;

import java.util.*;

public class Stats extends HashMap<String, String> {
    public static final String ID = "id";
    public static final String TYPE = "type";
    public static final String COLLECTIBLE = "collectible";
    public static final String NAME = "Name";
    public static final String TEXTURE = "Texture";
    public static final String SET = "Set";
    public static final String RARITY = "Rarity";
    public static final String CLASS = "Class";
    public static final String RACE = "Race";
    public static final String COST = "Cost";
    public static final String ATTACK = "Attack";
    public static final String HEALTH = "Health";
    public static final String DURABILITY = "Durability";
    public static final String DESCRIPTION = "Description";
    public static final String FLAVOR = "Flavor";
    public static final String ARTIST = "Artist";
    public static final String COMMON = "Common";
    public static final String GOLD = "Gold";

    public Stats(){

    }

    public void fillMetaData(String id, String type, String collectible){
        this.put(ID, id);
        this.put(TYPE, type);
        this.put(COLLECTIBLE, collectible);
    }

    public void fillStats(String key, String value) {
        this.put(key, value);
    }
}
